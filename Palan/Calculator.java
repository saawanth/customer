

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args)
	{
		// variable declaration
		int starttimehrs;
		int startminutes;
		int duration;
		int endtimeinhours;
		int endtimeinminutes;
		
		// create a scanner object to read from the keyboard
		Scanner sc= new Scanner(System.in);
		 
		System.out.println("starttime:");
		starttimehrs= sc.nextInt();
		System.out.println("startminutes:");
		startminutes= sc.nextInt();
		
		// Get the starting time in hours and minutes
		
		System.out.println("enter starttime:"+ starttimehrs+"hr"+startminutes+"min");
		int totalstarttime= (starttimehrs*60)+startminutes;
		
		
		// Get the duration time in minutes
		
		System.out.println("enter the duration");
		duration= sc.nextInt();
		
		// calculate the ending time
		endtimeinhours= (totalstarttime+duration)/60;
		endtimeinminutes= (totalstarttime+duration)%60;
		
		System.out.println("endtimeinhours:"+ endtimeinhours);
		System.out.println("endtimeinminutes:"+ endtimeinminutes);
		
		// Display the output
		
	}
}

