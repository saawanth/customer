
public class Item {
	 String name;
	 double price;
	 int quantity;
	 double value;
//constructor 
	 
	 
	public Item(String Name,double Price,int Quantity) {
		// TODO Auto-generated constructor stub
		Name=name;
		Price=price;
		Quantity=quantity;
	}
	public Item() {
	super();
}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getValue() {
		value=quantity*price;
		return value;
	}
	
	public void setVaue(double value) {
		this.value=value;
	}
	@Override
	public String toString() {
		return "item [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	



}


