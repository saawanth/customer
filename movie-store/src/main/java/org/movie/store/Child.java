package org.movie.store;

class Parent {
	protected static int count = 0;

	public Parent() {
		count++;
	}

	static int getCount() {
		return count;
	}

	int myCount() {
		return count;
	}
}

public class Child extends Parent {
	private int childCount = 10;

	public Child() {
		count++;
	}

	class MyCount {

		public int getChildCount() {
			return childCount;
		}

	}

	public static void main(String args[]) {

		String s1 = "ABC";
		StringBuffer sb = new StringBuffer(s1);

		System.out.println(sb.equals(s1));
		System.out.println(s1.equals(sb));

		System.out.println(getCount());
		Child obj = new Child();
		Child.MyCount myCount = new Child().new MyCount();
		System.out.println(getCount());
		System.out.println(getCount());
		int a = 9, b = 2;
		float f = a / b;
		System.out.println(f);
		f = f / 2;
		System.out.println(f);
		f = a + b / f;
		System.out.println(f);

	}
}