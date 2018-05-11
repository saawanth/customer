package Assignment2;

import java.util.Random;

public class Die { // creating die class

	int diesfacevalue;

	public Die() { // creating constructor
		this.diesfacevalue = 0;
		// creating random object
	}

	public int roll() {
		Random rnum = new Random(); // creating roll method
		return rnum.nextInt(6) + 1;
	}

	public boolean equals(Die raghu) { // crating equal method

		if (this.diesfacevalue == raghu.roll()) {
			return true;
		} else {
			return false;
		}
	}

	public String toString(int i) {
		String str = " ";
		if (i == 1) {
			return str = "One";
		} else if (i == 2) {
			return str = "Two";
		} else if (i == 3) {
			return str = "Three";
		} else if (i == 4) {
			return str = "Four";
		} else if (i == 5) {
			return str = "Five";
		} else if (i == 6) {
			return str = "Six";
		}
		return str;
	}
}
