package assignment7;

import assignment7.FindMiddle.Node;

public class LinkedList {
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
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	
	public int size(){
		int count = 0;
		Node current = head;
		while(current.next != null){
			count++;
		}
		return count;		
	}
	
	public void FirstElement(int data){
		Node n = new Node(data);
			n.next = head;
			head = n;
	}
	
	public void LastElement(int data){
		Node n1 = new Node(data);
		Node current = head;
		while(null != current.next){
			current = current.next;			
		}	
		current.next = n1;
			}
	
	public void atGivenNode(Node previous, int data){
		Node n2 = new Node(data);
			
			n2.next = previous.next;
			previous.next = n2;
}
	public void atGivenPosition(int position, int data){
		Node n3 = new Node(data);
		int count = 0;
		Node current = head;
		while(current.next != null){
			current = current.next;
			count++;
			if(count == position){
				n3.next = current.next;
				current.next = n3;
			}
		}
			}
	public void deleteAtFirst(){
		Node current = head;
		current.next = head;
		head = null;
	}
	
	public static void main(String args[]) {
		
		LinkedList ll = new LinkedList();
		
		Node first = ll.new Node(95);
		Node second = ll.new Node(1);
		Node third = ll.new Node(4);
		Node fourth = ll.new Node(20);
		
		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth; 
		fourth.next = null;
		
		ll.display(head);
		ll.FirstElement(143);
		System.out.println("After adding an element in the front");
		ll.display(head);
		ll.LastElement(15);
		System.out.println("After adding an element in the end");		
		ll.display(head);
		ll.atGivenNode(third, 420);
		System.out.println("After adding an element at a given node");
		ll.display(head);
		ll.atGivenPosition(3, 220);
		System.out.println("After adding an element at a given position");
		ll.display(head);
		ll.deleteAtFirst();
		System.out.println("After deleting the first element");
		ll.display(head);
	}
	
	}
