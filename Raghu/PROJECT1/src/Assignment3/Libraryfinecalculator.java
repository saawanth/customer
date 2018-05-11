package Assignment3;

import java.util.Scanner;

public class Libraryfinecalculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the actual date");
		int Da = sc.nextInt();
		int Ma = sc.nextInt();
		int Ya = sc.nextInt();
		System.out.println("enter the expected date");
		int De = sc.nextInt();
		int Me = sc.nextInt();
		int Ye = sc.nextInt();
		sc.close();

		int fine = 0;
		
		if (Ya == Ye) {
			if (Ma == Me) {
				if (Da > De) {
					fine = (int) (15* (Da - De));
				}
			} else if (Ma > Me) {
				fine = (int) (500 * (Ma - Me));
			}
		} else if (Ya > Ye) {
			fine = (int) 10000;
		}

		System.out.print("fine amount: " + fine);

	}

}
