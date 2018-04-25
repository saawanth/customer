package com.myretail.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ProductDto {

	private Long id;
	private String name;
	private String brand;

	@JsonProperty("current_price")
	private PriceDto currentPrice;

	public ProductDto() {
	}

	public ProductDto(Long id, String name, String brand) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public PriceDto getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(PriceDto currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ProductDto [id=" + id + ", name=" + name + ", brand=" + brand);

		if (currentPrice != null) {
			sb.append(", currentPrice=").append(currentPrice).append("]");
		}

		return sb.toString();
	}
}
