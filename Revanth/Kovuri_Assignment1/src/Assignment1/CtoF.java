/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

/**
 *
 * @author revan
 */

public class CtoF {
    
    public static double convertToF(double cTemp){
        double fTemp;
        fTemp = (cTemp * (1.8))+ 32;
        //System.out.println(fTemp);
        return fTemp;
    }
    public static void main (String[] args)
 {
   // Celsius temp is a constant
   // Fahrenheit temp

   final double CELS = 37;
   double FAHR ; 

   // calculate Fahrenheit temp using formula
   // display intro message

   System.out.println("This program converts Celsius to Fahrenheit");
   // display the result

   System.out.println("Celsius Temp = " + CELS);
   System.out.println("Fahrenheit Temp = " + convertToF(CELS));

   // display end message
   System.out.println("End of program");
 }
}
    
