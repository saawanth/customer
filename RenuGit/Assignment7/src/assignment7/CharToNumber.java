package assignment7;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

public class CharToNumber {

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
					System.out.print(node.data);
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
				
				CharToNumber ll = new CharToNumber();
				
				Node first = ll.new Node(1);
				Node second = ll.new Node(2);
				Node third = ll.new Node(3);
				Node fourth = ll.new Node(4);
				
				head = first;
				first.next = second;
				second.next = third;
				third.next = fourth; 
				fourth.next = null;
				
				ll.reverse();
				ll.display(head);
		}
		}
