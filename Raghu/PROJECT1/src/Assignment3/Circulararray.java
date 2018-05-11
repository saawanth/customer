package Assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class Circulararray {
	public static int absIndex(int indexValue, int index, int length) {
		index += indexValue;
		index %= length;
		return index;
	}

	public static boolean checkArray(int[] list) {
		boolean res = false;
		int index = 0;
		int length = list.length;
		int count = 0;
		ArrayList<Integer> indexCheck = new ArrayList<>();
		while (true) {
			index = Circulararray.absIndex(list[index], index, length);
			Integer intObj = new Integer(index);
			count++;
			if (!indexCheck.contains(intObj)) {
				indexCheck.add(intObj);
			}
			if (index == 0 && indexCheck.size() == length) {
				res = true;
				break;

			} else if (count == 4 * length) {
				break;

			}
		}
		return res;
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the length of the array: ");
		int num = scan.nextInt();
		System.out.println("Enter the elements of the array: ");

		int[] intList = new int[num];
		int i = 0;
		while (num-- != 0) {
			intList[i++] = scan.nextInt();
		}
		for (int k : intList) {
			System.out.print(k + " ");
		}
		scan.close();
		System.out.println("\n" + "Complete PATH: " + Circulararray.checkArray(intList));
	}
}