package Part3;

import java.util.Scanner;

public class BigAndSmall {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		double num = 0;
		int count = 0;
		double large = 0;
		double small = 0;
		double add = 0;
		double single = 0;

		do {
			count = count + 1;
			System.out.println("Enter a number or 0 to quit:");
			num = scan.nextDouble();
			if (count ==1 && num == 0) {
				System.out.println("You did not enter any numbers");
				break;
			}
			if(num == 0){
				break;
			}
			if (num > large) {
				large = num;
			}
			
			if(count == 1){
				small = num;
			}
			if(count == 1){
				single = num;
			}
			//System.out.println("num: "+num);
			
			if(num < small){
				small = num;
			}
			//System.out.println("small: "+small);
			add = add + num;
			
		} while (num > 0);
		if (count == 2) {
			//System.out.println("Final Count:" + count);
			System.out.println("Largest: " + single);
			System.out.println("Smallest: " + single);
			System.out.println("Mean: " + single);
		
		}
		else if(count > 2) {
			System.out.println("Largest: " + large);
			System.out.println("Smallest: " + small);
			System.out.println("Mean: " + add / (count-1));
		}
	}
}
