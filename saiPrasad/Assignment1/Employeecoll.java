package ass1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Employeecoll {

	public static void main(String[] args) throws FileNotFoundException {
		Employee[] Workers = new Employee[11];
		int count = 0;
		try {
			Scanner read = new Scanner(new File("C:/Users/prudvi/Desktop/allemployees.csv"));
			while (read.hasNextLine()) {
				String line = read.nextLine();
				String[] all = line.split(",");

				if (all.length == 5) {
					Workers[count] = new ClassifiedStaff(all[0], all[1], all[2], all[3], all[4]);
					count++;
				}
				if (all.length == 6) {
					if (all[4] != null && !"".equals(all[4].trim())) {
						Workers[count] = new StudentEmployee(all[0], all[1], all[2], all[3], all[4], all[5]);
						count++;
					} else {
						Workers[count] = new Faculty(all[0], all[1], all[2], all[3], all[4], all[5]);
						count++;
					}
				}
			}

		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		}

		for (int i = 0; i < Workers.length; i++) {
			System.out.println(Workers[i].toString());
		}

		System.out.println();
		System.out.println("Pay for two week period");
		System.out.println("===============================");

		for (int i = 0; i < Workers.length; i++) {
			if (Workers[i].isWorking())
				System.out.println(Workers[i].getEmpName() + "\t" + Workers[i].getpay());
		}

	}
}
