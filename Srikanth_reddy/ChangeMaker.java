/**
 * 
 */
/**
 * @author srika
 *
 */
package Assign2;
import java.util.Scanner;

public class ChangeMaker
{
	public static void main(String[] args)
	{
		int CustomerPaid;
		int CustomerDebt;
		int Change;
		int dollars,quarters,dimes,nickels,pennies;
		int balance;
				
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount Customer paid:");
		CustomerPaid = sc.nextInt();
		
		System.out.println("Enter the amount customer owned");
		CustomerDebt = sc.nextInt();
		
		Change = CustomerPaid - CustomerDebt;
		
		
		dollars = Change/100;
		balance= Change % 100;
		
		quarters = balance/25;
		balance = balance % 25;
		
		dimes = balance/10;
		balance = balance % 10;
		
		nickels = balance/5;
		balance = balance % 5;
		
		pennies = balance/1;
		
		System.out.println("Their change is: "+ Change);
		System.out.println("\n"+dollars+"Dollars"+ quarters+"Quarters"+dimes+"Dimes"+nickels+"Nickels");
		
		
		
	}
}