package com.connectionpool.com;

public class PoolMain {

	public static void main(String[] args) {

		ConnectionPool cp = new ConnectionPool();

		Thread t1 = new Thread(cp, "First");
		Thread t2 = new Thread(cp, "Second");

		t1.start();
		t2.start();
	}
}
