
import java.util.Scanner;

public class Doubles {
	
	public static void main(String[] args) {
		
		
		double base=10.00;
		double betamount;
		double total=0;
		int roll;
		Scanner in= new Scanner(System.in);
		
for(int i=0;i<20;i++){
	
	System.out.println("You have $"+base);
	System.out.print("How much would you like to bet:");
	betamount=in.nextDouble();
	
	Die1 d1=new Die1();
	Die1 d2=new Die1();
	
	roll=d1.roll();
	d1.setDieValue(roll);
	roll=d2.roll();
	d2.setDieValue(roll);
	
	//d1.setDieValue(randomNum);
	System.out.println("You have rolled "+d1.toString()+" and "+d2.toString());
	
	 if(base!=0) {
		    if (d1.equals(d2)) {
		    		total=betamount+betamount;
		    		base=base+total;
		        System.out.println("You win: $"+total);
		    } else {
		    	total=base-betamount;
		    	base=base-betamount;
		        System.out.println("You lose: $"+betamount);
		    }
		   }
	 if(base==0) {
		 System.out.println("You have: $0.0");
		 System.out.print("Better luck next time");
		 break;
		   }
		
	}
in.close();
}

	
}
