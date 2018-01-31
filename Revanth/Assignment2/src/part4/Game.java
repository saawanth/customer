package part4;

import java.util.Scanner;

public class Game {
	public static void main(String args[]) {
		Die die = new Die();

		while (die.getInitCash() > 0) {

			Scanner scan = new Scanner(System.in);
			System.out.println("You have $" + die.getInitCash());
			System.out.println("How much would you like to bet?");
			int bet = scan.nextInt();
			if (bet > die.getInitCash()) {
				System.out.println("You are Greedy!!!");
				System.out.println("Cheating!!! GAME OVER!!!");
				break;
			}
			die.setBetCash(bet);
			int d1 = die.roll();
			int d2 = die.roll();
//			die.setDieValue1(d1);
//			die.setDieValue2(d2);
			System.out.println("You rolled a " + die.toString(d1) + " and " + die.toString(d2));
			System.out.println("You " + die.game() + die.cashOut());
			if (d1 == d2) {
				die.setInitCash(die.getInitCash() - die.getBetCash());
			} else {
				die.setInitCash(die.getInitCash() + (2 * die.getBetCash()));
			}

			if (die.getInitCash() == 0) {
				System.out.println("Game Over!!!");
				break;
			}

		}

	}

}
