package assignment7;

import assignment7.LinkedList.Node;

public class ReverseLinkedList {
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
	
	public void reverse(){
		Node before = null;
		Node tmp = head;
		while (tmp != null) {
		    Node next = tmp.next;
		    tmp.next = before;
		    before = tmp;
		    tmp = next;
		}
		head = before;
	}
	
public static void main(String args[]) {
		
		ReverseLinkedList ll = new ReverseLinkedList();
		
		Node first = ll.new Node(95);
		Node second = ll.new Node(1);
		Node third = ll.new Node(4);
		Node fourth = ll.new Node(20);
		
		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth; 
		fourth.next = null;
		
		ll.reverse();
		ll.display(head);
}
}
