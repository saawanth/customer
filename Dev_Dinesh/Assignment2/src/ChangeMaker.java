import java.util.Scanner;

public class ChangeMaker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Variable Declaration
		int CustPaid,CustOwed,Change;
		int Dollar,Quarter,Dime = 0,Nickel,Penny;
		int q,d,n;

//Inputs from scanner
		Scanner in= new Scanner(System.in);
		System.out.print("Enter the amount the customer paid: ");
		CustPaid= in.nextInt();
		System.out.print("Enter the amount the customer owed: ");
		CustOwed=in.nextInt();
		in.close();
		
//Get the exact change
		Change=CustPaid-CustOwed;
//For Dollars and Quarters
		q=Change%100;
		d=q%25;
		n=d%10;
		if(Change>100) {
			Dollar=(Change-q)/100;
			Quarter=(q-(q%25))/25;
		}else {
			Dollar=0;
			Quarter=Change-(Change%25)/25;
		}
		
//For Dime,Nickel and Pennies
		if(d>10) {
			Dime=(d-n)/10;
			Nickel=(n-(n%5))/5;
			Penny=n%5;		
		}else {
			Nickel=(d-(d%5))/5;
			Penny=d%5;
		}
//Display Outputs
			System.out.println("Their Change is:"+Change);
			System.out.println(Dollar+" Dollars,"+Quarter+" Quarters,"+Dime+" Dimes,"+Nickel+" Nickels,"+Penny+" Pennies");
	}

}
