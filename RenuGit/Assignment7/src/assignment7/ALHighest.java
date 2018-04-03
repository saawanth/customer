package assignment7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ALHighest {
public static void main(String args[]){
	ArrayList<Integer> aList = new ArrayList<>();
	aList.addAll(Arrays.asList(3,5,6,7,9,23,90,25,54,67,8,99,12,33,65,44,76,33,100,200,23,43,55,3,4,5,6,7,8));
	Collections.sort(aList);
	System.out.print("[");
	for(int i = 20; i < aList.size(); i++){
		System.out.print(aList.get(i) + ",");
	}
	System.out.print("]");
}
}
