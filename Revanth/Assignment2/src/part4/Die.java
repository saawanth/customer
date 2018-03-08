package part4;

import java.util.Random;

public class Die {
	// private int faceValue;
	private int initCash = 10;
	private int betCash;
	private int dieValue1;
	private int dieValue2;

	public Die() {
	}

	public int getDieValue1() {
		return dieValue1;
	}

	public void setDieValue1(int dieValue1) {
		this.dieValue1 = dieValue1;
	}

	public int getDieValue2() {
		return dieValue2;
	}

	public void setDieValue2(int dieValue2) {
		this.dieValue2 = dieValue2;
	}

	Random rand = new Random();

		public int getInitCash() {
		return initCash;
	}

	public void setInitCash(int initCash) {
		this.initCash = initCash;
	}

	public int getBetCash() {
		return betCash;
	}

	public void setBetCash(int betCash) {
		this.betCash = betCash;
	}

	public boolean equals() {
		return getDieValue1() == getDieValue2();

	}

	public String game() {
		return equals() ? "Win $" : "Lose $";
	}

	public int cashOut() {
		if (equals()) {
			return getBetCash() * 2;
		} else {
			return getBetCash();
		}
	}

	public int total() {
		int tot;
//		System.out.println("Initial cash: " + getInitCash());
//		System.out.println("Cash out: " + cashOut());
		
		if (equals()) {
			tot = getInitCash() + cashOut(); //cashOut = 2 * bet amount for true case
		} else {
			tot = getInitCash() - cashOut(); // (or) cashOut = bet amount for false case
		}
		return tot;
	}

	public int roll() {
		return rand.nextInt(6)+1;
	}

	public String toString(int i) {
		String res = "";
		if (i == 1)
			res = "One";

		if (i == 2)
			res = "Two";

		if (i == 3)
			res = "Three";

		if (i == 4)
			res = "Four";

		if (i == 5)
			res = "Five";
		if (i == 6)
			res = "Six";
		return res;
	}

}
