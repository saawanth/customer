package arrays;

import java.util.Scanner;

public class Arrays {

	public static void main(String[] args) {
		
		int num1, num2, num3, num4, num5;		 
			
		Scanner sc = new Scanner(System.in);

			System.out.println("Enter the numbers: ");	
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			num3 = sc.nextInt();
			num4 = sc.nextInt();
			num5 = sc.nextInt();
			
			int num[] = {num1,num2, num3, num4, num5};				
			
			int number = num1 * num2 * num3 * num4 * num5;
			int array[] = new int[5];
			
		for(int i=0; i < num.length; i++){
				array[i] = number / num[i];
				System.out.println(array[i]);
			}
			
		}
			
	}

