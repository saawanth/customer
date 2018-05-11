package Assignment3;

import java.util.Scanner;

public class splitarray1 {

	public static void main(String[] args) {
		System.out.println("Enter the length of array");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[] array, size1, size2;
		array = new int[a];
		int total = 0, firstpart = 0, secondpart, x = 0;
		int sum1 = 0;
		int sum2 = 0;
		System.out.println("Enter the numbers");
		sc.close();
		for (int i = 0; i < a; i++) {

			array[i] = sc.nextInt();
			total = total + array[i];
		}
		System.out.println(total);
		if (total % 2 == 0) {
			for (int i = 0; i < a; i++) {
				sum1 = sum1 + array[i];
				firstpart++;
				sum2 = 0;
				for (int j = i + 1; j < a; j++) {
					sum2 = sum2 + array[j];
				}
				if (sum1 == sum2) {
					break;
				}

			}
			secondpart = a - firstpart;
			size1 = new int[firstpart];
			size2 = new int[secondpart];
			System.out.println("first half");
			for (int i = 0; i < firstpart; i++) {
				size1[i] = array[i];
				x++;
				System.out.println(size1[i]);
			}
			System.out.println("second half");
			for (int j = 0; j < secondpart; j++) {
				size2[j] = array[x];
				x++;
				System.out.println(size2[j]);
			}

		} else
			System.out.println("We cannot perform split operation on this array");
	}

}
