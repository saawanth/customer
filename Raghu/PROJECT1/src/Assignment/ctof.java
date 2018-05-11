package Assignment;

import java.util.Scanner;

public class ctof {
public static void main(String args[])
{
	//converting celsious to fahrenheit:
	double celsious=36;
	double fahrenheit;
	
	fahrenheit=(1.8)*celsious+32;
	System.out.println("converting celsious to fahrenheit:  "+fahrenheit);
	
	
	
	//converting fahrenheit celsious to
	 double celsious1;
	double fahrenheit1=70;
	
	celsious1=(fahrenheit1-32)*5/9;
	System.out.println("converting fahrenheit celsious to :  "+celsious1);
	
	
	Scanner sc=new Scanner(System.in);
	
	int celsious2;
	double fahrenheit2;
	System.out.println("enter the celsious value:   ");
	
	celsious2=sc.nextInt();
	fahrenheit2=(1.8)*celsious2+32;
	System.out.println("converting   celsious tofahrenheit:  "+fahrenheit2);
	
	int celsious3;
	double fahrenheit3;
	System.out.println("enter the fahrenheit value:   ");
	
	fahrenheit3=sc.nextDouble();
	celsious3=(int)(fahrenheit3-32)*5/9;
	System.out.println("converting   fahrenheit celsious to:  "+celsious3);
	sc.close();
}
}
	
	
	
	
	