
public class Item {

	String ComponentName;
	double price;
	String Category;

	public Item(String ComponentName, double price, String Category) {
		this.ComponentName = ComponentName;
		this.price = price;
		this.Category = Category;
	}

	public String getComponentName() {
		return ComponentName;
	}

	public void setComponentName(String componentName) {
		ComponentName = componentName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	@Override
	public String toString() {
		return "ComponentName=" + ComponentName + ", price=" + price + ", Category=" + Category;
	}


}
