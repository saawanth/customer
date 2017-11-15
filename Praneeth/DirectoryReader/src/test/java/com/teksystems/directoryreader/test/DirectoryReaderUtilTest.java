package com.teksystems.directoryreader.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.teksystems.directoryreader.DirFileFilterUtil;
import com.teksystems.directoryreader.SortFilesImpl;


public class DirectoryReaderUtilTest {
	SortFilesImpl sorter = new SortFilesImpl();

	@Test
	public void SubDirectortCountTest() {
		File rootDirectory = new File("./testdirectory/Main Project");
		File subDirectory1 = new File("./testdirectory/Main Project/Project 1");
		File subDirectory2 = new File("./testdirectory/Main Project/Project 2");

		assertEquals(2, DirFileFilterUtil.list(rootDirectory).length);
		assertEquals(3, DirFileFilterUtil.list(subDirectory1).length);
		assertEquals(2, DirFileFilterUtil.list(subDirectory2).length);

	}

	@Test
	public void SubDirectoryFileNameTest() {

		File subDirectory1 = new File("./testdirectory/Main Project/Project 1");
		String[] expected = { "ExcelFile1.xlsx", "Project A", "WordFile1.docx" };
		String[] actual = DirFileFilterUtil.list(subDirectory1);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void FileSortOrderPassTest() {

		String[] listOfFiles = { "Excelfile.xlsx", "WordFile1.docx", "Project A" };
		List<String> expectedResult = Arrays.asList( "WordFile1.docx", "Excelfile.xlsx","Project A");
		List<String> actualResult = sorter.sortFilesByExtensions(listOfFiles);
		assertThat(actualResult, is(expectedResult));
	}

	@Test
	public void FileSortOrderFailTest() {
		SortFilesImpl sorter = new SortFilesImpl();
		String[] listOfFiles = { "Excelfile.xlsx", "WordFile1.docx", "Project A" };
		List<String> expectedResult = Arrays.asList("Project A", "Excelfile.xlsx", "WordFile1.docx");
		List<String> actualResult = sorter.sortFilesByExtensions(listOfFiles);
		assertThat(actualResult, is(not(expectedResult)));
	}

}
