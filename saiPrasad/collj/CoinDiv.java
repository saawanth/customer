package collj;

import java.util.Scanner;

public class CoinDiv {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount");
		
		double amount=sc.nextDouble();
		
		//convert amount in to cents
		double incents=amount*100;
		int temp;
		
		//No.of quarters and remaining cents
		int quarters=(int) (incents/25);
		temp=(int) (incents%25);
		
		int dimes=(int) (temp/10);
		temp=(int) (temp%10);
		
		int nikals=(int) (temp/5);
		temp=(int) (temp%5);
		
		int cent =temp/1;
		
		int total= quarters+dimes+nikals+cent;
		
		System.out.println("Required coins are");
		System.out.println("Quarters="+quarters+","+"Diames="+dimes+","+"Nikals="+nikals+","+"Cents="+cent+",");
		System.out.println("total coins:"+total);
	}

}
