package com.example.com;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CubbyHole {
	private int contents;
	private boolean available = false;

	public synchronized int get() {
		while (available == false) {
			try {
				wait();
			} catch (InterruptedException ex) {
				Logger.getLogger(CubbyHole.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		available = false;
		notifyAll();
		return contents;
	}

	public synchronized void put(int value) {
		while (available == true) {
			try {
				wait();
			} catch (InterruptedException ex) {
				Logger.getLogger(CubbyHole.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		contents = value;
		available = true;
		notifyAll();
	}
}
