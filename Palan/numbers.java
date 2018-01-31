package assign;

import java.util.Scanner;

public class numbers {

	public static void main(String[] args) {

int[] arg= {1,2,3,4,5};
Scanner sc= new Scanner(System.in);
System.out.println("enter the array of five numbers:");
int[] nums = new int[5];
nums[0]= sc.nextInt();
nums[1]= sc.nextInt();
nums[2]= sc.nextInt();
nums[3]= sc.nextInt();
nums[4]= sc.nextInt();
sc.close();
 
int count = 0;
int product[] = new int[5];

System.out.println("[");
for (int i= 0; i< nums.length;i++){
	int prod = 1;
	System.out.println("(");
	for(int j=0; j< nums.length; j++){
		if(j!= count){
			if(j+1 == nums.length){
				System.out.println(nums[j]);
				prod=prod*nums[j];
			}else{
				System.out.println(nums[j] + "*");
				prod=prod*nums[j];
				
			}
		}
		}
	products[i]= prod;
	count++;
	if(count < 5){
		System.out.println("), ");
	}else{
		System.out.println(")");
	}
}
System.out.println("] = [");
for (int pr : products) {
System.out.println(pr + " ");
}
System.out.println("]");
	}
}  
	  
  }
	}
