package com.teksystems.directoryreader;

import java.io.File;
import java.util.List;

/**
 * The purpose of this utility is to read and print all the file names under
 * parent directory and all it's subdirectories recursively. The project is
 * working code based on Maven and Java 8. The candidates are supposed to
 * re-factor this utility using good OO principles e.g. Single responsibility
 * principle, interface segregation and code readability. Besides this proper
 * exception handling should also be implemented when make sense.
 * 
 * All the code should be and must be backed by unit testing. Note: the code can
 * be imported and run in any ide, but when candidates submit the code, they are
 * supposed to take all the ide specific code out and submit the project as a
 * zip file with candidate first name and last name as the file name. To run:
 * mvn package and then mvn exec:java
 *
 * @author rjilani
 */
public class DirectoryReaderUitl {

	private static final String FILE_SEPERATOR = File.separator;
	private final FileSorter filesorter;
	private final int lenghtOfDirectory;
	private static final String DELIMETER = File.separator + ".";

	public DirectoryReaderUitl(int lenghtOfDirectory, FileSorter filesorter) {
		this.lenghtOfDirectory = lenghtOfDirectory;
		this.filesorter = filesorter;
	}

	/**
	 * This methods list and print all files recursively
	 *
	 * @param dir
	 * @param tabs
	 */
	public void listAllFilesRecursively(File dir, int tabs) {

		if (dir != null) {
			try {
				String listOfFileNames[] = DirFileFilterUtil.list(dir);
				for (int i = 0; i < tabs; i++) {
					System.out.print("  ");
				}
				System.out.println("- Project: " + dir.getName() + " - URL: "
						+ dir.getAbsolutePath().substring(lenghtOfDirectory));
				List<String> sortedListOfFiles = filesorter.sortFiles(listOfFileNames);
				iterateListOfFiles(sortedListOfFiles, tabs, dir);
			} catch (Exception e) {
				System.out.println("Please provide a path to root directory");
			}
		} else {
			System.out.println(dir + " is not a directory");
		}
	}

	/**
	 * Iterate directory and sub directory
	 *
	 * @param sortedListOfFiles
	 * @param tabs
	 * @param dir
	 */
	private void iterateListOfFiles(List<String> sortedListOfFiles, int tabs, File dir) {
		for (String item : sortedListOfFiles) {
			tabs++;
			File file = new File(dir, item);
			if (file.isDirectory()) {
				listAllFilesRecursively(file, tabs);
				tabs--;
			} else {
				printFileOnconsole(file, tabs);
				tabs--;
			}
		}
	}

	/**
	 * This method prints directory and files on console
	 *
	 * @param file
	 * @param tabs
	 */
	private void printFileOnconsole(File file, int tabs) {
		String fileName = file.getName();
		String[] split = fileName.split(DELIMETER);
		for (int i = 0; i < tabs; i++) {
			System.out.print("  ");
		}
		System.out.println("- Document: " + file.getName() + " - Extension: ." + split[split.length - 1] + " - URL: "
				+ file.getAbsolutePath().substring(lenghtOfDirectory));
	}

	/**
	 * Main driver and entry point
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// File rootDirectory = new File("./testdirectory/Main Project");
		File rootDirectory = new File("C:/projects/DirectoryReader");
		int dirFileLength = rootDirectory.getAbsolutePath().length() - rootDirectory.getName().length();
		FileSorter filesorter = new FileSorterByExtension();
		DirectoryReaderUitl directoryReaderUitl = new DirectoryReaderUitl(dirFileLength, filesorter);
		directoryReaderUitl.listAllFilesRecursively(rootDirectory, 0);
	}
}
