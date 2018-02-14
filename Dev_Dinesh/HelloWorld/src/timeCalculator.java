import java.util.Scanner;

public class timeCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Variable Declaration
		int starthour;
		int startmin;
		int TimeAdded;
		int EquivTotalMin,TotalMin;
		int EndHour,EndMin;
		int i;
//creating scanner object to read from keyboard
		Scanner scanner = new Scanner(System.in);
		Scanner in=scanner.useDelimiter("[,\\s+]");
		System.out.print("Enter the starting time (in hours and minutes): ");
		starthour=in.nextInt();
		startmin=in.nextInt();
		System.out.print("Enter the duration (in minutes) :");
		TimeAdded=in.nextInt();
		in.close();
		scanner.close();
		if(starthour>23) {
			System.out.println("Please Enter starting Time between 00hrs and 24hrs");
		}
		
//Get the duration time in min
		EquivTotalMin = (starthour*60)+startmin;
		TotalMin=EquivTotalMin+TimeAdded;
		
// Calculate the ending time 
		i=TotalMin-(TotalMin%60);
		EndMin=TotalMin-i;
		EndHour=i/60;
		if(EndHour==24) {
			EndHour= 00;
		}
		
//Display outputs
		System.out.println("Ending hour is: "+EndHour);
		System.out.print("Ending Min is: "+EndMin);
	}
		
}
