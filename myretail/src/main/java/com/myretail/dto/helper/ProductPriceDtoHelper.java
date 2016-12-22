package com.myretail.dto.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.myretail.dto.PriceDto;
import com.myretail.dto.ProductDto;
import com.myretail.model.ProductPrice;

@Component
public class ProductPriceDtoHelper implements DtoHelper<ProductPrice, PriceDto> {

	public PriceDto buildDto(ProductPrice productPrice) {
		PriceDto priceDto = null;
		if (productPrice != null) {
			priceDto = new PriceDto();
			priceDto.setPrice(productPrice.getPrice());
			priceDto.setCurrencyCode(productPrice.getCurrencyCode());
		}
		return priceDto;
	}

	public ProductPrice build(PriceDto priceDto) {
		ProductPrice productPrice = null;
		if (priceDto != null) {
			productPrice = new ProductPrice();
			// product.setId(priceDto.getId());
			productPrice.setPrice(priceDto.getPrice());
			productPrice.setCurrencyCode(priceDto.getCurrencyCode());
		}
		return productPrice;
	}

	public ProductPrice build(ProductDto productDto) {
		ProductPrice productPrice = null;
		if (productDto != null && productDto.getCurrentPrice() !=null) {
			productPrice = new ProductPrice();
			productPrice.setProductId(productDto.getId());
			productPrice.setPrice(productDto.getCurrentPrice().getPrice());
			productPrice.setCurrencyCode(productDto.getCurrentPrice().getCurrencyCode());
		}
		return productPrice;
	}

	@Override
	public List<PriceDto> buildDto(Iterable<ProductPrice> models) {
		return null;
	}

	@Override
	public List<ProductPrice> build(Iterable<PriceDto> dtos) {
		return null;
	}
}
