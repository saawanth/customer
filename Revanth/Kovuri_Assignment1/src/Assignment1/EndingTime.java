/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import java.util.Scanner;

/**
 *
 * @author revan
 */
public class EndingTime {

    static int startingTimeHrs;
    static int startingTimeMints;
    static int totalDuration;

    public static void main(String[] args) {
        // Variable declarations
        // Hint: All variables need to be declared as integers

        // Create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Get the starting time in hours and minutes
        System.out.println("Enter the starting Time in Hrs:");
        startingTimeHrs = keyboard.nextInt();
        System.out.println("Enter the starting Time in Mints:");
        startingTimeMints = keyboard.nextInt();
        // Get the duration time in minutes
        System.out.println("Enter the totalDuration: ");
        totalDuration = keyboard.nextInt();

        
        int startTimeInMints = (startingTimeHrs * 60) + (startingTimeMints);
        System.out.println("Total Time in Minutes: " + startTimeInMints);
        
        int endTimeInMints = startTimeInMints + totalDuration;
        // Calculate the ending time  
        
        int endTimeInHrs = endTimeInMints/60;
        int endTimeInMinutes = endTimeInMints % 60;
        // Display the output
        System.out.println("End Time is: " + endTimeInHrs + " hours " + endTimeInMinutes + " minutes");
       // System.out.println("End Time in minutes:" + endTimeInMinutes);
       
       
    }
}
