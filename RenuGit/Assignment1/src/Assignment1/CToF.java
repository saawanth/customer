package Assignment1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author renuk
 */
public class CToF
{
    
 public static void main (String[] args)
 {
   // Celsius temp is a constant
   // Fahrenheit temp
     final double CELS = 37;
     double FAHR;

   
     FAHR = (CELS * 1.8) + 32; 

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