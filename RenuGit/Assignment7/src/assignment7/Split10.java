package assignment7;

import java.util.Scanner;

public class Split10 {
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String args[]) {

		// Example 1 : Input : [ 1,6,7,10,2,1,1] Output : [1,6,7 ] , [10,2,1,1 ]
		// Example 2 : Input : [5,6,1,2,1,1,4] Output : ?

		int i = 0;
		Scanner sc = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		int arrLength;

		System.out.println("Enter the length of the array: ");
		arrLength = scanner.nextInt();

		int array[] = new int[arrLength];

		System.out.println("Enter the elements in the array ");
		for (i = 0; i < arrLength; i++) {
			array[i] = sc.nextInt();
		}

		int leftIndex = 0;
		int rightIndex = array.length - 1;
		int leftSum = array[leftIndex];
		int rightSum = array[rightIndex];

		while (leftIndex < rightIndex) {
			if (leftSum < rightSum) {
				leftSum += array[++leftIndex];
			} else {
				rightSum += array[--rightIndex];
			}
			
			if(rightIndex - leftIndex ==1) {
				break;
			}
		}

		if (leftSum == rightSum) {
			System.out.println("It is divisible leftIndex " + leftIndex + ", rightIndex " + rightIndex);
		} else {
			System.out.println("It is not divisible");
		}

	}
}