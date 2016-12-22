package com.myretail.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myretail.dto.PriceDto;
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

	@Autowired(required = false)
	protected ProductDtoHelper productDtoHelper;

	@Autowired(required = false)
	protected ProductPriceDtoHelper productPriceDtoHelper;

	@Override
	public List<ProductDto> findAll() {
		Iterable<Product> models = productRepository.findAll();
		return productDtoHelper.buildDto(models);
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
		ProductPrice productPrice = productPriceRepository.findOne(id);
		return buildProductDto(product, productPrice);
	}

	private ProductDto buildProductDto(Product product, ProductPrice productPrice) {
		ProductDto productDto = productDtoHelper.buildDto(product);
		if (productDto != null) {
			PriceDto priceDto = productPriceDtoHelper.buildDto(productPrice);
			productDto.setCurrentPrice(priceDto);
		}
		return productDto;
	}

	@Override
	public ProductDto save(ProductDto productDtoToInsert) {
		Product savedModel = productRepository.save(productDtoHelper.build(productDtoToInsert));

		ProductPrice productPrice = productPriceDtoHelper.build(productDtoToInsert);
		if (productPrice != null) {
			productPrice = productPriceRepository.save(productPrice);
		}

		return buildProductDto(savedModel, productPrice);
	}

	public ProductDto updateProductPrice(ProductDto dtoToUpdate) {
		ProductPrice productPrice = productPriceDtoHelper.build(dtoToUpdate);
		ProductPrice savedProductPrice = productPriceRepository.save(productPrice);

		Product product = productRepository.findOne(dtoToUpdate.getId());
		return buildProductDto(product, savedProductPrice);
	}

	@Override
	public void deleteAll() {
		productRepository.deleteAll();
	}
}
