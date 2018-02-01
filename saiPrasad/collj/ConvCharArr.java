package collj;

public class ConvCharArr {

	public static void main(String[] args) {
		int a[]={3,2,1};
		int str=0;
		int factor=1;
		for(int i =a.length-1;i>=0;i--){
			str= str +(a[i])*factor;
			factor= factor*10;
		}
		System.out.println("Single number from array:"+str);
	}

}
