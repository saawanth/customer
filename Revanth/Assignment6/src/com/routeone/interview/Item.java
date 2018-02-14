package com.routeone.interview;

public class Item implements Comparable<Item> {
	private String componentName;
	private double price;
	private String category;
	
public Item(){
	
}
	public Item(String componentName, double price, String category) {
		this.componentName = componentName;
		this.price = price;
		this.category = category;
		
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Item [componentName=" + componentName + ", price=" + price + ", category=" + category + "]";
	}

	@Override
	public int compareTo(Item arg0) {
		// TODO Auto-generated method stub
		if(arg0.price==this.getPrice()){
			return this.componentName.compareTo(arg0.componentName);
		}
		return (int) (arg0.getPrice() - this.getPrice());
	}
}
