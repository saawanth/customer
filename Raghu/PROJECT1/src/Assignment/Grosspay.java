package Assignment;

import java.util.Scanner;

public class Grosspay {
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		double hoursWorked;      
	      double hourlyPayRate;
	      double grossPay;
	      double taxes;
	      double netpay;
	      System.out.println("How many hours did you work? ");
	      hoursWorked=sc.nextDouble();
	      System.out.println("How much do you get paid per hour?");
	      hourlyPayRate=sc.nextDouble();
	      grossPay=hoursWorked*hourlyPayRate;
	   
	      System.out.println("You earned $" + grossPay);
	      
	      if(hoursWorked<=40){
	    	  grossPay=hoursWorked*hourlyPayRate;
	    	  System.out.println("grosspay"+grossPay);
	      }else{
	    	  grossPay=hoursWorked*1.5*hourlyPayRate;
	    	  System.out.println("grosspay"+grossPay);
	      }
	     
	      taxes=(grossPay)*33/100;
	      System.out.println("taxes"+taxes);
	      netpay=grossPay-taxes;
	      System.out.println("netpay"+netpay);
	      
	      sc.close();
	}

}
