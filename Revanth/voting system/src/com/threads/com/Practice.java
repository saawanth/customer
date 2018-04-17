package com.threads.com;

public class Practice extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread("Revanth").start();
		new Thread("Ren").start();
		new Thread("KOVU").start();

		ThreadGroup group = Thread.currentThread().getThreadGroup();

		Thread[] tarray = new Thread[10];
	
	
		group.enumerate(tarray);
	
		for (int i = 0; i < 4; i++) {
			System.out.println(tarray[i].getName() + "  " + group.getName());
		}
	}
}
