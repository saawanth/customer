import java.util.Scanner;

public class Die {


	public static void main(String[] args) {
		
		double base=10.00;
		double betamount;
		double total=0;
		Scanner in= new Scanner(System.in);
		for(int i=0;i<20;i++)
			
		{	
	System.out.println("You have $"+base);
	
	System.out.print("How much would you like to bet:");
	betamount=in.nextDouble();
	

		    int dice1=(int)(Math.random()*6+1);
		    int dice2=(int)(Math.random()*6+1);
		    
		  
		    System.out.println("You have rolled "+dice1+" and "+dice2); 
		    
		   if(base!=0) {
		    if (dice1==dice2) {
		    		total=betamount+betamount;
		    		base=base+total;
		        System.out.println("You win: $"+total);
		    } else {
		    	total=base-betamount;
		    	base=base-betamount;
		        System.out.println("You lose: $"+betamount);
		    }
		   }else {
			   System.out.print("Better luck next time");
			   break;
		   }
		  
		    }
		 in.close();
}
}
