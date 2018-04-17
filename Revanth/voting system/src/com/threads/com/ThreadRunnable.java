package com.threads.com;

public class ThreadRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadsPractice tp1 = new ThreadsPractice("Revanth");
		Thread thread1 = new Thread(tp1,"Renu");
		thread1.start();
		System.out.println(thread1.getName());
	}
}
