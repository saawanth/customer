package Assignment2;

import java.util.Scanner;

public class Dicegame {

	public static void main(String args[]) {

		int betamount = 0;
		int totalamount;
		int initialamount = 10;

		Scanner sc = new Scanner(System.in);
		Die d1 = new Die();
		Die d2 = new Die();

		while (initialamount != 0) {

			int r1 = d1.roll();
			int r2 = d2.roll();

			System.out.println("you have $: " + initialamount);
			System.out.println("how much would you like to bet");
			betamount = sc.nextInt();

			if ((betamount > initialamount)) {
				System.out.println("You're too greedy!");
			} else if (r1 == r2) {
				System.out.println("you have rolled " + d1.toString(r1) + " and " + d2.toString(r2));
				totalamount = initialamount + 2 * (betamount);
				initialamount = totalamount;
				System.out.println("you win" + 2 * betamount);
			}

			else {
				System.out.println("you have rolled " + d1.toString(r1) + " and " + d2.toString(r2));
				System.out.println("you lose" + betamount);
				totalamount = initialamount - betamount;
				initialamount = totalamount;
			}

		}
		if (initialamount == 0) {
			System.out.println("Better luck next time");
		}
		sc.close();
	}
}
