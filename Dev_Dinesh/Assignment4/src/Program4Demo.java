
import java.io.*;
public class Program4Demo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//Employee Array
		Employee[] workers=new Employee[11];
		
		String[] str=null;
		
		String filename="/Users/ReshmaVegi1/allemployees.csv";
		File file=new File(filename);
		
		int i=0;
		String line;
//Reading csv file
		BufferedReader br =new BufferedReader(new FileReader(file));
	
//Read every line of csv file  
		while((line=br.readLine())!= null) {
			str=line.split(",");
			if(str.length==5){
				workers[i]=new ClassifiedStaff(str[0],str[1],str[2],str[3],str[4]);
			}
			else if(str.length==6 && (str[4].equals("TRUE")||str[4].equals("FALSE"))) {
				workers[i]=new StudentEmployee(str[0],str[1],str[2],str[3],str[4],str[5]);
			}
			else {
				workers[i]=new Faculty(str[0],str[1],str[2],str[3],str[4],str[5]);
			}
		
			i++;
		}
		br.close();
		for (int j = 0; j < workers.length; j++) {
			System.out.println(workers[j]);
		}

		System.out.println("Pay for two week period");
		System.out.println("=================================");
		
//Print pay for two week period
		for (int j = 0; j < workers.length; j++) {
			if(workers[j].isWorking) {
			System.out.println(workers[j].employeename+"\t\t$"+workers[j].getPay());
			}
		}
	}



}
