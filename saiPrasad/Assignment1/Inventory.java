package ass1;

public class Inventory {
public static void main(String args[]){
	Item obj1= new Item("ABC",2.0,3);
	Item obj2= new Item("DEF",3.0,5);
	Item obj3= new Item("IJK",6.0,10);
	Double total=obj1.getvalue()+obj2.getvalue()+obj3.getvalue();
	System.out.println("Name"+"\t"+"Price"+"\t"+"Quantity"+"\t"+"Value");
	System.out.println("===============================================");
	System.out.println(obj1.toString());
	System.out.println(obj2.toString());
	System.out.println(obj3.toString());
	
	System.out.println("Total Inventory is:"+ total);
}
}
