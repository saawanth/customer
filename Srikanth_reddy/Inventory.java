package RetailStore;


public class Inventory 
{
	
public static void main(String[] args)
{
	Item i1=new Item("Stapler",2.25,15);
	Item i2=new Item("Paper",32.99,255);
	Item i3=new Item("Binder",4.75,9);
	
	//Create three objects for 
			/*Item i1 = new Item(null, 0, 0);
			Item i2 = new Item(null, 0, 0);
			Item i3 = new Item(null, 0, 0);
			
			//item1 record
			i1.setName("Stapler");
			i1.setPrice(2.25);
			i1.setQuantity(10);
			
			//item2 record
			i2.setName("Paper");
			i2.setPrice(32.99);
			i2.setQuantity(230);
			
			//item3 record
			i3.setName("Binder");
			i3.setPrice(4.75);
			i3.setQuantity(8);*/
	
	double totalInventory = i1.getValue()+i2.getValue()+i3.getValue(); 
	
	System.out.println("Name \t\t price \t\t Quantity \t  Value");
	System.out.println("========================================================");
	System.out.println(i1.getName()+"\t\t" + i1.getPrice()+ "\t\t"+ i1.getQuantity()+"\t\t"+ i1.getValue());
	System.out.println(i2.getName()+ "\t\t"+ i2.getPrice()+ "\t\t"+ i2.getQuantity()+"\t\t"+ i2.getValue());
	System.out.println(i3.getName()+ "\t\t"+ i3.getPrice()+ "\t\t"+ i3.getQuantity()+"\t\t"+ i3.getValue());
	
	System.out.println("\n"+"Total Inventory is "+ totalInventory);
	

}

}
