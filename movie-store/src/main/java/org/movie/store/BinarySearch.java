package org.movie.store;

public class BinarySearch {

	public int binarySearch(int[] inputArr, int key) {
		int start = 0;
		int end = inputArr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == inputArr[mid]) {
				System.out.println(inputArr[mid]);
				return mid;
			}
			
			System.out.println(inputArr[mid]);
			if (key < inputArr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int[] arr = { 3, 8, 22, 29, 43, 55, 61, 74, 78, 95, 96 };
		System.out.println("Key position: " + bs.binarySearch(arr, 29));
		System.out.println("Key position: " + bs.binarySearch(arr, 21));

	}
}
