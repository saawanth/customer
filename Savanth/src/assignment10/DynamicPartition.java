package assignment10;

import java.util.Arrays;
import java.util.Scanner;

//
//This Program only returns weather dynamic partion can be done or not 
// Return True Or False
public class DynamicPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the size of array");
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] arr;
		arr = new int[n];
		System.out.println("Enter the array Values");
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(Arrays.toString(arr));

		if (findPartition(arr, n) == true)
			System.out.println("Can be divided into two ");
		else
			System.out.println("Can not be divided into");
		/*
		 * System.out.println("Enter the size of array"); in = new Scanner(System.in);
		 * int arr[] = {3, 1, 5, 9, 12}; int n = Array.getLength(arr); if
		 * (findPartition(arr, n) == true)
		 * System.out.println("Can be divided into two "); else
		 * System.out.println("Can not be divided into");
		 */

	}

	private static boolean findPartition(int[] arr, int n) {

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];

		}
		// System.out.println(sum);
		if (sum % 2 != 0) {
			return false;
		}

		return isSubsetSum(arr, n, sum / 2);
	}

	private static boolean isSubsetSum(int[] arr, int n, int sum) {

		if (sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;

		if (arr[n - 1] > sum)
			return isSubsetSum(arr, n - 1, sum);

		return isSubsetSum(arr, n - 1, sum) || isSubsetSum(arr, n - 1, sum - arr[n - 1]);
	}

}
