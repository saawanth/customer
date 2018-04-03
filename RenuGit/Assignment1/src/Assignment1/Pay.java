/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;
import java.io.*;

/**
 *
 * @author renuk
 */
public class Pay
{
    
      public static void main(String [] args)
   {
   // Declare Variables
      double hoursWorked = 0;      
      double hourlyPayRate = 0;
      double grossPay;
      double taxes;
      double netPay;
   // take the following variables from the user from command promt.
      BufferedReader dataIn = new BufferedReader( new InputStreamReader(System.in) );
  
try{   
    System.out.print("How many hours did you work? ");
    hoursWorked = Integer.parseInt(dataIn.readLine());// read from the command line
    
}
catch(Exception e){
    System.out.println("Error!");
}
try{
    System.out.print("How much do you get paid per hour? ");
hourlyPayRate = Integer.parseInt(dataIn.readLine());// read from the command line

}
catch(Exception e){
System.out.println("Error!");
}
        
       if(hoursWorked <= 40){
            grossPay = hoursWorked * hourlyPayRate;
        }
        else {
       grossPay = (hoursWorked * (1.5 * hourlyPayRate));
   }
        
taxes = 0.33 * grossPay;
netPay = grossPay - taxes;

// Display the results
 System.out.println("You earned $" + grossPay);
 System.out.println("Taxes are $"+taxes);
 System.out.println("Your net Pay is $"+netPay);
    }
      
}
  
     