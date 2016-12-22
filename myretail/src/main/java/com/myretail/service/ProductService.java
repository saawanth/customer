package com.myretail.service;

import com.myretail.dto.ProductDto;

public interface ProductService extends BaseService<Long, ProductDto> {

	void deleteAll();

	ProductDto updateProductPrice(ProductDto dtoToUpdate);

}
