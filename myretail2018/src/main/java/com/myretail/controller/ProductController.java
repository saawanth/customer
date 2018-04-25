package com.myretail.controller;

import java.util.List;

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
public class ProductController {

	@Autowired
	protected ProductService resourceService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<ProductDto>> findAll() {
		List<ProductDto> dtoList = resourceService.findAll();
		return new ResponseEntity<List<ProductDto>>(dtoList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ProductDto> findOne(@PathVariable long id) {
		ProductDto dt = resourceService.findOne(id);
		return new ResponseEntity<ProductDto>(dt, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ProductDto> add(@RequestBody ProductDto dto) {
		ProductDto dt = resourceService.save(dto);
		return new ResponseEntity<ProductDto>(dt, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ProductDto> update(@RequestBody ProductDto dto) {
		ProductDto updatedResource = resourceService.save(dto);
		return new ResponseEntity<ProductDto>(updatedResource, HttpStatus.OK);
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ProductDto> update(@PathVariable Long productId,
			@RequestBody ProductDto productDto) {
		productDto.setId(productId);
		ProductDto updatedProductDto = ((ProductService) resourceService).updateProductPrice(productDto);
		return new ResponseEntity<ProductDto>(updatedProductDto, HttpStatus.OK);
	}
}
