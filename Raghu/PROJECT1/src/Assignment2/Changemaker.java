package Assignment2;

import java.util.Scanner;

public class Changemaker {
    
	public static void main(String args[]){
		 int amountpaid;
		 int amountowned;
		int changedue;
		 Scanner sc=new Scanner(System.in);
		System.out.println("enter the amount customer paid");
		amountpaid=sc.nextInt();
		System.out.println("enter the amount customer owned");
		amountowned=sc.nextInt();
		sc.close();
		
	     changedue = amountpaid-amountowned;
	System.out.println("their change is:  "+changedue);
		int dollars = Math.round((int)changedue/100);
		    changedue=changedue%100;
		    int quarters = Math.round((int)changedue/25);
		    changedue=changedue%25;
		    int dimes = Math.round((int)changedue/10);
		    changedue=changedue%10;
		    int nickels = Math.round((int)changedue/5);
		    changedue=changedue%5;
		    int pennies = Math.round((int)changedue/1);
		
		
		   System.out.println(dollars +" "+ "dollars "+ "," +quarters  +" "+"quarters "+","+dimes +" "+"dimes "+","+nickels +" "+"nickels " +  "and"+" "+pennies +" "+"pennies");
		   
	}

}
