package part4;

import java.util.Scanner;

public class DieGame {
	public static void main(String args[]){
		double initialMoney = 10;
		double betAmount;
		double afterWinning;
		double afterLosing;
		int faceValue1 = 0;
		int faceValue2 = 0;
				
		Scanner sc = new Scanner(System.in);
		Doubles d = new Doubles();
		
		System.out.println("You have $"+initialMoney);
		
		while(initialMoney > 0){
			
			System.out.println("How much would you like to bet? ");
			betAmount = sc.nextDouble();
			faceValue1 = d.roll();
			faceValue2 = d.roll();
			afterWinning = initialMoney + betAmount + betAmount;
			afterLosing = initialMoney - betAmount;
			
			d.setDieValue(faceValue1);
			d.setFaceValue2(faceValue2);
			System.out.println("You rolled a "+ d.toString(faceValue1) + " and " +d.toString(faceValue2));			
				
			if(d.equals()){
				System.out.println("You win $" + (betAmount + betAmount));
				System.out.println("You have $" +afterWinning);
				initialMoney = initialMoney + betAmount;			
			}
						else{
							System.out.println("You lose $" +betAmount);
							System.out.println("");
						System.out.println("You have $" + afterLosing);
						initialMoney = initialMoney - betAmount;
						}	
			while(betAmount > initialMoney){
				System.out.println("You do not have sufficient balance!");
				break;
			}
									
		}
				
	}

}
