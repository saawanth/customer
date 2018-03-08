import java.util.Scanner;

public class BigAndSmall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double largest=0.0, smallest=0.0,num, sum=0;
		int i=0;
		Scanner sc= new Scanner(System.in);
		do {
		System.out.println("Enter the number or 0 to quit");
	     num=sc.nextDouble(); 
	    if(num==0) {
    		break;
    	}
	    	if(num>largest) {
	    		largest=num;
	    	}else
	    	if(num<smallest||smallest==0) {
	    		smallest=num;
	    	}
	    	
	    	 sum+= num;
	    	 i++;
	    
		}while(num!=0);		
		System.out.println("largest"+largest);
		System.out.println("smallest"+smallest);
		System.out.println("Mean"+sum/2);
	}	
		
}
	

