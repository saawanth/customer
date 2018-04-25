package com.myretail.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.dto.ProductDto;
import com.myretail.dto.helper.ProductDtoHelper;
import com.myretail.dto.helper.ProductPriceDtoHelper;
import com.myretail.model.Product;
import com.myretail.model.ProductPrice;
import com.myretail.repository.ProductPriceRepository;
import com.myretail.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	protected ProductRepository productRepository;

	@Autowired
	protected ProductPriceRepository productPriceRepository;

	@Autowired
	protected ProductDtoHelper productDtoHelper;

	@Autowired
	protected ProductPriceDtoHelper productPriceDtoHelper;

	@Autowired
	private RestTemplate restTemplate;

	private static final String resourceUrl = "https://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";

	@Override
	public List<ProductDto> findAll() {
		Iterable<Product> models = productRepository.findAll();
		Iterable<ProductPrice> modelPrices = productPriceRepository.findAll();
		return productDtoHelper.buildDto(models, modelPrices);
	}

	@Override
	public List<ProductDto> findAll(Iterable<Long> ids) {
		Iterable<Product> models = productRepository.findAll(ids);
		return productDtoHelper.buildDto(models);
	}

	@Override
	public List<ProductDto> save(Iterable<ProductDto> dtos) {
		Iterable<Product> modelsToSave = productDtoHelper.build(dtos);
		List<ProductDto> savedDtos = productDtoHelper.buildDto(productRepository.save(modelsToSave));
		return savedDtos;
	}

	@Override
	public ProductDto findOne(Long id) {
		Product product = productRepository.findOne(id);
		if (product != null) {
			String productName = findProductNameFromExtApi(id);
			if (productName == null) {
				productName = product.getName();
			}

			ProductPrice productPrice = productPriceRepository.findOne(id);
			return buildProductDto(product, productName, productPrice);
		} else {
			return null;
		}
	}

	private String findProductNameFromExtApi(Long id) {
		ResponseExtractor<String> resExtractor = new ResponseExtractor<String>() {
			public String extractData(ClientHttpResponse response) throws IOException {
				return lookupValueInJson(response.getBody(), "product", "item", "product_description", "title");
			}
		};
		return restTemplate.execute(resourceUrl, HttpMethod.GET, null, resExtractor, id);
	}

	private String lookupValueInJson(InputStream responseAsStream, String... keysToLookup)
			throws IOException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(responseAsStream);
		String responseStr = null;
		for (String keyToLookup : keysToLookup) {
			JsonNode lookedupJsonNode = jsonNode.get(keyToLookup);
			if (lookedupJsonNode != null) {
				jsonNode = lookedupJsonNode;
				responseStr = jsonNode.asText();
			} else {
				responseStr = null;
				break;
			}
		}
		return responseStr;
	}

	private ProductDto buildProductDto(Product product, String name, ProductPrice productPrice) {
		ProductDto productDto = productDtoHelper.buildDto(product);
		productDto.setName(name);
		productDto.setCurrentPrice(productPriceDtoHelper.buildDto(productPrice));
		return productDto;
	}

	@Override
	public ProductDto save(ProductDto productDtoToInsert) {
		Product savedModel = productRepository.save(productDtoHelper.build(productDtoToInsert));
		ProductPrice productPrice = productPriceDtoHelper.build(productDtoToInsert.getCurrentPrice());
		if (productPrice != null) {
			productPrice = productPriceRepository.save(productPrice);
		}

		String productName = findProductNameFromExtApi(savedModel.getId());
		if (productName == null) {
			productName = savedModel.getName();
		}
		return buildProductDto(savedModel, productName, productPrice);
	}

	public ProductDto updateProductPrice(ProductDto dtoToUpdate) {

		if (dtoToUpdate.getCurrentPrice() != null) {
			ProductPrice productPrice = productPriceDtoHelper.build(dtoToUpdate.getCurrentPrice());
			ProductPrice savedProductPrice = productPriceRepository.save(productPrice);

			Product product = productRepository.findOne(dtoToUpdate.getId());

			String productName = findProductNameFromExtApi(product.getId());
			if (productName == null) {
				productName = product.getName();
			}
			return buildProductDto(product, productName, savedProductPrice);
		} else {
			return dtoToUpdate;
		}
	}

	@Override
	public void deleteAll() {
		productRepository.deleteAll();
		productPriceRepository.deleteAll();
	}
}
