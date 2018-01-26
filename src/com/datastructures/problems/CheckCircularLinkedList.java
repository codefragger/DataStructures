package com.datastructures.problems;

import com.datastructures.model.Node;
import com.datastructures.model.SinglyLinkedList;

public class CheckCircularLinkedList {
	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList(new Node(1));

		singlyLinkedList.head.next = new Node(2);
		singlyLinkedList.head.next.next = new Node(3);
		singlyLinkedList.head.next.next.next = new Node(4);
		singlyLinkedList.head.next.next.next.next = singlyLinkedList.head;
		
		if(isLinkedListCircular(singlyLinkedList)) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}

	private static boolean isLinkedListCircular(SinglyLinkedList sll) {
		Node head = sll.head;
		Node curr = head.next;
		
		while(curr != null && curr.data != head.data) {
			curr = curr.next;
		}
		if(curr == null) {
			return false;
		}
		return curr.data == head.data;
	}
}
