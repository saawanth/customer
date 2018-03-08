
public class EmpMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataDb db = new DataDb();
		db.loaddoc();
		DBtoColl dtc = new DBtoColl();
		dtc.toColl();
		

	}

}
