package com.Part1.com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class HashMapAssignment {
	private List<Date> list = new ArrayList<>();
	private HashMap<Date, List<Student>> map = new HashMap<>();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	Scanner sc = new Scanner(System.in);

	public void mapFunction(String name, String dob, String mailId) throws ParseException {
		Student student = new Student(name, dob, mailId);
		if (map.containsKey(sdf.parse(dob))) {
			List<Student> arrayList = new ArrayList<>();
			arrayList.addAll(map.get(sdf.parse(dob)));
			arrayList.add(student);
			Collections.sort(arrayList, new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
			if (!list.contains(sdf.parse(dob))) {
				list.add(sdf.parse(dob));
			}
			map.put(sdf.parse(dob), arrayList);
		} else {
			List<Student> arrayList2 = new ArrayList<>();
			arrayList2.add(student);
			list.add(sdf.parse(dob));
			map.put(sdf.parse(dob), arrayList2);
		}
		Collections.sort(list, new Comparator<Date>() {

			@Override
			public int compare(Date o1, Date o2) {
				return o1.compareTo(o2);
			}

		});
	}

	public void display() {
		Iterator<Date> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(map.get(itr.next()));
		}
	}

	public void addElement() throws ParseException {
		System.out.println("Enter the dob of the student going to added by u:");
		String date1 = sc.next();
		System.out.println("Enter the Name of the student:");
		String name1 = sc.next();
		System.out.println("Enter the email of the student:");
		String email1 = sc.next();
		mapFunction(name1, date1, email1);
		display();
	}

	public void updateElement() throws ParseException {
		System.out.println("Enter the desired \"D.O.B\" of student to whom you want to update the name:");
		String date2 = sc.next();
		List<Student> updateList = new ArrayList<>();
		updateList.addAll(map.get(sdf.parse(date2)));
		int numOfStu = updateList.size();
		System.out.println("There are " + numOfStu + " students on this D.O.B");
		System.out.println("Enter the Name of the student to be updated: ");
		String nameEdit = sc.next();
		System.out.println("Enter the Updated Name of the student");
		String name = sc.next();
		int count = 0;
		for (int i = 0; i < updateList.size(); i++) {
			String nameOfUpdateStu = updateList.get(i).getName();
			if (nameEdit.equals(nameOfUpdateStu)) {
				updateList.get(i).setName(name);
				count++;
				display();
			} else if (count == 0) {
				System.out.println("Enter the correct Name and D.O.B");
			}
		}

	}

	public void removeElement() throws ParseException {
		System.out.println("Enter the desired D.O.B of student to remove from list:");
		String date3 = sc.next();
		List<Student> updateList = new ArrayList<>();
		updateList.addAll(map.get(sdf.parse(date3)));
		int numOfStu = updateList.size();
		System.out.println("There are " + numOfStu + " students on this D.O.B");
		System.out.println("Enter the Name of the student to be removed: ");
		String nameRemove = sc.next();
		for (int i = 0; i < updateList.size(); i++) {
			String nameOfUpdateStu = updateList.get(i).getName();
			if (nameRemove.equals(nameOfUpdateStu)) {
				if (numOfStu == 1) {
					Date date = sdf.parse(updateList.get(0).getDob());
					list.remove(date);
				}
				updateList.remove(i);
			}
		}
		map.put(sdf.parse(date3), updateList);
		System.out.println("\nValues after the delete operation:");
		display();
	}

	public void listOfStudents() throws ParseException {
		System.out.println("Enter dob of the student");
		String dob = sc.next();
		try {
			System.out.println(map.get(sdf.parse(dob)));
		} catch (IllegalStateException e) {
			System.err.println("Enter the existing D.O.B");
		}
	}

	public void groupBy() throws ParseException {
		System.out.println("Enter the D.O.B to find all students who are born before and after that date");
		String dob = sc.next();
		System.out.println("\nStudents who born before the given D.O.B");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).before(sdf.parse(dob))) {
				System.out.println(map.get(list.get(i)));
			}
		}

		System.out.println("\nStudents who born after the given D.O.B");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).after(sdf.parse(dob))) {
				System.out.println(map.get(list.get(i)));
			}
		}
	}

	public void range() throws ParseException {
		System.out.println("Enter the D.O.B to find all students who are born from date range");
		String range1 = sc.next();
		System.out.println("Enter the D.O.B to find all students who are born till date range");
		String range2 = sc.next();
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).after(sdf.parse(range1)) && list.get(i).before(sdf.parse(range2))) {
				System.out.println(map.get(list.get(i)));
				count++;
			} else if (count == 0) {
				System.out.println("OOOPS!!! No students Found!");
			}
		}
	}

}
