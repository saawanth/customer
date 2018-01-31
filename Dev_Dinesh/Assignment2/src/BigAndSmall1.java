import java.util.Scanner;

public class BigAndSmall1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double temp,mean=0;
		double smallest=0,largest=0;

int i=0;

Scanner in=new Scanner(System.in);



do {
	System.out.print("Enter a number or 0 to quit:");
	temp=in.nextDouble();
if(temp==0 && i==0) {
	System.out.print("You didnot enter any numbers");
	break;
}
if(temp>largest) {
	largest=temp;
}
if(temp!=0) {
	if(smallest>temp && smallest==0) {
		smallest=temp;
	}
}
mean+=temp;
i++;
if(temp==0) {
	System.out.println("Largest: "+largest);
	System.out.println("Smallest: "+smallest);
	System.out.println("Mean: "+mean/(i-1));
	break;
	}
} while(i!=0);
in.close();

	}
}

