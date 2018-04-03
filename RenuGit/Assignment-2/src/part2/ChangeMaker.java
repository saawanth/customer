package part2;

import java.util.Scanner;

public class ChangeMaker {
	
public static void main(String args[]){	
	
	int amtPaid;
	int amtOwed;
	Conversion cm = new Conversion();
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter the amount the customer paid:");
	amtPaid = sc.nextInt();
	cm.setAmountPaid(amtPaid);
	System.out.println("Enter the amount the customer owed:");
	amtOwed = sc.nextInt();
	cm.setAmountOwed(amtOwed);
	
	System.out.println("Their change is " +cm.getChange());
	System.out.println(cm.toString());
	sc.close();
}
}
