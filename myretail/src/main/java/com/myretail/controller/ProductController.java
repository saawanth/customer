package com.myretail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.dto.ProductDto;
import com.myretail.service.ProductService;

@RestController
@RequestMapping(URIConstants.PRODUCTS_URL)
public class ProductController extends BaseControllerImpl<Long, ProductDto> {

	@Autowired
	public ProductController(ProductService baseService) {
		super(baseService);
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ProductDto> update(@PathVariable Long productId,
			@RequestBody ProductDto productDto) {
		productDto.setId(productId);
		ProductDto updatedProductDto = ((ProductService) resourceService).updateProductPrice(productDto);
		return new ResponseEntity<ProductDto>(updatedProductDto, HttpStatus.OK);
	}
}
