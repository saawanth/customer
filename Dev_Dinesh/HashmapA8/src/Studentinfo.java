import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;

public class Studentinfo {

	Map<String, Student> Database = new HashMap<>();
	List<Student> Students;
	SimpleDateFormat formattedDate = new SimpleDateFormat("MM-dd-yyyy");
	Map<Date, List<Student>> DateMap = new HashMap<>();

	// Loading Student Database to HashMap with Email as Key
	public void loadInventory(File studentDatabase) {
		BufferedReader br = null;
		List<Student> sd;
		Date d = null;
		try {
			br = new BufferedReader(new FileReader(studentDatabase));
			String line = "";
			while ((line = br.readLine()) != null) {
			
				String str[] = line.split(",");
				try {
					d = formattedDate.parse(str[1]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String datePattern = formattedDate.format(d);
				Student student = new Student(str[0], datePattern, str[2]);
				Database.put(str[2], student);
//HashMap with dates
				if (DateMap.containsKey(d)) {
					sd = DateMap.get(d);
					sd.add(student);
					DateMap.put(d, sd);
				} else {
					sd = new ArrayList<>();
					sd.add(student);
					DateMap.put(d, sd);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// To Display Ascending Order of List of Students
	public void ascendingOrderList() {
		List<Student> ascendingOrder = new ArrayList<>();
		List<String> emailNames = new ArrayList<>();
		emailNames.addAll(Database.keySet());
		ascendingOrder.addAll(Database.values());
		Collections.sort(ascendingOrder, new SortbyDOB());
		for (Student s : ascendingOrder) {
			System.out.println(s);
		}
		/*
		 * for (Map.Entry<String, Student> entry : Database.entrySet()) {
		 * System.out.println("Key = " + entry.getKey() + ", Value = " +
		 * entry.getValue()); }
		 */
	}

	// To Display List of students born on same date
	public void sameDOB(String DOB) {
		List<Student> students = new ArrayList<>();
		students.addAll(Database.values());
		List<Student> sameDateList = new ArrayList<>();
		for (Student s : students) {
			if (s.date.equals(DOB)) {
				sameDateList.add(s);
			}
		}
		for (Student s : sameDateList) {
			System.out.println(s);
		}
	}

	public void before(String DOB) {
		List<Student> BornBefore = new ArrayList<>();
		Date d2 = null;
		try {
			d2 = formattedDate.parse(DOB);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (Date d : DateMap.keySet()) {
			if (d.before(d2)) {
				BornBefore.addAll(DateMap.get(d));
			}
		}
		for (Student s : BornBefore) {
			System.out.println(s);
		}
	}

	public void after(String DOB) {
		List<Student> BornAfter = new ArrayList<>();
		Date d2 = null;
		try {
			d2 = formattedDate.parse(DOB);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (Date d : DateMap.keySet()) {
			if (d.after(d2)) {
				BornAfter.addAll((DateMap.get(d)));
			}
		}
		for (Student s : BornAfter) {
			System.out.println(s);
		}

	}

	public void DateRange(List<String> range) {
		
	}

	public void addOp(List<String> students) {
		Student std1 = new Student(students.get(0), students.get(1), students.get(2));
		Database.put(students.get(2), std1);
		List<Student> students1 = new ArrayList<>();
		students1.addAll(Database.values());
		Collections.sort(students1, new SortbyDOB());
		System.out.println("Updated List after Addition:");
		for (Student s : students1) {
			System.out.println(s);
		}
	}

	public void removeOp(List<String> students) {
		List<Student> students1 = new ArrayList<>();
		List<Student> std = new ArrayList<>();
		students1.addAll(Database.values());
		for (Student s : students1) {
			if ((s.date.equals(students.get(1)) && (s.name.equals(students.get(0))))) {
				String emailKey = s.email;
				Database.remove(emailKey);
			}
		}
		std.addAll(Database.values());
		Collections.sort(std, new SortbyDOB());
		System.out.println("Updated List after Removal:");
		for (Student s : std) {
			System.out.println(s);
		}
	}

	public void updateEmail(List<String> students) {
		List<Student> students1 = new ArrayList<>();
		List<Student> std = new ArrayList<>();
		students1.addAll(Database.values());
		for (Student s : students1) {
			if ((s.date.equals(students.get(1)) && (s.name.equals(students.get(0))))) {
				String emailKey = s.email;
				Database.remove(emailKey);
			}
		}
		Student updatedStudent = new Student(students.get(0), students.get(1), students.get(2));
		std.add(0, updatedStudent);
		std.addAll(Database.values());
		Collections.sort(std, new SortbyDOB());
		System.out.println("Updated List after Removal:");
		for (Student s : std) {
			System.out.println(s);
		}

	}

	public void updateName(List<String> students) {
		List<Student> students1 = new ArrayList<>();
		List<Student> std = new ArrayList<>();
		students1.addAll(Database.values());
		for (Student s : students1) {
			if ((s.date.equals(students.get(1)) && (s.email.equals(students.get(2))))) {
				String emailKey = s.email;
				Database.remove(emailKey);
			}
		}
		Student updatedStudent = new Student(students.get(0), students.get(1), students.get(2));
		std.add(0, updatedStudent);
		std.addAll(Database.values());
		Collections.sort(std, new SortbyDOB());
		System.out.println("Updated List with Name");
		for (Student s : std) {
			System.out.println(s);
		}
	}

	class SortbyDOB implements Comparator<Student> {
		public int compare(Student a, Student b) {
			String d1[] = a.date.split("-");
			String d2[] = b.date.split("-");
			int year1 = Integer.parseInt(d1[2]);
			int month1 = Integer.parseInt(d1[0]);
			int date1 = Integer.parseInt(d1[1]);
			int year2 = Integer.parseInt(d2[2]);
			int month2 = Integer.parseInt(d2[0]);
			int date2 = Integer.parseInt(d2[1]);

			if ((year1 == year2) && (date1 == date2) && (month1 == month2)) {
				return a.name.compareTo(b.name);
			} else if (year1 > year2) {
				a.date.compareTo(b.date);
				return -1;
			} else if (year1 < year2) {
				a.date.compareTo(b.date);
				return 1;
			}
			return 0;
		}
	}
}
