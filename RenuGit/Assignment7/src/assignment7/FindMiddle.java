package assignment7;

import assignment7.ReverseLinkedList.Node;

public class FindMiddle {
private static Node head;
	
	public class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}		
	}

	public void display(Node node){
		while(node != null){
			System.out.println(node.data + " ");
			node = node.next;
		}
	}
	
	
	public Node fndMid(){
		Node fastCurrent = head;
		Node slowCurrent = head;
		while(fastCurrent != null  && fastCurrent.next != null){
			slowCurrent = slowCurrent.next;
			fastCurrent = fastCurrent.next.next;
		}
		
		return slowCurrent;		
	}
	
public static void main(String args[]) {
		
		FindMiddle ll = new FindMiddle();
		
		Node first = ll.new Node(95);
		Node second = ll.new Node(1);
		Node third = ll.new Node(4);
		Node fourth = ll.new Node(20);
		
		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth; 
		fourth.next = null;
		
		Node middle = ll.fndMid();
		System.out.println("Middle Node is: "+middle.data);
}
}
