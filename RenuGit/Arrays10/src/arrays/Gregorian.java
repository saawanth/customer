package arrays;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Gregorian {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			System.out.println("Enter the actual return date of the book ");
			String actDate = scanner.next();
			
			System.out.println("Enter the expected return date of the book ");
			String expDate = scanner.next();
		   
		    String format = "dd/MM/yyyy";

		    SimpleDateFormat sdf = new SimpleDateFormat(format);

		    Date dateObj1 = sdf.parse(actDate);
		    Date dateObj2 = sdf.parse(expDate);
		    
		    long diff = dateObj1.getTime() - dateObj2.getTime();
		    double diffInHours = diff / ((double) 1000 * 60 * 60);
		    int days = (int)(diffInHours/24);
		    System.out.println("You're late by " + days +" days");
		    
		    if(days == 0){
				System.out.println("No fine charged!");
			}
		    else if(dateObj1.getYear() != dateObj2.getYear()){
		    	System.out.println("You will need to pay a fine of $" + 10000 );
		    	
		    }
		    else if((days != 0) & (dateObj1.getMonth() == dateObj2.getMonth()) & (dateObj1.getYear() == dateObj2.getYear())){
		    	System.out.println("You will need to pay a fine of $" + 15 * days);
		    }
		    else if((days != 0) & (dateObj1.getMonth() != dateObj2.getMonth()) & (dateObj1.getYear() == dateObj2.getYear())){
		    	System.out.println("You will need to pay a fine of $" + 500 * days);
		    }
		    		    
		} catch (Exception e) {
		    System.out.println(e);;
		}
		
	}
}
