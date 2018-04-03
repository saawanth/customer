package part3;

import java.util.Scanner;

public class BigAndSmall {

	public static void main(String args[]) {

		double number = 0;
		int count = 0;
		double temp = 0;
		double tempmax = 0;
		double tempmin = 0;
		double average = 0;

		Scanner sc = new Scanner(System.in);

		while (number >= 0) {

			try {
				System.out.println("Enter a number or 0 to quit:");
				number = sc.nextDouble();
			} catch (Exception e) {
				System.out.println("Error!");
			}
			count++;
			average = average + number;
				while (number != 0) {
				temp = number;
				break;
			}
			if (number == 0 & count == 1) {
				System.out.println("You did not enter any numbers!");
				break;
			}
			if (number == 0){
				break;
			}

				if (number > tempmax) {
					tempmax = number;
				}
				if (number > tempmin & count == 1) {
					tempmin = number;
				}
				if (number < tempmin) {
					tempmin = number;
				}				
					}
				
		if (count > 2) {
			System.out.println(average);
			System.out.println("Largest " + tempmax);
			System.out.println("Smallest " + tempmin);
			System.out.println("Average " + average / (count - 1));
		}

		if (count == 2 & number == 0) {
			
			System.out.println("Largest " + temp);
			System.out.println("Smallest " + temp);
			System.out.println("Average " + temp);
					}
	}
}
