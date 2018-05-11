package Assignment3;

public class array {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };

		int[] product = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			product[i] = 1;

			for (int k = 0; k < arr.length; k++) {
				if (i == k) {
					continue;
				}
				product[i] *= arr[k];
			}
		}
		for (int i : product) {

			System.out.println(i);
		}
	}
}
