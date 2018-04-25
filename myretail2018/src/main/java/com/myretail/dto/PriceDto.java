package com.myretail.dto;


import com.myretail.model.Currency;

public class PriceDto {

	private double price;
	private Currency currencyCode;

	public PriceDto() {

	}

	public PriceDto(double price, Currency currencyCode) {
		super();
		this.price = price;
		this.currencyCode = currencyCode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Currency getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(Currency currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Override
	public String toString() {
		return "PriceDto [price=" + price + ", currencyCode=" + currencyCode + "]";
	}
}
