package Assign2;

import java.util.Scanner;

public class ChangeMaker {

	public static void main(String args[]){
	Change change = new Change();
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the amount the customer paid: ");
	int cusPaid = scan.nextInt();
	change.setAmtCusPaid(cusPaid);
	System.out.println("Enter the amount the customer owed: ");
	int cusOwed = scan.nextInt();
	change.setAmtCusOwed(cusOwed);
	scan.close();
	System.out.println("Their change is " + change.getChange());
	System.out.println(change.toString());
	
	
	
	
	
	
	
}
}
