package collj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Top10 {

	public static void main(String[] args) {
		
		ArrayList<Integer> listofnum=new ArrayList<Integer>();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter 30 numbers");
		for(int i=0;i<30;i++){
			int a= sc.nextInt();
			listofnum.add(a);
		}
		System.out.println("Entered numbers are"+listofnum);
		Collections.sort(listofnum);
		Collections.reverse(listofnum);
		
		System.out.println("List of highest 10 numbers is:"+listofnum.subList(0,10));
		
		
	}

}
