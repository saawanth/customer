package com.singleton.com;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(A.class.getName());
		System.out.println(A.getInstance());
		System.out.println(A.getInstance());
		System.out.println(A.getInstance().equals(A.getInstance()));
		int i = 9;
		System.out.println(i++);
		System.out.println(i);
		System.out.println(A.class);
	}
}
