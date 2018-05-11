package Assignment2;

import java.util.Scanner;

public class Method {
	
	
	public void add(){
		System.out.println();
		System.out.println("Hi");
	}
	
	public double d1(){
		
		System.out.println("20.5");
		
		return 20.5;
	}
	public String s1(int a){
		return "raghu";
	}
		public static void main(String args[]){
			Method m=new Method();
			Scanner sc=new Scanner(System.in);
			System.out.println("enter variable");
			int variable;
			variable=sc.nextInt();
			System.out.println("Double function "+m.d1());
			System.out.println("Void function");
			m.add();
			System.out.println("Display string function "+m.s1(variable));
			sc.close();
		
	}
	
}
