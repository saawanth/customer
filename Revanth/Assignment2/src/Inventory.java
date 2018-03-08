
public class Inventory {

	public static void main(String[] args) {
		Item item1 = new Item("Stapler", 2.25, 15);
		Item item2 = new Item("Paper", 32.99, 255);
		Item item3 = new Item("Binder", 4.75, 9);
		
		System.out.println("Name" + "\t" + "Price" + "\t" + "Quantity" + " " + "Value");
		System.out.println("=====================================");
		System.out.println(item1.toString());
		System.out.println(item2.toString());
		System.out.println(item3.toString());
		
		double total = item1.getValue() + item2.getValue() + item3.getValue();
		System.out.println("\nTotal Inventory is $" + total);

	}

}
