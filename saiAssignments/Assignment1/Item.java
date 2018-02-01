 package ass1;

public class Item {
	
	String Name;
	double Price;
	int Quantity;
	double Value;
	public Item(String name,double price, int quantity){
		Name = name;
		Price= price;
		Quantity = quantity;
	}
	public String getname(){
	
		return Name;
	
	}
	
	public double getprice(){
		
		return Price;
		
	}
	public int getquantity(){
	
		return Quantity;
		
	}
	public double getvalue(){
		Value= Price*Quantity;
		return Value;
	}
	public String toString(){
		return getname()+"\t"+getprice()+"\t"+getquantity()+"\t\t"+getvalue();
		
	}

}

