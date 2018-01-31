package Assign2;
import java.util.Scanner;

public class Doubles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			int amount=10;//Start with a bet amount
			
			Die d1=new Die();
			Die d2=new Die();
			
			while(amount!=0)
			{
				Scanner sc=new Scanner(System.in);
				System.out.println("You have $"+amount);
				System.out.println("How much would you like to bet?");
				
				int bet= sc.nextInt(); //Take the bet amount from the player
				if(amount<bet)
				{
					System.out.println("You do not have enough money");
				}
				else
				{
					d1.setDieValue(d1.roll());//generate values for die1 and die2
					d2.setDieValue(d2.roll());
					System.out.println("You rolled a"+ d1.toString()+ "and"+ d2.toString());
							
				}
				if(d1.equals(d2))
				//Condition for what happens after the bet
				{
					amount +=2*bet;
				}
				else{
					amount -= bet;
				}
				if(amount ==0)
				{
					System.out.println("Better luck next time");
				}
			}
			
			
	}

}
