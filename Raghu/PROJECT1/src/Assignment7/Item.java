package Assignment7;

public class Item implements Comparable<Item> {
	public String componentName;
	public double price;
	public String category;

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
	public int compareTo(Item arr) {
		if (arr.price == this.getPrice()) {
			return this.componentName.compareTo(arr.componentName);
		}
		return (int) (arr.getPrice() - this.getPrice());
	}
}
