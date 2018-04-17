package com.singleton.com;

public class A {



	private A() {

	}

	private static class B {
		private static final A instance = new A();
	}

	public static A getInstance() {
		
		return B.instance;
	}

}
