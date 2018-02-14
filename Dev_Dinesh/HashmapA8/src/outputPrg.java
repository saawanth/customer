import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class outputPrg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Studentinfo std = new Studentinfo();
		File file = new File("/Users/ReshmaVegi1/Database.csv");
		std.loadInventory(file);
		System.out.println("List of all students in ascending order of Date of Birth: ");
		std.ascendingOrderList();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Date of Birth: ");
		String DateofBirth = sc.next();
		System.out.println("All students born on the given date");
		std.sameDOB(DateofBirth);
		System.out.println("Provide an operation for the Date of Birth");
		System.out.println("1.Addition    2.Removal  3.Update");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("Enter Name");
			String Name = sc.next();
			System.out.println("Enter Email:");
			String Email = sc.next();
			List<String> addOperation = new ArrayList<>();
			addOperation.addAll(Arrays.asList(Name,DateofBirth,Email));
			System.out.println("List of Students after addition");
			std.addOp(addOperation);
			break;
		case 2:
			System.out.println("Enter Name");
			String Name2 = sc.next();
			List<String> removalOperation = new ArrayList<>();
			removalOperation.addAll(Arrays.asList(Name2,DateofBirth));
			std.removeOp(removalOperation);
			break;
		case 3:
			System.out.println("Change: 1.Name 2.Email");
			int n1=sc.nextInt();
			if(n1==1) {
				System.out.println("Enter email address of the student");
				String Email3 = sc.next();
				List<String> updateName = new ArrayList<>();
				System.out.println("Enter name you want to update ");
				String updatedName=sc.next();
				updateName.addAll(Arrays.asList(updatedName,DateofBirth,Email3));
				std.updateName(updateName);
			} else if(n1==2) {
				System.out.println("Enter Name of the student");
				String Name3 = sc.next();
				List<String> updateEmail = new ArrayList<>();
				System.out.println("Enter Email you want to update ");
				String updatedEmail=sc.next();
				updateEmail.addAll(Arrays.asList(Name3,DateofBirth,updatedEmail));
				std.updateEmail(updateEmail);
			}
			System.out.println("Updated List of students");
			break;
		default:
			System.out.println("Enter a valid Operation");
			break;
		}
		System.out.println("Give a Date of Birth:");
		String DOB2=sc.next();
		
		System.out.println("All students who are born before given date");
		std.before(DOB2);
		System.out.println("All students who are born after given date");
		std.after(DOB2);
		sc.close();

	}

}
