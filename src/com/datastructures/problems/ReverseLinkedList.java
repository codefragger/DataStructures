package com.datastructures.problems;

import com.datastructures.model.Node;
import com.datastructures.model.SinglyLinkedList;

public class ReverseLinkedList {
	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList(new Node(1));
		
		singlyLinkedList.head.next = new Node(2);
		singlyLinkedList.head.next.next = new Node(3);
		singlyLinkedList.head.next.next.next = new Node(4);
		
		SinglyLinkedList reveresed = reverseLinkedList(singlyLinkedList.head);
		reveresed.print();
	}

	private static SinglyLinkedList reverseLinkedList(Node head) {
		Node prev = null;
		Node next = null;
		Node current = head;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		return new SinglyLinkedList(prev);
	}
	
	
}
