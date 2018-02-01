
package ass1;
import java.util.Scanner;

public class CtoF {

	public static void main(String[] args) {
		   // Celsius temp is a constant
		   // Fahrenheit temp

		   final double CELS;
		   double FAHR;
		   
		   Scanner in = new Scanner(System.in);
		   System.out.println("Enter CELS:");
		   CELS = in.nextDouble();
		   FAHR = CELS*9/5+32;

		   // calculate Fahrenheit temp using formula
		   // display intro message

		   System.out.println("This program converts Celsius to Fahrenheit");
		   // display the result

		   System.out.println("Celsius Temp = " + CELS);
		   System.out.println("Fahrenheit Temp = " + FAHR);

		   // display end message
		   System.out.println("End of program");
		

	}

}
