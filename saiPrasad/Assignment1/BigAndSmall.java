package ass1;

import java.util.Scanner;

public class BigAndSmall {

	public static void main(String[] args) {
		
		int n = 10;
		int i;
		double num[] = new double[n];
		double mean = 0;
		double larg_num = 0;
		double small_num = 0;
		
		for(i=0;i<=num.length;i++)
		{ 
			System.out.println("Enter a number or 0 to quit:");
			Scanner in = new Scanner(System.in);
			num[i] = in.nextDouble();
		if(num[0]==0){
				System.out.println("you have not entered any value");
				break;
			}
		if(num[i]==0){
			System.out.println("you have choose to quit");
			break;
		}
		}
		if(num[1]==0){
			larg_num=num[0];
			 small_num=num[0];
			 mean=num[0];
		}
		else{
			small_num=num[0];
		for(int j1=0;j1<num.length;j1++){
			
			if(num[j1]!=0){
			if(num[j1]>larg_num){
				larg_num= num[j1];
			}
			
			if(num[j1]<small_num){
				small_num=num[j1];
			}
			}
			mean = 0;
			double sum=0;
			int count=0;
			for(int k=0;k<num.length;k++){
				sum+=num[k];
				if(num[k]!=0){
					count++;
				}
			}
			mean = sum/count;
			
		}
		
		}
		System.out.println("Largest"+ larg_num);
		System.out.println("smallest"+small_num);
		System.out.println("Mean"+ mean);
		}
		
		
	}


