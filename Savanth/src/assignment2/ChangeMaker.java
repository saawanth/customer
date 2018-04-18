package assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChangeMaker {

  // public static void main throws MyException (String[] args)  //we can write our own exceptions
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Declare Variables
	      int paid = 0;      
	      int owed = 0;
	      int change = 0;
	      int dollars = 0;
	      int quarters = 0;
	      int dimes = 0;
	      int nickels = 0;
	      int pennies = 0;
	      
		  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	      System.out.print("Enter the amount the customer paid ");
	      try {
	    	  paid = Integer.parseInt(reader.readLine());
	      } catch (Exception e) {
	     	 System.err.println("Caught IOException: " + e.getMessage());
	      }
	      System.out.print("Enter the amount the customer owed ");
	      try {
	    	  owed = Integer.parseInt(reader.readLine());
	      } catch (Exception e) {
	     	 System.err.println("Caught IOException: " + e.getMessage());
	      }
	      change = paid - owed;
	      System.out.println("Their change is" + change);
	      double coins = change;
	      dollars = (int)(change/100);
	      coins %= 100;
	      quarters = (int)(change/25);
	      coins %= 25;
	      dimes = (int)(coins/10);
	      coins %= 10;
	      nickels = (int)(coins/5);
	      coins %= 5;
	      pennies = (int)(coins/1);
	      coins %= 1;
	      System.out.println("Dollars = " + dollars +"\tQuarters = " + quarters + "\tDimes = " + dimes + "\tNickels = " + nickels + "\tPennies = " + pennies);
	      
	      
	      
	}

}
