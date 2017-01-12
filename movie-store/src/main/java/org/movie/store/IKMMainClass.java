package org.movie.store;

import java.util.Set;

public class IKMMainClass {

	static int total = 10;

	static class MyCollection<T> {
		private Set<T> set;

		public Set<T> getCollection() {
			return this.set;
		}
	}

	static class Parent {
		protected static int count = 0;

		public Parent() {
			count++;
		}

		static int getCount() {
			return count;
		}
	}

	public class Child extends Parent {
		public Child() {
			count++;
		}

		public void printInfo() {
			System.out.println(getCount());
			Child obj = new Child();
			System.out.println(getCount());
		}
	}

	// static class MyCollection<T> {
	// private Set<T> set;
	//
	// public Set<T> getCollection() {
	// return this.set;
	// }
	// }

	// public static void testCollection(MyCollection<?> collection) {
	// Set<> set = collection.getCollection();
	// }

	public void call() {
		int total = 5;
		System.out.println(this.total);
	}

	public static void main(String[] args) {
		// String first = "first";
		// String second = new String("first");
		// "first".concat("second");
		// System.out.println(first.equals(second));
		// System.out.println(first == second);
		// System.out.println(first.equals("firstsecond"));
		// System.out.println(second == "first");
		//
		// new IKMMainClass().call();
		// int i = 0, j = 0;
		// int counter = 0;
		// outer: for (i = 0; i < 4; i++) {
		// for (j = 0; j < 2; j++) {
		// counter++;
		// if (i == 2)
		// i++;
		// continue outer;
		// }
		// }
		// System.out.println("i=" + i + ", Counter " + counter);
		//
		// ResourceBundle rb = ResourceBundle.getBundle("myTes", new
		// Locale("th", "TH"));
		//

		for (int i = 1; i <= 100; i++) {
			if ((i % 3 == 0) && (i % 7 == 0)) {
				System.out.println("i: " + i + ", foobar");
			} else if ((i % 3) == 0) {
				System.out.println("i: " + i + ", foo");
			} else if ((i % 7) == 0) {
				System.out.println("i: " + i + ", bar");
			}
		}
	}

	private static class Element implements Comparable {

		int id;

		public Element(int id) {
			this.id = id;
		}

		@Override
		public int compareTo(Object o) {
			Element e = (Element) o;
			return this.id - e.id;
		}

		public String toString() {
			return "" + this.id;
		}
	}

	public static class SingletonObject {

		private static volatile SingletonObject singletonObj = null;
		private static final Object lock = new Object();

		private SingletonObject() {
		}

		public static SingletonObject getInstance() {
			if (singletonObj == null) {
				synchronized (lock) {
					if (singletonObj == null) {
						singletonObj = new SingletonObject();
					}
				}
			}
			return singletonObj;
		}
	}

}
