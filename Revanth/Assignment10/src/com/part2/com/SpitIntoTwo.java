package com.part2.com;

import java.util.Scanner;

public class SpitIntoTwo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the length of the array: ");
		int size = scan.nextInt();
		System.out.println("Enter the array of numbers: ");
		int nums[] = new int[size];
		double sum = 0;
		for (int i = 0; i < size; i++) {
			nums[i] = scan.nextInt();
			sum = sum + nums[i];
		}
		
		
		scan.close();
		double half = sum / 2;
		int temp = 0;
		int i = 0;
		int count = 0;
		int part = 0;
		int test = 0;
		while (i < size) {
			count++;
			if (!((sum % 2) == 0)) {
//				System.out.println("sum: " + half);
				System.out.println("It is NOT possible!");
				break;
			}

			temp = temp + nums[i];
			if (temp == half) {
				System.out.println("It is possible: ");
				test++;
				part = i;
				break;
			} else if (count == size) {
				System.out.println("It is NOT possible!!!");
			}
			i++;
		}
//		System.out.println(part);
//		System.out.println(test);
		if(test > 0){
			System.out.print("[");
			for (int p = 0; p <= part; p++) {
				System.out.print(nums[p] + " ");
				if (p == part) {
					System.out.print("]");
				}
			}
			System.out.print(", [");
			for (int p = (part + 1); p < size; p++) {
				System.out.print(nums[p] + " ");
				if (p + 1 == size) {
					System.out.print("]");
				}
			}
		}
	}
}
