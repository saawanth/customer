package arrays.strings;
/*
 * 1.1   Implement an algorithm determine if a string has all unique characters.what if you can not use additional data structures.
 * 
 * */
//Jenkins Demo 
public class UniqueString {

	public static boolean isUniqueChars(String str) {

		int checker = 0;
		for (int i = 0; i < str.length(); ++i) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
isUniqueChars("p");
	}

}
