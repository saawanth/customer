package com.myretail.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product_prices")
public class ProductPrice {

	@Id
	private long productId;
	private double price;
	private Currency currencyCode;

	public ProductPrice() {
		super();
	}

	public ProductPrice(long productId, double price, Currency currencyCode) {
		super();
		this.productId = productId;
		this.price = price;
		this.currencyCode = currencyCode;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Currency getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(Currency currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Override
	public String toString() {
		return "ProductPrice [productId=" + productId + ", price=" + price + ", currencyCode=" + currencyCode + "]";
	}
}
