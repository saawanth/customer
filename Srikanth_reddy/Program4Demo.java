/**
 * 
 */
/**
 * @author srika
 *
 */
package assign3;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;;



public class Program4Demo{
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Employee[] workers = new Employee[11];
		Scanner sc=null;
		
		sc =new Scanner(new File("C:\\Users\\srika\\Desktop\\allemployees.csv"));
		int count=0;
		
		while(sc.hasNextLine()){
			String line=sc.nextLine();
			String[] arr=line.split(",");
			
			if(arr.length==5){
				workers[count]=new ClassifiedStaff(arr[0],arr[1], arr[2], arr[3], arr[4]);
			}
			if(arr.length==6){
				if(arr[4].equals("TRUE")|| arr[4].equals("FALSE")){
					workers[count]=new StudentEmployee(arr[0], arr[1], arr[2],arr[3],arr[4], arr[5]);
				}
				else{
					workers[count]=new Faculty(arr[0], arr[1], arr[2],arr[3],arr[4], arr[5]);
				}
			}
			count++;
		}
			for(int i=0; i<workers.length;i++){
				System.out.println(workers[i].toString());
			}
			
			System.out.println("Pay for two-week pay period");
			System.out.println("==================================");
			
			for(int i=0; i<workers.length;i++){
				if(workers[i].isWorking())
					System.out.println(workers[i].getEmployeeName()+"\t\t\t"+"$"+workers[i].getPay());
					
			}
			
			
		}
			
		
	

		
		
}