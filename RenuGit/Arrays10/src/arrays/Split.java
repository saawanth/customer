package arrays;

import java.util.Scanner;

public class Split {
	public static void main(String args[]) {

		int i = 0;
		int firstHalf = 0;
		int secondHalf = 0;
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

		firstHalf = array[0];
		secondHalf = array[(array.length) - 1];
		int splitPoint = 0;

		for (int j = 1; j <= ((array.length) - 2); j++) {

			if((firstHalf > secondHalf) & (j == 1) & (secondHalf == array[(array.length) - 1])){
				System.out.println("first half > secnd half: ");
			System.out.println("this is going to add to the second half: array[(array.length) - (j)"
					+ array[(array.length) - (j+1)]);
				secondHalf += array[(array.length) - (j + 1)];
				System.out.println("scnd:" +secondHalf);
			}
			else if((firstHalf > secondHalf) & (j > 1)){
				System.out.println("first half > secnd half: & j > 1");
				System.out.println("this is going to add to the second half: array[(array.length) - (j)"
						+ array[(array.length) - (j)]);
				secondHalf += array[(array.length) - (j + 1)];
			}
			
			 else if((firstHalf < secondHalf) & (j > 1) & firstHalf == array[0]){
				 System.out.println("first half < second half: 1st condition adding   array[j] " + array[j - 1]);
							firstHalf += array[j-1];
			}
			 else if ((firstHalf < secondHalf ) & (j == 1)) {
					System.out.println("first half < second half: 2nd condition adding   array[j] " + array[j]);
					firstHalf += array[j];
				}
			 else if((firstHalf < secondHalf) & (j > 1)){
				 System.out.println("first half < second half: 3rd condition adding   array[j] " + array[j]);
				 firstHalf += array[j];
			 }
			 else if (firstHalf == secondHalf) {
			System.out.println("first half == secnd half: ");
				if ((array.length) % 2 == 0) {
				System.out.println("aray is even and adding tgis to first half: " + (firstHalf +array[j]));
					firstHalf += array[j];
					secondHalf += array[(array.length) - (j)];
				} else if ((((array.length) % 2) != 0) & (array[(array.length) / 2] == 0)) {
				System.out.println("else if condition: array[j]"+ array[j]);
					firstHalf += array[j];
				}

				splitPoint = j;
			}
		}

		System.out.println("SplitPoint:" + splitPoint);
		System.out.println("firstHalf " + firstHalf + "seconDHalf " + secondHalf);

		if (firstHalf == secondHalf) {

			System.out.print("[");
			for (int k = 0; k < splitPoint; k++) {
				System.out.print(array[k] + " ");
			}
			System.out.print("]");

			System.out.print("[");
			for (int l = splitPoint; l < array.length; l++) {
				System.out.print(array[l] + " ");
			}
			System.out.print("]");
		}
		else if(firstHalf != secondHalf){
			System.out.println("The array cannot be split");
		}

	}
}
