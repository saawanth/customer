package ass1;
import java.util.Scanner;

public class Pay {
	
	
	      public static void main(String [] args)
	   {
	   // Declare Variables
	      double hoursWorked;      
	      double hourlyPayRate;
	      double grossPay = 0;
	      double taxes;
	      double netPay;
	      
	      Scanner in = new Scanner(System.in);
	      
	      //get hours worked
	      System.out.println("Enter hoursWorked:");
	      hoursWorked = in.nextDouble();
	      
	      //get payRate
	      System.out.println("Enter hourlyPayRate:");
	      hourlyPayRate= in.nextDouble();
	      
	      if(hoursWorked<=40) 	      
	      grossPay= hoursWorked*hourlyPayRate;
	      
	      else if(hoursWorked>40)
	   	  grossPay= hoursWorked*(1.5*hourlyPayRate);
	 System.out.println("You earned $" + grossPay);
	 
	 taxes= grossPay*33/100;
	 System.out.println("Taxes are $"+ taxes);
	 
	 netPay= grossPay-taxes;
	 
	 System.out.println("Your netPay is $"+ netPay);
	    }
	}

	

