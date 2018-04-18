package assignment3;


import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;


import assignment3.ClassifiedStaff;
import assignment3.Employee;
import assignment3.Faculty;
import assignment3.StudentEmployee;




public class Program4Demo {



	public static void main(String[] args)  throws IOException {
		
		/*Employee[] workers = new Employee[11];
		String[] all = null;
		String inputfile = "C:/Users/4Serv/git/exercises/src/assignment3/allemployees.csv";
		File file = new File(inputfile);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String Row;
		int i = 0;
		Row = br.readLine();
		for( i=0 ; i <= Row.length(); i++) {
			all = Row.split(",");
			System.out.println(workers[Row]);
		}*/
//=====================================================================================		
     	String row = null;
     	String[] column = null;
     	int i = 0;
//     	int numOfEmployee = 0;
    /* 	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     	System.out.print("Enter Num Of Students");
     	int numOfStd = Integer.parseInt(reader.readLine());
     	System.out.print("Enter Num Of Students");
     	int numOfFac = Integer.parseInt(reader.readLine());
     	System.out.print("Enter Num Of Classified Staff");
     	int numOfClsStaf = Integer.parseInt(reader.readLine());
     	
     	numOfEmployee = numOfStd + numOfFac + numOfClsStaf;*/
 //   	Employee[] employee = new Employee[numOfEmployee];	
     	
     	Employee[] employee = new Employee[11];
     	
	      try {
	      
	
//	         BufferedReader br = new BufferedReader("C:/Users/4Serv/git/exercises/src/assignment3/allemployees.csv");
	    	  String inputfile = "C:/Users/4Serv/git/exercises/src/assignment3/allemployees.csv";
		  		File file = new File(inputfile);
		  		BufferedReader br = new BufferedReader(new FileReader(file));
	         
	       for(;(row = br.readLine()) != null;){   //while((row = br.readLine()) != null)
//         for(i=0;(row = br.readLine()) != null;i++)
//	            System.out.println(row);    //printing as rows
	        	column = row.split(",");
//	        	System.out.println(Arrays.toString(column));  //printing as an array
//	        	System.out.println(Arrays.toString(column[0]));
	        	if (column.length == 5) {
					employee[i]  = new ClassifiedStaff(column[0], column[1], column[2], column[3], column[4]);
					System.out.println(employee[i].toString());
				} else if (column.length == 6 && (column[4].equals("TRUE") || column[4].equals("FALSE"))) {
					employee[i] = new StudentEmployee(column[0], column[1], column[2], column[3], column[4], column[5]);
					System.out.println(employee[i].toString());
				} else if(column.length == 6 && (column[5].equals("Computer Science") || column[5].equals("Math") || column[5].equals("English"))){
					employee[i] = new Faculty(column[0], column[1], column[2], column[3], column[4], column[5]);
					System.out.println(employee[i].toString());
				}else {
					System.out.println("No Data");
				}
	        	
//	        	i++;
	         } 
	       br.close();
//	       for (int j = 0; j < employee.length; j++) {
//				System.out.println(employee[j]);
//			}	      
	       } catch(Exception e) {
	    	   System.out.println("File Not Found");
	       }
	      
	      System.out.println("Pay For two Week Period");
	      System.out.println("========================");
	      try {
//	      for (int j = 0; j <= employee.length;j++ )
	    	  int j =0;
	    	  while(employee.length <=11){
	    	  if(employee[j].isWorking()) {
	    		  System.out.println(employee[j].getEmployeeName() + "\t\t$" +employee[j].getPay());
	    	  }
	    	  j++;
	    	  
	      }
	      }catch (Exception e) {
	    	  System.out.println("Array In Bound Exception");
	      }
	    
	    /* for (int j = 0; j < column.length; j++) {
				System.out.println(column[j]);
			}*/
//====================================================================================================		
	/*	Employee e = new ClassifiedStaff("Brandon Allison","221556222","true","3125.95","Student Affairs");
	       System.out.println(e.toString());
	  */
//========================================================================================
		
	      
	      
	      
	      
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

//===================================================================================================		
/*		String fileNameDefined = "C:/Users/4Serv/git/exercises/src/assignment3/allemployees.csv";
//		Scanner inputStream = new Scanner(fileNameDefined);
		File file = new File(fileNameDefined);
		try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()) {
				String data = inputStream.next();
				String[] values = data.split(",");
				System.out.println(values);
			}
			inputStream.close();
		}catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}*/
//		StudentEmployee st = new StudentEmployee("KaufStan Stanley",123456789,"TRUE",19,"FALSE",10.95);

//==================================================================================================		

    }
}

