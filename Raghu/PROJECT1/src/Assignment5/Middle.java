package Assignment5;

public class Middle {

	private static Node head;

	class Node {
		private Node next;
		private int data;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Node getMiddleNode() {
		if (head == null) {
			return null;
		}
		Node slowPtr = head;
		Node fastPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;

	}

	public void display(Node node) {
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}

	}

	public static void main(String[] args) {

		Middle llist = new Middle();
		Node first = llist.new Node(10);
		Node second = llist.new Node(5);
		Node third = llist.new Node(6);
		Node fourth = llist.new Node(9);
		Node fifth = llist.new Node(12);

		head = first;
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;

		llist.display(head);
	Node middleNode = llist.getMiddleNode();
	System.out.println("middle node is-" + middleNode.data);
	}

}
