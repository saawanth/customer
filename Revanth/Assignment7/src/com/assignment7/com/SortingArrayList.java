package com.assignment7.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortingArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.addAll(Arrays.asList(1,2,2,3,6,8,8,9));
		System.out.println("The ArrayList before sorting: " + arrayList);
		Collections.sort(arrayList);
		System.out.println("The ArrayList after sorting: " + arrayList);
		Collections.reverse(arrayList);
		System.out.println("In DESCENDING ORDER: " + arrayList);
	}

}
