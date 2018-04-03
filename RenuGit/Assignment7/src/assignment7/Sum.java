package assignment7;

import java.util.Scanner;

public class Sum {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount: $");
		double amount = sc.nextDouble();
		
		int quarters = (((int) Math.round(amount)) * 100) / 25;
		int dimes = ((((int) (amount * 100)) % 100) /10);
		int cents = ((((int) (amount * 100)) % 100) % 10);
		
	 int sum = quarters + dimes + cents;
	 System.out.println("The sum is: "+sum);
	}
}
