package assignment10;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
//
//This Program only returns weather dynamic partition can be done or not 
// Return True Or False
public class DynamicPartition2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the size of array");
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();   //here n is SIZE of array
		int[] arr;
		arr = new int[n];
		System.out.println("Enter the array Values");
		for (int i = 0; i < n; i++) {		
			arr[i] = in.nextInt();	
		}
		System.out.println(Arrays.toString(arr));
		int total = IntStream.of(arr).sum();    //Java 1.8 method to add array elements
		
		
		
//Method For Splitting Array into Equal Parts 
		int firstarraysum = 0  , secondarraysum = 0;
		int firstSplitarraysize = 0, secondSplitarraysize = 0;
		if (total % 2 == 0) {
			for (int i = 0; i < n; i++) {
				firstarraysum = firstarraysum + arr[i];
				firstSplitarraysize++;
				secondarraysum = 0;
				for (int j = i + 1; j < n; j++) {
					secondarraysum = secondarraysum + arr[j];
				}
				if (firstarraysum == secondarraysum) {
					break;
				}

			}
		
	}
		
//Method to Display Array 
		secondSplitarraysize =  n - firstSplitarraysize;
		int[] array1 = new int[firstSplitarraysize];
		int[] array2 = new int[secondSplitarraysize];
		
		int x =0;
		for (int i = 0; i < firstSplitarraysize; i++) {
			array1[i] = arr[i];
			x++;
		}
		System.out.println(Arrays.toString(array1));
		for (int i = 0; i < secondSplitarraysize; i++) {
			array2[i] = arr[i];
			x++;
		}
		System.out.println(Arrays.toString(array2));
}
}