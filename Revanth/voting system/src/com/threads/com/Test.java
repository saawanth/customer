package com.threads.com;

public class Test {
	public static void main(String[] args) {
		Thread thr = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Hello!!!");
 
				}
			}
		};
		Thread thr1 = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Rev!!!");

				}
			}
		};
		thr1.setPriority(Thread.MAX_PRIORITY);
		thr.start();

		thr1.start();
	}

}