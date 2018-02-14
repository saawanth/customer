package assign;

import java.util.Scanner;

public class Array {

	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter length of array");
		int ArraySize = sc.nextInt();
		int[] nums = new int[ArraySize];
		System.out.println("Enter your numbers");
//		for(int k=0;k<=nums.length;k++){
//		nums[k]=sc.nextInt();
//		}
        int count = 0;
        int products[] = new int[5];
		for (int i = 0; i < nums.length; i++) {
			nums[i]=sc.nextInt();
		}
			for(int k=0;k<nums.length;k++){
			int prod = 1;
			for (int j = 0; j < nums.length; j++) {
				if (j != k) {
					
//					if (j + 1 == nums.length) {
//						System.out.print(nums[j]);
						prod = prod*nums[j];
					}
					
}			products[k]=prod;
			System.out.println(prod);
}

}
			
}