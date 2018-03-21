package com.tek.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class CompanyTeamsMgrTest {

	public CompanyTeamsMgrTest() {
	}

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

	CompanyTeam ct = new CompanyTeam("ACE", "offshore", "xy", "200", "dev");
	CompanyTeamsMgr instance = new CompanyTeamsMgr();
	
	@Test
	public void testRecordTeamIfNotAvailable() {
		System.out.println("recordTeamIfNotAvailable");
		instance.recordTeamIfNotAvailable("hello", ct);
		assertEquals("ACE", "hello");

	}

	@Test
	public void testLogAllTeams() {
		System.out.println("logAllTeams");
		String expected = "1";
		instance.logAllTeams();
		assertEquals(expected,1 );

	}

	@Test
	public void testGetTeams() {
		System.out.println("getTeams");
		String company = "xyzzdsz";
		String projectName = "ydss";
		int result = instance.getTeams(company, projectName);
		System.out.println(result);
		assertEquals(3, result);

	}

	@Test
	public void testGetTeamBudget() {
		System.out.println("getTeamBudget");
		String projectCode = "Accbdbfdf";
		String teamName = "red";
		double expResult = 0.0;
		double result = instance.getTeamBudget(projectCode, teamName);
		assertEquals(expResult, result);

	}
}
