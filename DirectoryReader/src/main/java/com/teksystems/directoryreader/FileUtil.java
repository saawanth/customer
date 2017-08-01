package com.teksystems.directoryreader;

import java.io.File;

public class FileUtil {
	private static final String DELIMETER = File.separator + ".";

	public static String getFileExtension(File file) {
		String fileName = file.getName();
		return getFileExtension(fileName);
	}

	public static String getFileExtension(String fileName) {
		String fileExten = null;
		String[] split = fileName.split(DELIMETER);
		if (split != null && split.length > 0) {
			fileExten = "." + split[split.length - 1];
		}
		return fileExten;
	}

}
