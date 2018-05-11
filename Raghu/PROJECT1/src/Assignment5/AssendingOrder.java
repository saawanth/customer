package Assignment5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AssendingOrder {
	
	 public static void main(String[] args) {
	 
	    ArrayList<Integer> p =new ArrayList<Integer>();
		p.addAll(Arrays.asList(1,2,2,3,6,8,8,9));
		System.out.println("before Sorting");
		System.out.println(p);
		Collections.sort(p,Collections.reverseOrder());
		System.out.println("\nAfter sorting");
		System.out.println(p);
		
			
		}

	}


