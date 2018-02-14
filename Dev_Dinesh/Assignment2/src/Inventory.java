
public class Inventory {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub'
Item obj1=new Item(null,0,0);
Item obj2=new Item(null,0,0);
Item obj3=new Item(null,0,0);

obj1.setName("Stapler");
obj1.setPrice(2.25);
obj1.setQuantity(15);

obj2.setName("Paper");
obj2.setPrice(32.99);
obj2.setQuantity(255);

obj3.setName("Binder");
obj3.setPrice(4.75);
obj3.setQuantity(9);



System.out.println("Name"+"\t"+"Price"+"\t"+"Quantity"+"\t  "+"Value");
System.out.println("=================================");
System.out.print(obj1.getName()+"\t$"+obj1.getPrice()+"\t"+obj1.getQuantity()+"\t  $"+obj1.getValue()+"\n");
System.out.print(obj2.getName()+"\t$"+obj2.getPrice()+"\t"+obj2.getQuantity()+"\t  $"+obj2.getValue()+"\n");
System.out.print(obj1.getName()+"\t$"+obj3.getPrice()+"\t"+obj3.getQuantity()+"\t  $"+obj3.getValue()+"\n");
double inventory=obj1.getValue()+obj2.getValue()+obj3.getValue();
System.out.println("Total Inventory is $"+inventory);
	}

}
