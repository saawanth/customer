package com.teksystems.directoryreader;

import java.io.File;

public class DirFileFilterUtil {

	/**
	 * This methods list and print all files recursively
	 *
	 * @param dir
	 * @param tabs
	 * @return
	 */
	public static String[] list(File dir) {

		if (dir != null) {
			if (dir.isDirectory()) {
				String listOfFileNames[] = dir.list();
				return listOfFileNames;
			} else {
				System.out.println("Please provide a path to root directory");
			}
		} else {
			System.out.println(dir + " is not a directory");
		}
		return null;
	}

	/**
	 * This methods list and print all files recursively
	 *
	 * @param dir
	 * @param tabs
	 * @return
	 */
	public static File[] listAllFiles(File dir) {

		if (dir != null) {
			if (dir.isDirectory()) {
				File[] listOfFiles = dir.listFiles();
				return listOfFiles;
			} else {
				System.out.println("Please provide a path to root directory");
			}
		} else {
			System.out.println(dir + " is not a directory");
		}
		return null;
	}

}
