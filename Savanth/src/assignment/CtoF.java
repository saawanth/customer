package assignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CtoF

{
 public static void main (String[] args)
 {
   // Celsius temp is a constant
   // Fahrenheit temp

	 
	 
  /* final double CELS = 37;
   double FAHR;

   FAHR = (9/5) * CELS + 32;

   System.out.println("This program converts Celsius to Fahrenheit");
   // display the result

   System.out.println("Celsius Temp = " + CELS);
   System.out.println("Fahrenheit Temp = " + FAHR);

   // display end message
   System.out.println("End of program");
	 */
/*	 ===========================================
	 ======= Converitng F to C===================
	 ==========================================*/
	 
	  
	 /*  final double FAHR = 212;
	   double CELS;
	   
	   CELS = ((FAHR - 32)/1.8);

	   System.out.println("This program converts Fahrenheit to Celsius ");
	   // display the result

	   System.out.println("Celsius Temp = " + CELS);
	   System.out.println("Fahrenheit Temp = " + FAHR);

	   // display end message
	   System.out.println("End of program");*/
	 
	 /*	 ===========================================
	 ======= Taking Input From Console=============
	 ==========================================*/
//	 Scanner scn = new Scanner(System.in);                                   //we can also use this 
//     System.out.println("Please enter temperature in Celsius :");
//     int CELS = scn.nextInt();
	 
	/* java.util.Scanner class is a simple text scanner which can parse primitive types and strings.
	 It internally uses regular expressions to read different types.

	 Java.io.BufferedReader class reads text from a character-input stream, buffering 
	 characters so as to provide for the efficient reading of sequence of characters
	 */
	 
	/* BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	 double CELS = 0;
	 double FAHR;
	         System.out.print("Please enter temperature in Celsius : ");
	         try {
	        	  CELS = Double.parseDouble(reader.readLine());
	         } catch (Exception e) {
	        	 System.err.println("Caught IOException: " + e.getMessage());
	         }
	         
	         FAHR = (9/5) * CELS + 32;
	         System.out.println("This program converts Celsius to Fahrenheit");
	         // display the result

	         System.out.println("Celsius Temp = " + CELS);
	         System.out.println("Fahrenheit Temp = " + FAHR);

	         // display end message
	         System.out.println("End of program");
	         */
	 /*	 ===========================================
	 ======= Taking Input From Console=============
	 ==========================================*/
	 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	 double CELS;
	 double FAHR = 0;
	         System.out.print("Please enter temperature in Fahrenheit : ");
	         try {
	        	 FAHR = Double.parseDouble(reader.readLine());
	         } catch (Exception e) {
	        	 System.err.println("Caught IOException: " + e.getMessage());
	         }
	         
	         CELS = ((FAHR - 32)/1.8);
	         System.out.println("This program converts Fahrenheit to Celsius ");
	         // display the result

	         System.out.println("Celsius Temp = " + CELS);
	         System.out.println("Fahrenheit Temp = " + FAHR);

	         // display end message
	         System.out.println("End of program");
	         
 }
}