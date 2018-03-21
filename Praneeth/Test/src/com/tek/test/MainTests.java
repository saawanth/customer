package com.tek.test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class MainTests {

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testMain() throws Exception {
		//System.out.println("main");
		String[] args = null;
		MainTest.main(args);

	}

	MainTest m = new MainTest();
	
	@Test
	public void testReadDataFromFile() throws Exception {
		//System.out.println("readDataFromFile")
		File file = null;
		MainTest.readDataFromFile(file);
	   assertNotSame("null",null);
				
	}

}
