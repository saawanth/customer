package com.part4.com;

import java.util.HashMap;

public class LinkedList {

	private static Node head;

	public static class Node {

		private int data;
		private Node next;

		public Node(int d) {
			data = d;
			next = null;
		}
	}

	// Reverse logic
	public Node reverse(Node node) {
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	// double linked list data

	public void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;

		}

	}

	public Node firstNode(Node node) {
		node.next = head;
		head = node;

		return head;
	}

	public void LastNode(Node head, int data) {
		Node last = new Node(data);
		while (head != null) {
			if ((head.next) == null) {
				// System.out.println("head.next.data: "+head.next.data);
				head.next = last;
				last.next = null;
			}
			head = head.next;
		}

	}

	public void insertAfterPosition(Node head, int position, int data) {
		int count = 0;
		Node previous;
		Node pos = new Node(data);
		while (count <= (position - 1)) {
			count++;
			if (count == (position - 1)) {
				pos.next = head.next;
				head.next = pos;
			}
			head = head.next;
		}
	}

	public Node deleteFirst(Node head) {
		Node temp = head;
		head = head.next;
		temp.next = null;
		return head;
	}
	
	public boolean circular(){
		Node slowPtr = head;
		Node fastPtr = head;
		while(fastPtr != null && fastPtr.next != null){
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(fastPtr == slowPtr){
				return true;
			}
		
		}
		return false;
	}

	public int middleNode() {
		int count = 0;
		HashMap<Integer, Integer> nodeMap = new HashMap<>();
		while (head != null) {
			count++;
			nodeMap.put(count, head.data);
			head = head.next;
		}

		return nodeMap.get((count / 2) + 1);
	}

	static public void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(95);
		list.head.next = new Node(1);
		list.head.next.next = new Node(4);
		list.head.next.next.next = new Node(20);

		System.out.println("Given Linked list");
		list.printList(head);
		head = list.reverse(head);
		System.out.println("");
		System.out.println("\nReversed linked list ");
		list.printList(head);
		Node node1 = new Node(143);
		head = list.firstNode(node1);
		System.out.println("\n\nAfter adding element at firstNode: ");
		list.printList(head);
		System.out.println("");
		list.LastNode(head, 200);
		System.out.println("\nAfter adding last element:");
		list.printList(head);
		System.out.println("\nAfter inserting elemnt at desired position");
		list.insertAfterPosition(head, 3, 100);
		list.printList(head);
		
		System.out.println("\nDelete the first Node: ");
		head = list.deleteFirst(head);
		list.printList(head);
		System.out.println("\n\nMiddle element is: " + list.middleNode());
		System.out.println("\n\nCircular(True or False): " + list.circular());
	}

}
