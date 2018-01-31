import java.util.Scanner;

public class Pay {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		// Declare Variables
		double hoursWorked;
		double hourlyPayRate;
		double grossPay;
		double taxes;
		double netPay;
		// take the following variables from the user from command prompt.
		System.out.println("Hours worked");
		hoursWorked=sc.nextDouble();
		System.out.println("perHr");
		hourlyPayRate=sc.nextDouble();
		grossPay=hoursWorked*hourlyPayRate;
		System.out.println("Grosspay"+grossPay);
		taxes= grossPay*0.33;
		System.out.println("taxes"+taxes);
		netPay=grossPay-taxes;
		System.out.println("Netpay"+netPay);

	}

}
