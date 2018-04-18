package assignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class EndingTime {

	public static void main(String [] args)
	   {      
		int hours = 0;
		int minutes = 0;
		int startingTime = 0;

	   // Create a Scanner object to read from the keyboard
	      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	      System.out.print("Enter the starting time (in hours and minutes) ");
	      try {
	    	  String time = reader.readLine();
	    	  String splitTime[]=time.split(" ");
	    	  hours=Integer.parseInt(splitTime[0]);
	    	  minutes=Integer.parseInt(splitTime[1]);
	      } catch (Exception e) {
	     	 System.err.println("Caught IOException: " + e.getMessage());
	      }
	      
	      startingTime = (hours * 60) + minutes;
//	      System.out.println("Hours" + hours);
//	      System.out.println("Minutes" + minutes);
	      System.out.println("Calculated Total Minutes " + startingTime);
	      
	   // Get the starting time in hours and minutes
	      System.out.print("Enter the starting time (in hours and minutes) ");
	      try {
	    	  String time = reader.readLine();
	    	  String splitTime[]=time.split(" ");
	    	  hours=Integer.parseInt(splitTime[0]);
	    	  minutes=Integer.parseInt(splitTime[1]);
	      } catch (Exception e) {
	     	 System.err.println("Caught IOException: " + e.getMessage());
	      }
	   
	   // Get the duration time in minutes
	   
	   // Calculate the ending time   
	   
	   // Display the output
	   }
}
