package assignment4;

import java.util.Scanner;

public class Solution {
	

//	public static boolean canWin(int leap, int[] game) {
	public static boolean canWin(int leap, int[] game, int i) {
		if (i < 0 || game[i] == 1) {
			return false;
		}
		if (i + leap >= game.length || i == game.length - 1) {
			return true;
		}
		game[i] = 1;
		 if(game[i+1] == 0) {
			return canWin(leap, game, i + 1);
		}else if(game[i+leap] == 0) {
			return canWin(leap, game, i + leap);
		}else if(game[i-1] == 0) {
			return canWin(leap, game, i - 1);
		}else if(game[i] ==1){
			return false; 
		}
		 
		 return false;

			
//			if(((i + leap) < game.length - 1) && (game[i + leap] == 0) && game[i] == 0) {
			/*if(game[i] == 0 && game[leap + i] == 0 && (i + leap) > game.length - 1) {
				return true;
				 canWin(leap, game, i + leap);
				 
			}else if( game[i] == 0 && game[i+1] == 0 && (i + 1) < game.length - 1) {
				canWin(leap, game, i + 1);
			}else if(game[i] == 0 && game[i -1] == 0 && (i - 1) < game.length - 1) {
				 canWin(leap, game, i - 1);
			}else if(i + leap >= game.length || i == game.length - 1) {
     		return true;
			 }
			 return false;*/
			
		
			
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter How Many Time You want to play");
		int q = scan.nextInt();
		while (q--  >  0) {
			System.out.print("Enter array Size");
			int n = scan.nextInt();
			System.out.print("Enter Leap Size");
			int leap = scan.nextInt();

			int[] game = new int[n];
			System.out.print("Enter Array Values");
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
			}

			System.out.println((canWin(leap, game, 0)) ? "YES" : "NO");
		}
		scan.close();
	}
}

////==================Different Type of Scanner Methods =======================
//==============================================================================
/*int number = in.nextInt();

float real = in.nextFloat();

long number2 = in.nextLong();

double real2 = in.nextDouble();

String string = in.next();
Scanner sc = new Scanner(System.in);
String name = sc.nextLine();
char gender = sc.next().charAt(0);
int age = sc.nextInt();
long mobileNo = sc.nextLong();
double cgpa = sc.nextDouble();
 while (sc.hasNextInt())    
 for (  ;sc.hasNextInt;  )
 Method                           Returns

boolean hasNextLine()             Returns true if the scanner has another line in its input; false otherwise.

boolean hasNextInt()              Returns true if the next token in the scanner can be interpreted as an int value.

boolean hasNextFloat()            Returns true if the next token in the scanner can be interpreted as a float value.

*/