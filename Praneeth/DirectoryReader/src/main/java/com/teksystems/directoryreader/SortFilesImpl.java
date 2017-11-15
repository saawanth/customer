package com.teksystems.directoryreader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortFilesImpl implements SortFiles{

	@Override
	public  List<String> sortFilesByExtensions(String[] listOfFileNames) {
		List<String> originalList = new ArrayList<>();
		Arrays.asList(listOfFileNames).stream().filter((s1) -> (s1.contains(".")))
				.forEach((s1) -> originalList.add(s1));
		Collections.sort(originalList, new Compare());
		Arrays.asList(listOfFileNames).stream().filter((s1) -> (!originalList.contains(s1)))
				.forEach((s1) -> originalList.add(s1));
		return originalList;
	}
	
	
	
}
