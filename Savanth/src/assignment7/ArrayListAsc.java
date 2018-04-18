package assignment7;


import java.util.ArrayList;
import java.util.Collections;

public class ArrayListAsc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
     ArrayList<Integer> intarray = new ArrayList<Integer> ();
//       intarray.addAll(1,2,2,3,6,8,8,9);
     intarray.add(1);
     intarray.add(2);
     intarray.add(2);
     intarray.add(3);
     intarray.add(6);
     intarray.add(8);
     intarray.add(8);
     intarray.add(9);
     System.out.println("Before Sorting:");
	   for(Integer str: intarray){
			System.out.println(str);
		}
      System.out.println("ArrayList Size:"+intarray.size());  
	  Collections.sort(intarray);
	   System.out.println("Ascending Order");
	   for(Integer str: intarray){
			System.out.println(str);
		}
	   Collections.reverse(intarray);
	   System.out.println("Descending  Order");
	   for(Integer str: intarray){
			System.out.println(str);
		}
	}

}
