package com.game.com;

import java.util.Scanner;

public class ArrayGame {
	static int length;

	public static boolean canWin(int leap, int[] game) {
		int i = 0;
		while (i < length) {
			if (game[i + 1] == 0) {
				i = i + 1;
			} else if (game[i + 1] == 1) {
				if ((i + leap) > length) {
					i = i + leap;
				} else if ((i + leap) < length && game[i + leap] == 0) {
					i = i + leap;
				} else if (i != 0 && game[i - 1] == 0) {
					if (game[(i - 1) + leap] == 0) {
						i = (i - 1) + leap;
					}
					else{
						return false;
					}
				}
				else if(i == 0 || game[i-1] != 0 && (i + leap) > length){
					return false;
				}
			}
		}
		return i >= length;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of the array ");
		length = sc.nextInt();
		System.out.println("Enter the leap you'd like ");
		int leap = sc.nextInt();
		int game[] = new int[10];
		System.out.println("Please enter the elements in the array (Only 0s and 1s)");
		for (int i = 0; i < length; i++) {
			game[i] = sc.nextInt();
		}
		System.out.println(canWin(leap, game) ? "YES" : "NO");
		sc.close();
	}
	}
