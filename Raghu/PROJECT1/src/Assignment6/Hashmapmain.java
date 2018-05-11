package Assignment6;

import java.io.*;
import java.text.*;
import java.util.*;

public class Hashmapmain {

	private static Scanner sc;
	private static Scanner s;

	public static void main(String[] args) throws ParseException, FileNotFoundException {
		s = new Scanner(System.in);

		sc = new Scanner(new FileReader("/Users/raghu/all.csv"));

		Date d;
		String Name, Email, DOB;
		String[] str;
		TreeMap<Date, List<Student>> H = new TreeMap<Date, List<Student>>();
		SimpleDateFormat D = new SimpleDateFormat("dd-mm-yyyy");
		String line = "";
		String cvsSplitBy = ",";
		while (sc.hasNext()) {
			line = sc.nextLine();
			str = line.split(cvsSplitBy);
			d = D.parse(str[1]);
			if (H.containsKey(d)) {
				List<Student> LS = H.get(d);
				Student newStudent = new Student(str[0], str[2]);
				LS.add(newStudent);
				H.put(d, LS);
			} else {
				List<Student> LS = new ArrayList<Student>();
				Student newStudent = new Student(str[0], str[2]);
				LS.add(newStudent);
				H.put(d, LS);
			}
		}

		do {
			System.out.println("Choose an operation from Below list:");
			System.out.println("1. To add new user details");
			System.out.println("2. To view all user details:");
			System.out.println("3. To Delete a User");
			System.out.println("4. To retirve Users born on a specific Date");
			System.out.println("5. To find users before and after specific date:");
			int opt = s.nextInt();
			switch (opt) {
			case 1:
				System.out.println("Enter the user DOB in dd-MM-yyyy format:");
				DOB = s.next();
				System.out.println("Enter the user  Name:");
				Name = s.next();
				System.out.println("Enter the user Email:");
				Email = s.next();
				d = D.parse(DOB);
				if (H.containsKey(d)) {
					List<Student> LS = H.get(d);
					Student newStudent = new Student(Name, Email);
					LS.add(newStudent);
					H.put(d, LS);
				} else {
					List<Student> LS = new ArrayList<Student>();
					Student newStudent = new Student(Name, Email);
					LS.add(newStudent);
					H.put(d, LS);
				}
				break;
			case 2:
				for (Map.Entry<Date, List<Student>> m : H.entrySet()) {
					System.out.println("Date of Birth:" + m.getKey());
					String date=D.format(m.getKey());
					System.out.println("Date of Birth: "+date);
					List<Student> LS = m.getValue();
					Collections.sort(LS, new StudentSort());;
					for (Student m1 : LS) {
						System.out.println(m1.getName());
					}
					System.out.println("\n");
				}
				break;
			case 3:
				System.out.println("Enter the name of user to be deleted");
				String delStudent = s.next();
				System.out.println("Enter the Date of birth of user in dd-MM-yyyy format:");
				String tempDate = s.next();
				Date tempD = D.parse(tempDate);
				System.out.println("Date"+tempD);
				if (H.containsKey(tempD)) {
					List<Student> LS = H.get(tempD);
					for (Student p : LS) {
						System.out.println("List"+LS);
						if (delStudent.equals(p.getName())) {
							LS.remove(p);
							System.out.println("User is deleted");
						}

						else {
							System.out.println("No user found with the given date");
						}
					}
				}
				break;

			case 4:
				System.out.println("Enter the Date of birth of user in dd-MM-yyyy format:");
				String retDate = s.next();
				Date retD = D.parse(retDate);
				if (H.containsKey(retD)) {
					List<Student> LS = H.get(retD);

					for (Student p : LS) {
						System.out.println(p.getName());
					}

				} else {
					System.out.println("No user found with the given date");
				}
				break;
			case 5:
				System.out.println("Enter the Date of birth of user in dd-MM-yyyy format:");
				String reDate = s.next();
				Date reD = D.parse(reDate);
				if (H.containsKey(reD)) {

					for (Map.Entry<Date, List<Student>> e : H.entrySet()) {
						if (!(reD.toString().equals(e.getKey().toString()))) {
							System.out.println(e.getValue());
						}
					}

				} else {
					System.out.println("No user found with the given date");
				}
				break;
			}

		} while (true);

	}

}

class StudentSort implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		return s1.getName().compareToIgnoreCase(s2.getName());
	}
}
