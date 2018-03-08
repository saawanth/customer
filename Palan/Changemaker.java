

import java.util.Scanner;

public class Changemaker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int customerpaid;
    int customerowned;
    int change;
    int dollars,quaters,dimes,nickels,pennies;
    int amount;
    
    Scanner sc = new Scanner(System.in);
    System.out.println("enter the amount customer paid");
    customerpaid=sc.nextInt(); 
    
    System.out.println("enter the amount customer owned");
    customerowned=sc.nextInt();
    
    change=customerpaid-customerowned;
     
    dollars= change / 100;
    amount= change % 100;
    
    quaters= amount / 25;
    amount= amount % 25;
    
    dimes= amount / 10;
    amount= amount % 10;
    
    nickels= amount / 5;
    amount= amount % 5;
    
    pennies= amount;
    
    System.out.println("customer change is: "+ change);
    System.out.println( dollars+"Dollars"+" "+ quaters+"Quaters"+" "+dimes+"Dimes"+" "+nickels+"Nickels"+" "+pennies+"Pennies");
	}

}