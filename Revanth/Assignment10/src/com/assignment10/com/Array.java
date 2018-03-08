package com.assignment10.com;

import java.util.Scanner;

public class Array {
	public static void main(String[] args) {

//		int[] nums = { 1, 2, 3, 4, 5 };
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the array of five(5) Numbers: ");
		int[] nums = new int[5];
		nums[0] = scan.nextInt();
		nums[1] = scan.nextInt();
		nums[2] = scan.nextInt();
		nums[3] = scan.nextInt();
		nums[4] = scan.nextInt();
		scan.close();
		
		int count = 0;
		int products[] = new int[5];

		System.out.print("[");
		for (int i = 0; i < nums.length; i++) {
			
			int prod = 1;
			System.out.print("(");
			for (int j = 0; j < nums.length; j++) {
				if (j != count) {
					if (j + 1 == nums.length) {
						System.out.print(nums[j]);
						prod = prod * nums[j];
					} else {
						System.out.print(nums[j] + "*");
						prod = prod * nums[j];

					}
				}

			}
			products[i] = prod;
			count++;
			if (count < 5) {
				System.out.print("), ");
			} else {
				System.out.print(")");
			}
		}
		System.out.print("] = [");

		for (int pr : products) {
			
			System.out.print(pr + " ");
		}
		System.out.println("]");
	}
}