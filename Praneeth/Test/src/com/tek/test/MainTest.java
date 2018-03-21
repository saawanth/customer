package com.tek.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class MainTest {

	public static void main(String[] args) throws IOException {
		File file = new File("sample\\test.csv.txt");
		readDataFromFile(file);
		CompanyTeamsMgr.getInstance().logAllTeams();
		CompanyTeamsMgr.getInstance().getTeams("Acme", "Offshoredrilling");
		CompanyTeamsMgr.getInstance().getTeamBudget("GERD", "Development");
	}

	public static void readDataFromFile(File file) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			line = line.replaceAll("\"", "");

			String[] headers = line.split(",");
			line = br.readLine();

			while (line != null) {
				line = line.replaceAll("\"", "");
				CompanyTeam team = buildTeam(headers, line);
				CompanyTeamsMgr.getInstance().recordTeamIfNotAvailable(team.getCompany(), team);
				line = br.readLine();
			}
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}

	private static CompanyTeam buildTeam(String[] headers, String line) {
		String[] lineVals = line.split(",");
		String company = lineVals[0];
		String project = lineVals[1];
		String projectCode = lineVals[2];
		String budget = lineVals[3];
		String team = lineVals[4];

		CompanyTeam teamObj = new CompanyTeam(company, project, projectCode, budget, team);
		return teamObj;
	}
}

class CompanyTeamsMgr {

	private Map<String, Set<CompanyTeam>> allCompanyTeams = new LinkedHashMap<>();

	public static CompanyTeamsMgr instance = new CompanyTeamsMgr();

	public CompanyTeamsMgr() {
		super();
	}

	public void recordTeamIfNotAvailable(String companyName, CompanyTeam team) {
		Set<CompanyTeam> companyTeams = allCompanyTeams.get(companyName);
		if (companyTeams == null) {
			companyTeams = new LinkedHashSet<CompanyTeam>();
			allCompanyTeams.put(companyName, companyTeams);
		}

		companyTeams.add(team);
	}

	// Print out all the teams with their respective company names, projects,
	// budgets and teams- there should be no duplicates.
	public void logAllTeams() {
		for (Set<CompanyTeam> compTeams : allCompanyTeams.values()) {
			for (CompanyTeam compTeam : compTeams) {
				System.out.println(compTeam);
			}
		}
	}

	// 2. Print total number of teams working on "offshore drilling" project in
	// "acme" company.
	public int getTeams(String company, String projectName) {
		int totalNumOfCompProjTeams = 0;
		Set<CompanyTeam> companyTeams = allCompanyTeams.get(company);
		for (CompanyTeam compTeam : companyTeams) {
			if (projectName.equals(compTeam.getProject())) {
				totalNumOfCompProjTeams++;
			}
		}
		System.out.println(
				"Total number of teams in " + company + " working on " + projectName + ":" + totalNumOfCompProjTeams);
		return totalNumOfCompProjTeams;
	}

	// 3. Print out the Dev teams budget for project "GERD".
	public double getTeamBudget(String projectCode, String teamName) {
		double totalTeamBudget = 0;
		for (Set<CompanyTeam> compTeams : allCompanyTeams.values()) {
			for (CompanyTeam compTeam : compTeams) {
				if (projectCode.equals(compTeam.getProjectCode()) && teamName.equals(compTeam.getTeam())) {

					String budgetStr = compTeam.getBudget();
					budgetStr = budgetStr.substring(0, budgetStr.length() - 1);
					totalTeamBudget += Double.parseDouble(budgetStr);
				}
			}
		}

		System.out.println(teamName + " teams budget for " + projectCode + " is :" + totalTeamBudget + "$");
		return totalTeamBudget;
	}

	public static CompanyTeamsMgr getInstance() {
		return instance;
	}
}

class CompanyTeam {

	private String company;
	private String project;
	private String projectCode;
	private String budget;
	private String team;

	public CompanyTeam(String company2, String project2, String projectCode2, String budget2, String team2) {
		this.company = company2;
		this.project = project2;
		this.projectCode = projectCode2;
		this.budget = budget2;
		this.team = team2;

	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyTeam other = (CompanyTeam) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		return true;

	}

	@Override
	public String toString() {
		return "[company=" + company + ", project=" + project + ", projectCode=" + projectCode + ", budget=" + budget
				+ ", team=" + team + "]";
	}
}