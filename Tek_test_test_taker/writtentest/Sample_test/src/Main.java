import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

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