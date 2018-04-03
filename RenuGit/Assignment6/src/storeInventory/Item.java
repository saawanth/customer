package storeInventory;

import java.util.Comparator;

public class Item implements Comparable<Item> {

	private String model;
	private Double cost;
	private String item;

	public Item(String model, double cost, String item) {
		super();
		this.model = model;
		this.cost = cost;
		this.item = item;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return model + "," + cost + "," + item;
	}

	public int compareTo(Item arg0) {
		if(arg0.getCost() == this.getCost()){
			return this.getModel().compareTo(arg0.getModel());
		}
		return (arg0.getCost().compareTo(this.getCost()));
		}
}
