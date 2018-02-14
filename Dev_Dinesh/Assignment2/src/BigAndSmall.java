import java.util.Scanner;

public class BigAndSmall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//variable declaration
		int count=0;
		
		
		
//Scanner Object
		Scanner in=new Scanner(System.in);
		
//Create an array to store values of inputs
		double values[]=new double[20];
		
		for(int i=0;i<values.length;i++) {
			System.out.print("Enter a number or 0 to quit:");
			values[i]=in.nextDouble();
			if(values[0]==0) {
			System.out.println("You didnot enter any numbers");
			break;
			}
//logic for smallest,largest and mean
			double largest=values[0];
			double smallest=values[0];
			//System.out.print("smallest:"+smallest);
			double sum=0;
			
			for(int j=1; j< values.length; j++)
            {
				if(values[j]!=0) {
					
				if(values[j] < smallest)
                {
                        smallest = values[j];
                        //System.out.print("smallest:"+smallest+"Value"+values[j]);
                }
                else if (values[j] > largest) {
                        largest = values[j];
                        //System.out.print("largest:"+largest);
                        }
				}
				sum+=values[j-1];
            }
			double mean;
			
			if(values[i]==0) {
				count=i;
				mean=sum/count;
				System.out.println("Largest: "+largest);
				System.out.println("Smallest: "+smallest);
				System.out.println("Mean: "+mean);
				break;
				}
		}

		in.close();

	}

}
