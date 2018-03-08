import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataDb {
	public void loaddoc(){
		Employee employee=null;
		String fileNameDefined="C:/Users/prudvi/Desktop/Employees.csv";
		File file=new File(fileNameDefined);
		Scanner sc;
		try{
			sc=new Scanner(new FileReader(file));
			while(sc.hasNext()){
				String str[]=sc.nextLine().split(",");
				employee=new Employee(str[0],str[1],str[2]);
				
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/Test","postgres", "sai123");
					
				Statement statement=con.createStatement();
				statement.execute("CREATE TABLE IF NOT EXISTS "+" employee(email varchar PRIMARY KEY,firstname varchar,lastname varchar )");
				
				statement.executeUpdate("INSERT INTO employee(email,firstname,lastname) "+"VALUES('"+employee.getEmail()+ "','"+employee.getFirstname()+ "','"+employee.getLastname()+"')");
			}
		}catch(FileNotFoundException|SQLException e){
			e.printStackTrace();
		}
	}

}
