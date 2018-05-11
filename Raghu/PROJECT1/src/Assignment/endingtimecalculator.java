package Assignment;

import java.util.Scanner;

public class endingtimecalculator {
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		Scanner dr=sc.useDelimiter("[\\s]");
		int startingtime;
		int startingtime1;
		int durationtime;
		int totaltime;
		int quotient;
		int remainder;
		int endinghour;
		int endingminute;
		System.out.println("enters the starting time in hours and minutes");
		startingtime=dr.nextInt();
		startingtime1=dr.nextInt();
		System.out.println("enters the duratian time in minutes");
		durationtime=sc.nextInt();
		sc.close();
		totaltime=startingtime1+durationtime;
		quotient=totaltime/60;
		remainder=totaltime%60;
		endinghour=quotient+startingtime;
		
		
		if(endinghour>12){
			endinghour=endinghour%12;
		}else if(endinghour>24){
			endinghour=endinghour%24;
		}
		
		System.out.println("endinghour:"+endinghour);
		endingminute=remainder;
		System.out.println("endingminute:"+endingminute);
		
		
		
	}

}
