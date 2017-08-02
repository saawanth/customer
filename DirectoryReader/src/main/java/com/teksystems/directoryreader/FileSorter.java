package com.teksystems.directoryreader;

import java.io.File;
import java.util.List;

public interface FileSorter {

	public List<String> sortFiles(String[] listOfFileNames);

	public List<File> sortFiles(File[] listOfFileNames);

}
