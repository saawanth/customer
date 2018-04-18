package assignment10;

import java.util.Scanner;

public class FineCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the Actual Date");
		Scanner s = new Scanner(System.in);
		byte actualDay = s.nextByte();
		byte actualMonth = s.nextByte();
		short actualYear = s.nextShort();
		
		System.out.println("Enter the Expected Date");
		byte expectedDay = s.nextByte();
		byte expectedMonth = s.nextByte();
		short expectedYear = s.nextShort();
		
		int fine = 0;
		if(actualYear == expectedYear && actualMonth == expectedMonth && actualDay > expectedDay )
		{
			fine = (int) (15 * (actualDay - expectedDay));
		}else if(actualYear == expectedYear && actualMonth == expectedMonth) {
			fine = (int) (500 * (actualMonth - expectedMonth));
		} else if (actualYear > expectedYear) {
			fine = (int) 10000;
		}
		System.out.print(fine);
	}

}
