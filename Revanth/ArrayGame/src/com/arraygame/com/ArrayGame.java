package com.arraygame.com;

import java.util.Scanner;

public class ArrayGame {
	public static boolean canWin(int leap, int[] game) {
		// Implement here.
		int pIndex = 0;
		while (pIndex < game.length - 1) {
			if (game[pIndex + 1] == 0) {
				pIndex++;
			} else {
				if (((pIndex + leap) < game.length - 1) && (game[pIndex + leap] == 0)) {
					pIndex = pIndex + leap;
				} else if (((pIndex + leap) < game.length - 1) && game[pIndex + leap] == 1) {
					if ((pIndex - 1) >= 0 && game[pIndex - 1] == 0 && (game[(pIndex - 1) + leap] == 0)) {
						pIndex = (pIndex - 1) + leap;
					} else {
						return false;
					}
				} else if ((pIndex + leap) > game.length - 1) {
					System.out.println(pIndex);
					return true;
				}
			}
		}
		System.out.println(pIndex);
		return (pIndex >= game.length - 1);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// System.out.println("q:");
		int q = scan.nextInt();
		while (q-- > 0) {
			// System.out.println("n:");
			int n = scan.nextInt();
			// System.out.println("leap:");
			int leap = scan.nextInt();

			int[] game = new int[n + 1];

			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
			}
			System.out.println((canWin(leap, game)) ? "YES" : "NO");
		}
		scan.close();
	}
}
