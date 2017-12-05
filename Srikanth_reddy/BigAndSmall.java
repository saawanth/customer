package Assign2;
import java.util.Scanner;

public class BigAndSmall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double num;
		double largest=0, smallest=0, mean=0;
		int i=0;
		
		Scanner input = new Scanner (System.in);
		
		do {
			System.out.print("Enter number or 0 to quit ");
			num = input.nextDouble();
			
			if(num == 0){
				break;
				
			}
			
			if(num >= largest ){
				largest = num;
			}
			
			if(num < smallest || smallest == 0 )
			{
					smallest = num;
				
			}
		mean += num;
		i++;
		}
		while(num != 0);
		
		if(i != 0){
		System.out.println("Largest " + largest);
		System.out.println("Smallest "+ smallest);
		System.out.println("Mean "+ mean/i);
		}
		}
}