package assignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pay
{
      public static void main(String [] args)
   {
   // Declare Variables
      double hoursWorked = 0.0;      
      double hourlyPayRate = 0.0;
      double grossPay = 0.0;
    
   // take the following variables from the user from command promt.
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("How many hours did you work? ");
      try {
    	  hoursWorked = Double.parseDouble(reader.readLine());
      } catch (Exception e) {
     	 System.err.println("Caught IOException: " + e.getMessage());
      }
      System.out.print("How much do you get paid per hour? ");
      try {
    	  hourlyPayRate = Double.parseDouble(reader.readLine());
      } catch (Exception e) {
     	 System.err.println("Caught IOException: " + e.getMessage());
      }
    if (hoursWorked <= 40) {
    	grossPay =  hoursWorked * hourlyPayRate;
    }else if (hoursWorked > 40) {
    	grossPay =  (hoursWorked * 1.5) * hourlyPayRate;
    }
// Display the results
	System.out.println("You earned $" + grossPay);
	
	double taxesPer = grossPay * 0.33;
	
	System.out.println("Taxes are $" + String.format("%.2f", taxesPer));
	
	double netPay = grossPay - taxesPer;
	System.out.println("Your net pay is $" + String.format("%.2f", netPay));
	
}
}