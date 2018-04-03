/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import java.util.Scanner;

/**
 *
 * @author renuk
 */
public class EndingTime {
    public static void main(String [] args)
   {      
   // Variable declarations
   // Hint: All variables need to be declared as integers
   int startingTimeinHours;
   int duration;
   int startingTimeinMinutes;
   int stinMinutes;
   int endingTime;
   int endingTimeinHours;
   int endingTimeinMinutes;
   // Create a Scanner object to read from the keyboard
      Scanner keyboard = new Scanner(System.in);
      
   // Get the starting time in hours and minutes
      System.out.println("Please enter the start time:");
      startingTimeinHours = keyboard.nextInt();
      startingTimeinMinutes = keyboard.nextInt();
   // Get the duration time in minutes
      System.out.println("Enter the duration in minutes:");
      duration = keyboard.nextInt();
      
      stinMinutes = (startingTimeinHours * 60) + startingTimeinMinutes;
      
      endingTime = stinMinutes + duration;
      
      endingTimeinHours = endingTime/60;
      endingTimeinMinutes = endingTime % 60;
   
   // Calculate the ending time   
   
   // Display the output
      System.out.println("Ending Time in Hours is:" +endingTimeinHours);
      System.out.println("Ending Time in minutes is:" +endingTimeinMinutes);
   }
}
