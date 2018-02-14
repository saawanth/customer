package com.Part1.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		Scanner scan = new Scanner(new File("C:/Users/revan/Desktop/Files/maps.csv"));
		HashMapAssignment hp = new HashMapAssignment();

		while (scan.hasNext()) {
			String str = scan.nextLine();
			String[] arr = str.split(",");
			hp.mapFunction(arr[0], arr[1], arr[2]);
		}
		scan.close();
		hp.display();
		int ch = 0;
		while (ch != 10) {
			System.out.println(
					"\nEnter \n'1' to Add \n'2' to update \n'3' to remove the student \n'4' to Show the list of students on desired D.O.B\n'5' to find all students who are born before and after that date\n'6' to find all students who are born between a date range \n'10' to TERMINATE");
			ch = hp.sc.nextInt();
			switch (ch) {
			case 1:
				hp.addElement();
				break;

			case 2:
				hp.updateElement();
				break;
			case 3:
				hp.removeElement();
				break;
			case 4:
				hp.listOfStudents();
				break;
			case 5:
				hp.groupBy();
				break;
			case 6:
				hp.range();
				break;
			default:
				if (ch != 10) {
					System.out.println("OOOPS!!! Enter the correct integer");
				}
			}
		}
		System.out.println("PROGRAM TERMINATED");
	}

}