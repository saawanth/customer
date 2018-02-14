package com.part5.com;

public class CharToNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chars = {3,2,1};
		int sum = 0;
		int i = chars.length - 1;
		double j = 0;
		while(i >= 0){
			sum += chars[i]*Math.pow(10, j);
			i--;
			j++;
			
		}
		System.out.println(sum);
	}

}
