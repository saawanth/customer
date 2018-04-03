
public class Inventory {
	public static void main(String args[]){
		double totalInventory;
		Item i1 = new Item("Stapler", 2.25, 15);
		Item i2 = new Item("Paper", 32.99, 255);
		Item i3 = new Item("Binder", 4.75, 9);
		
		System.out.println("  ----JGRASP exec: java inventory");
		System.out.println("");
		
		System.out.println("Name" + "\t" + "Price" + "\t" + "Quantity" + "\t" + "Value");
		System.out.println("=======================================");
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		
	totalInventory = i1.getValue() + i2.getValue() + i3.getValue();
	
	System.out.println("");
	
		System.out.println("Total inventory is $" +totalInventory);
		
		System.out.println("");
		
		System.out.println("  ----JGRASP: operation complete.");
	}

}
