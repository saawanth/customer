package assignment_3;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

public class Program4Demo {
	public static void main(String args[]) throws FileNotFoundException {
		Employee[] workers = new Employee[11];
		Scanner sc = new Scanner(System.in);
//		int numOfStu = Integer.parseInt(JOptionPane.showInputDialog("number of students  "));
		System.out.println("Number of students: ");
		int numOfStu = sc.nextInt();
//		int numOfClasSatff = Integer.parseInt(JOptionPane.showInputDialog("number of classified staff "));
		System.out.println("Number of staff: ");
		int numOfClasSatff  = sc.nextInt();
//		int numOfFac = Integer.parseInt(JOptionPane.showInputDialog("number of faculty  "));
		System.out.println("Number of faculty: ");
		int numOfFac = sc.nextInt();
//		String nameOfFile = JOptionPane.showInputDialog("The name of the input file ");
		System.out.println("Name of the file: ");
		String nameOfFile = sc.next();
		Scanner scan = new Scanner(new File(nameOfFile));
		scan.useDelimiter(",");
		

		// For Students
		for (int i = 0; i < numOfStu; i++) {
			workers[i] = new StudentEmployee(scan.next(), scan.next(), scan.next(), scan.next(), scan.next(),
					scan.next());
			System.out.println(workers[i]);
		}
		// For clasStaff
		for (int i = numOfStu; i < (numOfStu + numOfClasSatff); i++) {
			workers[i] = new ClassifiedStaff(scan.next(), scan.next(), scan.next(), scan.next(), scan.next());
			System.out.println(workers[i]);
		}
		// For
		for (int i = (numOfStu + numOfClasSatff); i < (numOfStu + numOfClasSatff + numOfFac); i++) {
			workers[i] = new Faculty(scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next());
			System.out.println(workers[i]);
		}
		scan.close();
		sc.close();
		System.out.println("\nPay for two-week pay period");
		System.out.println("===========================");
		for (int i = 0; i < 11; i++) {
			if (workers[i].isWorking()) {
				System.out.println(workers[i].getEmployeeName() + "\t$" + workers[i].getPay());
			}
		}

	}
}
