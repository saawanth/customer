import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBtoColl {
	public void toColl(){
		ArrayList<Employee> arraylist=new ArrayList<>();
		try{
			Connection con= DriverManager.getConnection("jdbc:postgresql://localhost/Test","postgres", "sai123");
			Statement statement=con.createStatement();
			
			statement.execute("SELECT * FROM employee");
			ResultSet rs=statement.getResultSet();
			
			while(rs.next()){
				arraylist.add(new Employee(rs.getString(1),rs.getString(2),rs.getString(3)));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		for(Employee e: arraylist){
			System.out.println(e.email+ " "+ e.firstname+" "+e.lastname);
		}
	}

}
