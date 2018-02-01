package arrayAss;

public class ArrProd {

	public static void main(String[] args) {
		int[] nums={1,2,3,4,5};
		int[]  products=new int[5];
		for(int i=0;i<nums.length;i++){
			int temp=1;
			for(int j=0;j<products.length;j++){
				if(j!=i)
					temp=temp*nums[j];
			}
			products[i]=temp;
			System.out.println(products[i]+"");
		}
		

	}

}
