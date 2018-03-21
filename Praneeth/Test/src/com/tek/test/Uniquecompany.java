package com.tek.test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Uniquecompany {

	public static void main(String a[]) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader("sample//test.csv.txt"));
		Set<String> uniqueSet = new HashSet<String>();
		List<String> duplicateList = new ArrayList<>();

		String line;

		int linescounter = 0;
		int iteration = 0;

		while ((line = reader.readLine()) != null) {
			if(iteration == 0) {
		        iteration++;  
		        continue;
		    }

			uniqueSet.add(line);
			linescounter += 1;
			if (linescounter > uniqueSet.size()) {
				duplicateList.add(line);
				linescounter -= 1;
			}
			//duplicateList.remove(line);
		}
		for (String uni : uniqueSet) {
			System.out.println(uni);
		}
	//	String fsplit=" ";
		
	   Object[] arrayItem = uniqueSet.toArray(); 
		for(int i = 0; i < uniqueSet.size();i++){
		    
			// System.out.println(arrayItem[0]);
			
	
		}
		reader.close();
	}
	
	
}
