package assignment7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortingString {
public static void main(String args[]){
	ArrayList<String> aList = new ArrayList<>();
	aList.addAll(Arrays.asList("A","Mahesh","abc","123","4 Serv","Abcd")); 
	
	Collections.sort(aList,new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
        	return o1.compareTo(o2);
        }
});
	
	System.out.println(aList);
}
}
