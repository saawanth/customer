package Assignment4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Testemployee {

	public static void main(String[] args)throws IOException {
		Employee[] workers = new Employee[11];

		String[] all = null;

		String filename = "/Users/raghu/Downloads/raghu.csv";
		File file = new File(filename);

		int i = 0;
		String line;
		
		BufferedReader br = new BufferedReader(new FileReader(file));

		
		while ((line = br.readLine()) != null) {
			all = line.split(",");
			if (all.length == 5) {
				workers[i] = new ClassifiedStaff(all[0], all[1], all[2], all[3], all[4]);
			} else if (all.length == 6 && (all[4].equals("TRUE") || all[4].equals("FALSE"))) {
				workers[i] = new StudentEmployee(all[0], all[1], all[2], all[3], all[4], all[5]);
			} else {
				workers[i] = new Faculty(all[0], all[1], all[2], all[3], all[4], all[5]);
			}

			i++;
		}
		br.close();
		for (int j = 0; j < workers.length; j++) {
			System.out.println(workers[j]);
		}

		System.out.println("Pay for two week period");
		System.out.println("=================================");

		
		for (int j = 0; j < workers.length; j++) {
			if (workers[j].isWorking) {
				System.out.println(workers[j].employeename + "\t\t$" + workers[j].getPay());
			}
		}
	}

}
