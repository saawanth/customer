package com.assignment6.com;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Practise {
	public static void main(String[] args) {
		   Calendar c = new GregorianCalendar();
		   String s1 = String.format("Duke's Birthday: %1$tm %1$te,%1$tY", c);

		   String s2 = String.format("Duke's Birthday: %1$tm %<te,%<tY", c);
		   
		   System.out.println(s1 + "\n" + s2);
	}
}
