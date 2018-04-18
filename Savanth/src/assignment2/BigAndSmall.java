package assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BigAndSmall {

	public static  void main(String[] args) {
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		double a[] =new double[5];
		double temp = 0.0;
		for (int i = 0; i < 5; i++) {
	      System.out.print("Enter a number or 0 to quit: ");
	      try {
	    	  temp = Double.parseDouble(reader.readLine());
//	    	  if(temp == null) {
//	    		  System.out.println("You did not enter any numbers");
//	    	  }
	    	  if(temp == 0) {
	    		  System.out.println("You did not enter any numbers");
	    		  break;
	    	  }else {
	    		  a[i] = temp; 
	    	  }  
	      } catch (Exception e) {
	     	 System.err.println("Caught IOException: " + e.getMessage());
	      }
		}
		/*System.out.println("Array elements are : ");
        for (int i=0;i<a.length;i++) {
            System.out.println(a[i]);
        }*/
       
        System.out.println("Maximun Value is :" +getMaxValue(a));
        System.out.println("Minimum Value is :" +getMinValue(a));
        System.out.println("Mean of Values :" + getMean(a));
	
	}

	public static double getMaxValue(double[] a) {
		 double maxValue = a[0];
         for (int i = 1; i < a.length; i++) {
             if (a[i] > maxValue) {
                 maxValue = a[i];
             }
         }
         return maxValue;
	}
	public static double getMinValue(double[] a) {
		 double minValue = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i]< minValue && a[i] > 0) {
                minValue = a[i];
            }
        }
        return minValue;
	}
	public static double getMean(double[] a) {
	    double sum = 0;
	    for (int i = 0; i < a.length; i++) {
	        sum += a[i];
	    }
	    return sum / a.length;
	}
	



}



