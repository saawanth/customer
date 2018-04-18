package assignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Doubles {

public static void main(String[] args) throws  NumberFormatException, IOException {
		// TODO Auto-generated method stub
     int beginamount = 10;
     int betamount = 0;
     Dice d1 = new Dice();
   	 Dice d2 = new Dice();
     System.out.println("You have $" + beginamount);
     while(beginamount != 0){
     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     System.out.print("How much would you like to bet? ");
//     try {
   	 betamount = Integer.parseInt(reader.readLine());
   	 if(betamount > beginamount || betamount < 0) {
   		System.out.println("Must be below the amount you have");
//   		System.out.print("How much would you like to bet? ");
//   		betamount = Integer.parseInt(reader.readLine());
   	 }else {

//     } catch (Exception e) {
//    System.err.println("Caught IOException: " + e.getMessage());
//     }
     	
		d1.setDicevalue(d1.roll());
		d2.setDicevalue(d2.roll());
		String d1Result = d1.toString();
		String d2Result = d2.toString();
//   	     int d1Result = d1.roll();
//   	     int d2Result = d2.roll();
   	    if (d1Result == d2Result) {
   	    	beginamount += 2*betamount;
			System.out.println("you won amount "+ 2* betamount);
			System.out.println("total amount "+ beginamount); 
			System.out.printf("You rolled a  " +d1Result +" and  " + d2Result + "\n");
  	    	System.out.println("you total amount Now$"+  beginamount);
   	     }else if((d1Result != d2Result)) {
   	    	System.out.printf("You rolled a " +d1Result +" and " + d2Result + "\n");
   	    	System.out.println("you lose bet amount $"+  betamount);
   	    	beginamount -= betamount;
			System.out.println("Your Remaining Amount $"+  beginamount);
			if(beginamount ==0) {
				System.out.println("Better luck next time");
			}
   	     }else 
 		{
 			System.out.println("Try again For you luck");
 		}
    }
   	 }
	
	
}


}



