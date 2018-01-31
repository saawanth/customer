package assign;

import java.util.Scanner;

public class LibraryFunctionCalculator {
	public void f1(int a[][]){
		int fine = 0;
		if(a[0][0]==a[1][0] && a[0][1]==a[1][1] && a[0][2]==a[1][2] || a[0][2]<a[1][2] || (a[0][2]==a[1][2] && a[0][1]< a[1][1])) {
			System.out.println("No fine");
			}
		else if(a[0][0]>a[1][0]&& a[0][1]==a[1][1] && a[0][2]==a[1][2]){
			fine=(15*(a[0][0]-a[1][0]));
			System.out.println(fine);
		}
		else if(a[0][1]> a[1][1] && a[0][2] == a[1][2]){
			fine =(500*(a[0][1] - a[1][1]));
			System.out.println(fine);
			}
		else if (a[0][2] > a[1][2]){
			fine = 10000;
			System.out.println(fine);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LibraryFunctionCalculator f= new LibraryFunctionCalculator();
      Scanner sc=new Scanner(System.in);
      int a[][]= new int[2][3];
      System.out.println(" Enter the actual date in DD MM YYYY ");
      for(int i=0;i<3;i++){
    	  a[0][i]=sc.nextInt();
    }
      System.out.println(" Enter the expected data in MM DD YYYY");
      
      for(int i=0;i<3;i++){
    	  a[1][i]=sc.nextInt();
      }
      f.f1(a);
      }
    }
