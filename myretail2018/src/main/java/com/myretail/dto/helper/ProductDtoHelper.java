package com.myretail.dto.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myretail.dto.PriceDto;
import com.myretail.dto.ProductDto;
import com.myretail.model.Product;
import com.myretail.model.ProductPrice;

@Component
public class ProductDtoHelper implements DtoHelper<Product, ProductDto> {

	public ProductDto buildDto(Product product) {
		ProductDto productDto = null;
		if (product != null) {
			productDto = new ProductDto();
			productDto.setId(product.getId());
			productDto.setName(product.getName());
		}
		return productDto;
	}

	public Product build(ProductDto productDto) {
		Product product = null;
		if (productDto != null) {
			product = new Product();
			product.setId(productDto.getId());
			product.setName(productDto.getName());
			product.setId(productDto.getId());
		}
		return product;
	}

	@Override
	public List<ProductDto> buildDto(Iterable<Product> models) {
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		if (models != null) {
			for (Product product : models) {
				productDtos.add(buildDto(product));
			}
		}
		return productDtos;
	}

	@Override
	public List<Product> build(Iterable<ProductDto> dtos) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<ProductDto> buildDto(Iterable<Product> models, Iterable<ProductPrice> modelPrices) {
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		ProductPriceDtoHelper productPriceDtoHelper = new ProductPriceDtoHelper();
		ProductDto productDto = null;
		if (models != null) {
			for (Product product : models) {
				if (modelPrices != null ) {
					productDto = buildDto(product);
					for (ProductPrice productPrice : modelPrices) {
						if ( productPrice.getProductId() == product.getId()){
							PriceDto pDto = productPriceDtoHelper.buildDto(productPrice);
							productDto.setCurrentPrice(pDto);
							break;
						}
					}
					productDtos.add(productDto);
				}
			}
		}
		return productDtos;
	}


	public ProductDto buildDto(Product product, ProductPrice productPrice) {
		ProductDto productDto = null;
		if (product != null) {
			productDto = new ProductDto();
			productDto.setId(product.getId());
			productDto.setName(product.getName());
			if ( productPrice != null) {
				PriceDto pDto = new PriceDto();
				pDto.setPrice(productPrice.getPrice());
				productDto.setCurrentPrice(pDto);
			}
		}
		return productDto;
	}

}
