package ass1;

import java.util.Scanner;

public class ChangeMaker {

	
	public static void main(String[] args) {
		int amountpaid;
		int amountowed;
		int change;
		int dollars;
		int quarters;
		int dimes;
		int nikals;
		int pennis;
		int rem_change;
		int rem_change1;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the amount cutomer paid:");
		amountpaid = in.nextInt();
		
		System.out.println("Enter the amount cutomer owed:");
		amountowed = in.nextInt();
		
		change = amountpaid-amountowed;
		System.out.println("Their change is:"+change);
		
		dollars= change/100;
		rem_change = change%100;
		quarters= rem_change/25;
		rem_change1= rem_change%25;
		dimes=rem_change1/10;
		nikals= rem_change1/5;
		pennis= rem_change1/1;
		
		System.out.println("Dollars "+ dollars +",quarters "+ quarters +",Dimes "+ dimes +",Nikals "+ nikals +",Pennis "+ pennis);
	}

}
