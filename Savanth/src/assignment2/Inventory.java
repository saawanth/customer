package assignment2;

public class Inventory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    System.out.println("Name" +"\t" +"Price" +"\t" +"Quantity" +"\t" +"Value");
    System.out.println("=====================================================");
    Retailstore rt1 = new Retailstore("stapler", 2.25, 15);
    String name1 =rt1.getName();
	double price1 = rt1.getPrice();
	int quantity1 = rt1.getQuantity();
    double value1 = rt1.getValue();
    System.out.println( name1 +"\t" +price1+"\t" +quantity1 +"\t\t" +value1);
    Retailstore rt2 = new Retailstore("Paper", 32.99, 255);
    String name2 =rt2.getName();
	double price2 = rt2.getPrice();
	int quantity2 = rt2.getQuantity();
    double value2 = rt2.getValue();
    System.out.println( name2 +"\t" +price2+"\t" +quantity2 +"\t\t" +value2);
    Retailstore rt3 = new Retailstore("Binder", 4.75, 9);
    String name3 =rt3.getName();
	double price3 = rt3.getPrice();
	int quantity3 = rt3.getQuantity();
    double value3 = rt3.getValue();
    System.out.println( name3 +"\t$" +price3+"\t" +quantity3 +"\t\t" +value3);
    double total = value1 + value2 + value3;
    System.out.println("Total Inventory Is $"+ total);
    
}
}
