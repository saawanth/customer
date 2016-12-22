package com.myretail.dto.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myretail.dto.ProductDto;
import com.myretail.model.Product;

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
		return null;
	}
}
