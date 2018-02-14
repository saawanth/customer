package com.assignment10.com;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class LibraryFineCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the actual date: ");
		String actDate = scan.nextLine();
		System.out.println("Enter the expected date: ");
		String expDate = scan.nextLine();
		scan.close();

		// Split the given date
		String actD[] = actDate.split(" ");
		String expD[] = expDate.split(" ");

		// convert the dates(String) to Integer type

		int aDate = Integer.parseInt(actD[0]);
		int aMonth = Integer.parseInt(actD[1]);
		int aYear = Integer.parseInt(actD[2]);

		int eDate = Integer.parseInt(expD[0]);
		int eMonth = Integer.parseInt(expD[1]);
		int eYear = Integer.parseInt(expD[2]);

		// Logic for No Fine
		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.DAY_OF_MONTH, aDate);
		cal.set(Calendar.MONTH, aMonth);
		cal.set(Calendar.YEAR, aYear);
		Date actualDate = cal.getTime();

		cal.set(Calendar.DAY_OF_MONTH, eDate);
		cal.set(Calendar.MONTH, eMonth);
		cal.set(Calendar.YEAR, eYear);
		Date expectedDate = cal.getTime();

		long diff = actualDate.getTime() - expectedDate.getTime();

		long days = diff / 1000 / 60 / 60 / 24;
		System.out.println("Days: " + diff / 1000 / 60 / 60 / 24);

		if (days <= 0) {
			System.out.println(0);
		} else if (!(aDate == eDate) && (aMonth == eMonth) && (aYear == eYear)) {
			System.out.println(15 * days);
		} else if (!(aYear == eYear)) {
			System.out.println("10,000");
		} else if (!(aMonth == eMonth)) {
			System.out.println(500 * days);
		}

	}

}
