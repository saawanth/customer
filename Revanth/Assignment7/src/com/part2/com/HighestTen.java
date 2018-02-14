package com.part2.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HighestTen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(1, 2, 3, 4, 45, 6, 6, 7, 7, 8, 98, 98, 97, 9, 899, 8776, 877, 765, 45, 34, 76, 87, 98,
				43, 54, 76, 87, 98, 9, 0, 85));
		Collections.sort(list);
		Collections.reverse(list);
		System.out.println("Highest 9 numbers from the list");
		for (int i = 0; i < 9; i++) {

			System.out.println(list.get(i));
		}
	}

}
