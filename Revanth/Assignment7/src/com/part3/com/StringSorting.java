package com.part3.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StringSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		list.addAll(Arrays.asList("A", "Mahesh", "abc", "123", "4 Serv", "Abcd", "Revanth"));
		System.out.println("Given List: " + list);
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
		System.out.println("Sorted list using comparator: " + list);
		Collections.reverse(list);
		System.out.println("\nReverse Order: " + list);

		if (!((list.size() % 2) == 0)) {
			System.out.println("Middle element is: " + list.get((list.size() / 2)));

		} else {
			System.out.println("The size is even can you add one more element");
		}

	}

}
