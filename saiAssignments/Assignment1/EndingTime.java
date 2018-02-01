package ass1;

import java.util.Scanner;

public class EndingTime {

	public static void main(String[] args) {
		// Variable declarations
		
		int hours;
		int minutes;
		int duration;
		int endingHour;
		int endingMinutes;
		
		   
		   
		   // Create a Scanner object to read from the keyboard
		      Scanner in = new Scanner(System.in);
		      
		      System.out.println("Enter starting hour:");
		      hours= in.nextInt();
		      System.out.println("Enter starting minutes:");
		      minutes= in.nextInt();
		   // Get the starting time in hours and minutes
		      System.out.println("Entered starting time:"+ hours+"hr"+minutes+"mins");
		      int totalstarttime= (hours*60)+minutes;
		   // Get the duration time in minutes
		      System.out.println("Enter the Duration:");
		      duration=in.nextInt();
		   // Calculate the ending time 
		      endingHour= (totalstarttime+duration)/60;
		      endingMinutes=(totalstarttime+duration)%60;
		      
		      System.out.println("Ending Hours:"+ endingHour);
		      System.out.println("Ending Minutes:"+ endingMinutes);
		   // Display the output
	}
	}

