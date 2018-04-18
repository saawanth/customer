package assignment2;

public class Retailstore {
	private String name;
	private double price;
	private int quantity;
	
	
/*	A constructor in Java is a block of code similar to a method that's
	called when an instance of an object is created. Here are the key differences 
	between a constructor and a method: A constructor doesn't have a return type. ...
	Unlike methods, constructors are not considered members of a class.*/
	
	public Retailstore(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}


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
