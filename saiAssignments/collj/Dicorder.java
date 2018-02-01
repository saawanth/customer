package collj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Dicorder {

	public static void main(String[] args){
		
		ArrayList<String> list = new ArrayList<>(Arrays.asList("A","Mahesh","abc","123","4 Serv","Abcd"));
		System.out.println("The Entered values are " + list);
		
		Collections.sort(list);
		System.out.println("Disctionary order of list is "+ list);
	}
}
