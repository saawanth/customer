package collj;

import java.util.*;




class Node{
	
	
	
	Node(int data){
		data=0;
		nextNode=null;
	}
}
public class MidLL {
static //	1-->2-->4-->5-->6	
		Node rootNode;
	  void printMiddle()
	    {
	        Node slow_ptr = rootNode; 
	        Node fast_ptr = rootNode;
	        if (rootNode != null)
	        {
	            while (slow_ptr != null && fast_ptr!= null)
	            {
	                fast_ptr = fast_ptr.nextNode.nextNode;
	                slow_ptr = slow_ptr.nextNode;
	            }
	            System.out.println("The middle element is [" +
	                                slow_ptr.data + "] \n");
	        }
	    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		 int a;
				
		do{
		System.out.println("Enter the values to be stored .Enter 0 to end");
			a = sc.nextInt();
		
				int data = a;
				Node node=new Node(data);
				node.data = a;
				if(rootNode == null){
					rootNode = node;
				} else {
					node.nextNode= rootNode;
					rootNode = node;
					
				}
			}
			while(a != 0);
		sc.close();
		MidLL midl=new MidLL();
		midl.printMiddle();
		
		  
	}
}
	

