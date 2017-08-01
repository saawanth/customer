package com.teksystems.directoryreader;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileSorterByExtension implements FileSorter {

	private static final Comparator<File> fileExtnComparator = new Comparator<File>() {
		@Override
		public int compare(File o1, File o2) {
			String o1FileExtn = FileUtil.getFileExtension(o1);
			String o2FileExtn = FileUtil.getFileExtension(o2);

			if ((o1FileExtn == null || o1FileExtn.equals("")) && (o2FileExtn == null || o2FileExtn.equals(""))) {
				return o1.getName().compareTo(o2.getName());
			} else if (o1FileExtn != null && !o1FileExtn.equals("") && (o2FileExtn == null || o2FileExtn.equals(""))) {
				return -1;
			} else if (o2FileExtn != null && !o2FileExtn.equals("") && (o1FileExtn == null || o1FileExtn.equals(""))) {
				return 1;
			} else {
				return o1FileExtn.compareTo(o2FileExtn);
			}
		}
	};

	private static final Comparator<String> filenameExtnComparator = new Comparator<String>() {
		@Override
		public int compare(String f1, String f2) {
			String f1FileExtn = FileUtil.getFileExtension(f1);
			String f2FileExtn = FileUtil.getFileExtension(f2);

			if ((f1FileExtn == null || f1FileExtn.equals("")) && (f2FileExtn == null || f2FileExtn.equals(""))) {
				return f1.compareTo(f2);
			} else if (f1FileExtn != null && !f1FileExtn.equals("") && (f2FileExtn == null || f2FileExtn.equals(""))) {
				return -1;
			} else if (f2FileExtn != null && !f2FileExtn.equals("") && (f1FileExtn == null || f1FileExtn.equals(""))) {
				return 1;
			} else {
				return f1FileExtn.compareTo(f2FileExtn);
			}
		}
	};

	/**
	 * This methods sort the list of files by extension
	 *
	 * @param listOfFileNames
	 * @return
	 */
	public List<String> sortFiles(String[] listOfFileNames) {
		List<String> orginalList = Arrays.asList(listOfFileNames);
		Collections.sort(orginalList, filenameExtnComparator);
		return orginalList;
	}

	@Override
	public List<File> sortFiles(File[] listOfFileNames) {
		List<File> origFileList = Arrays.asList(listOfFileNames);
		Collections.sort(origFileList, fileExtnComparator);
		return origFileList;
	}

}
