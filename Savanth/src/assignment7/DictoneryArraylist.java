package assignment7;
/*ArrayList is part of collection framework in Java. Therefore array members are accessed using [],
while ArrayList has a set of methods to access elements and modify them. Array is a fixed size data structure
while ArrayList is not. One need not to mention the size of Arraylist while creating its object.*/

import java.util.*;

public class DictoneryArraylist {
	public static void main( String [] args  ) {

    	ArrayList<String> list = new ArrayList<String>();
       String[]  array1= {"A", "Mahesh", "abc", "123", "4serv", "Abcd"};
		list.addAll(Arrays.asList(array1));

      Collections.sort( list , new Comparator<String>(){
            public int compare( String a, String b ){
                
           /*     if( a.matches("\\d+") && b.matches("\\d+")) {
                    return new Integer( a ) - new Integer( b );
                }
                
                return a.compareTo( b );*/
           	return ((a.toUpperCase()).compareTo(b.toUpperCase()));
//           	return a.compareToIgnoreCase(b);
            }
        });
        System.out.println( list );
//=======================================
	/*	Collections.sort(list);
		System.out.println(list);*/
//=======================================
     /*   Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        System.out.println(list);*/
    }
}