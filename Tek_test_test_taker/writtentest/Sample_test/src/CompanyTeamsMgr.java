import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class CompanyTeamsMgr {

	private Map<String, Set<CompanyTeam>> allCompanyTeams = new LinkedHashMap<>();

	private static CompanyTeamsMgr instance = new CompanyTeamsMgr();

	private CompanyTeamsMgr() {
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
