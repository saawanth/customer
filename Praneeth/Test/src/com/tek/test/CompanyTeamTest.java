package com.tek.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.jupiter.api.Test;

public class CompanyTeamTest {

	public CompanyTeamTest() {
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

	@Rule
	CompanyTeam ct = new CompanyTeam("ACE", "offshore", "xy", "200", "dev");
	CompanyTeamsMgr instance = new CompanyTeamsMgr();

	@Test
	public void testGetTeam() {
		System.out.println("getTeam");
		String result = ct.getTeam();
		assertEquals("dev", result);

	}

	@Test
	public void testSetTeam() {
		System.out.println("setTeam");
		String team = "ACE";
		ct.setTeam(team);
		assertEquals("ACE", team);

	}

	@Test
	public void testGetBudget() {
		System.out.println("getBudget");
		String expResult = "200";
		String result = ct.getBudget();
		assertEquals(expResult, result);

	}

	@Test
	public void testSetBudget() {
		System.out.println("setBudget");
		String budget = "200";
		ct.setBudget(budget);
		assertEquals("200", budget);

	}

	@Test
	public void testGetProjectCode() {
		System.out.println("getProjectCode");
		String result = ct.getProjectCode();

		assertEquals("xy", result);
	}

	@Test
	public void testSetProjectCode() {
		System.out.println("setProjectCode");
		String pcode = "XY";
		ct.setProjectCode(pcode);
		assertEquals("XY", pcode);
	}

}
