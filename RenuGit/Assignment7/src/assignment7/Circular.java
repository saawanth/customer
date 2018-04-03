package assignment7;

import assignment7.FindMiddle.Node;

public class Circular {
	private static Node head;

	public class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void display(Node node) {
		while (node != null) {
			System.out.println(node.data + " ");
			node = node.next;
		}
	}

	public boolean circular() {
		Node fastCurrent = head;
		Node slowCurrent = head;
		while (fastCurrent != null && fastCurrent.next != null) {
			slowCurrent = slowCurrent.next;
			fastCurrent = fastCurrent.next.next;
			if (fastCurrent == slowCurrent) {
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {

		Circular ll = new Circular();

		Node first = ll.new Node(95);
		Node second = ll.new Node(1);
		Node third = ll.new Node(4);
		Node fourth = ll.new Node(20);
		Node fifth = ll.new Node(21);
		Node sixth = ll.new Node(22);

		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = fourth;
		
		System.out.println("Is it Circular? " + ll.circular());
	}
}
