package assignment10;

import java.util.Arrays;

public class ProductArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int array1[] = {1,2,3,4,5};
		 int result[] = new int[5];

		 for (int i = 0; i < array1.length; i++) {
			int product = 1;
			for (int j = 0; j < array1.length; j++) {
				if (i != j)
					product = product * array1[j];
			}
			result[i] = product;
		}
		 
		 System.out.println("Product of arrays is ");
		 for (int n: result) {
			 System.out.print(" "+n+",");
		 }
//		 System.out.println(Arrays.toString(result));
	}
}
