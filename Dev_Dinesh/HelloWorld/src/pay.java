import java.util.Scanner;

public class pay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		  double hoursWorked;      
	      double hourlyPayRate;
	      double grossPay;
	      double Taxes;
	      double Netpay;
	      System.out.println("How many hours did you work? ");
	      hoursWorked= in.nextDouble();
	      System.out.println("How much do you get paid per hour? ");
	      hourlyPayRate=in.nextDouble();
	      in.close();
	      if(hoursWorked<40) {
	    	  grossPay=hoursWorked*hourlyPayRate;
	      }
	    	  else{
	    		  grossPay=hoursWorked*(1.5*hourlyPayRate);
	    	  }
	    	  Taxes= (grossPay*33)/100;
	    	  Netpay= grossPay-Taxes;
	    	  
	    	  //displaying output results
	    	  System.out.println("You earned: "+grossPay);
	    	  System.out.println("Taxes: "+ Taxes);
	    	  System.out.println("Your Netpay is: "+Netpay);
	      }
	      
	}


