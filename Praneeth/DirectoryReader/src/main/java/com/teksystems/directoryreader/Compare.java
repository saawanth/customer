package com.teksystems.directoryreader;

import java.io.File;
import java.util.Comparator;

public class Compare implements Comparator<String> {
	
	private static final String DELIMETER = File.separator + ".";

	public int compare(String s1, String s2) {
		String One = getFileExten(s1);
		String two = getFileExten(s2);
		
		if(One.compareTo(two)<0)
			return -1;
		else if(One.compareTo(two)>0)
			return 1;
		else 
			return 0;
	}
	
	public String getFileExten(String item)
	{
		String[] split = item.split(DELIMETER);
		String temp = "." + split[split.length - 1];
		return temp;
	}

}



	
	
