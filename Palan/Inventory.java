

public class Inventory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Items c= new Items("pencil",2.0, 1 );
		Items c1= new Items("paper",1.0, 2);
		Items c2= new Items("pen",3.0, 3);
		double Total= c.getValue()+c1.getValue()+c2.getValue();
		System.out.println("Name"+"\t" +"Price"+"\t\t"+"Quantity"+"\t"+"Value");
		System.out.println("=========================================================");
		System.out.println(c.toString());
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println("Total"+"\t"+ Total);
		
		
		
	}

}
