package com.routeone.interview;

public class Item {

	private String name;
	private String category;
	private double price;

	public Item(String name, String category, double price) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static class Builder {
		private String name;
		private String category;
		private double price;

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withCategory(String category) {
			this.category = category;
			return this;
		}

		public Builder withPrice(String priceAsStr) {
			this.price = Double.parseDouble(priceAsStr);
			return this;
		}

		public Item build() {
			return new Item(name, category, price);
		}
	}
}