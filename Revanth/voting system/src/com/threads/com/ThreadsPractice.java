package com.threads.com;

public class ThreadsPractice implements Runnable {
	private String name;
	
	public ThreadsPractice(String name) {
		this.name = name;
		Thread thread1 = new Thread(this,name);
		thread1.start();
		
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " : " + name);
		}
	}
}

