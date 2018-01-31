/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author revan
 */
public class Pay {

    public static void main(String[] args) throws IOException {
        // Declare Variables
        double hoursWorked;
        double hourlyPayRate;
        double grossPay = 0;
        // take the following variables from the user from command promt.
        BufferedReader dataInn = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("How many hours did you work? ");
        hoursWorked = Integer.parseInt(dataInn.readLine()); 
// read from the command line
        System.out.println("How much do you get paid per hour? ");
        hourlyPayRate = Integer.parseInt(dataInn.readLine());
                // read from the command line
        if(hoursWorked <= 40) {
            grossPay = hoursWorked * hourlyPayRate;
        } 
        else if (hoursWorked > 40) {
            grossPay = (hoursWorked) * (1.5 * (hourlyPayRate));

        }
        double taxes = (0.33) * grossPay;
        double netPay = grossPay - (0.33) * grossPay;

// Display the results

        System.out.println("You earned $" + grossPay);
        System.out.println("Taxes are $" + taxes);
        System.out.println("Your net Pay is $" + netPay);
    }
}



