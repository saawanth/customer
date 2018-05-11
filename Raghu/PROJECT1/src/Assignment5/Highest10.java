package Assignment5;

public class Highest10 {
public static void main(String args[]) {
			int[] largest = new int[10];
			int[] array = { 94,22,37,42,5,6,74,55,10,101,11,34,56 };
			int max=0;
			for (int k = 0; k < 10; k++) {
				max = array[0];
				int index = 0;
				for (int i = 1; i < array.length; i++) {
					if (max < array[i]) {
						max = array[i];
						index = i;
					}
				}
				largest[k] = max;
				array[index] = -1; 

				System.out.println("largest " + (1 + k) + " th number in the array  " + largest[k]);

			}
		}
	}

