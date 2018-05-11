package Assignment3;

import java.util.Scanner;

public class Splitarray {

	public static void main(String[] args) {
		int summation = 0;
		int count = 0;
	int[]fpart;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the array length");
		int input = sc.nextInt();
		int[] x = new int[input];
		System.out.println("enter the number");
		sc.close();
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		int total = 0;
		for (int i = 0; i < x.length; i++) {
			total += x[i];
		}
		System.out.println("array total:" + total);
		int sum = total / 2;
		System.out.println("sum: " + sum);
		if (total % 2 == 0) {
			for (int j = 0; j < x.length; j++) {

				if (j == 0 && x[j] == sum) {
					int[] y = new int[7];
					for (int k = 0; k < y.length; k++) {
						y[k] = x[j];
					}

				} else {

					if (summation != sum && (j <= (x.length) - 1)) {
						summation += x[j];

						if (summation == sum) {
							count = j;
						}
					} else if (count != 0) {
						int[] fPart = new int[j];

					} else {
						System.out.println("array can not be split");

					}
				}

			}

		} else {
			System.out.println("The array cannot be split");
		}

	}
}