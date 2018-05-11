package Assignment2;

public class Item {
	String name;
	double price;
	int quantity;

	public Item(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	/*@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
*/
	public String getName() {
		return name;

	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getValue() {
		return quantity * price;
	
	}
	

}
