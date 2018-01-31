import java.util.Scanner;

public class Doubles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int amount=10;
		Die d1= new Die();
		Die d2= new Die();
		
		Scanner sc= new Scanner(System.in);
		System.out.println("The amount you have"+ amount);
		System.out.println("How much would you like to bet?");
		
		while(amount!=0) {
		
		
		int bet=sc.nextInt();
		if(amount<bet) {
			System.out.println("not enough money");
		}
		else
		{
			d1.setDievalue(d1.roll());
			d2.setDievalue(d2.roll());
			System.out.println("you rolled a"+ d1.toString()+ " and "+ d2.toString());
		
			if (d1.toString()==d2.toString()) {
				amount += 2*bet;
				System.out.println("you won amount "+ 2*bet);
				System.out.println("total amount "+ amount);
			}
			else if(d1!=d2){
					amount -= bet;
					System.out.println("you lose bet amount"+  bet);
				}
			else 
			{
				System.out.println("better luck next time");
			}
		}
		}
	}}
	
