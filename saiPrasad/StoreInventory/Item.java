
public class Item {
	String name;
	double price;
	String catagory;
	
	public Item(String name,double price,String catagory){
		this.name=name;
		this.price=price;
		this.catagory=catagory;
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

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	
	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", catagory=" + catagory + "]";
	}
}
