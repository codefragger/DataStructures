package com.datastructures.problems;

import com.datastructures.model.Node;
import com.datastructures.model.SinglyLinkedList;

public class AdditionOfOne {
	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList(new Node(9));
		
		singlyLinkedList.head.next = new Node(9);
		singlyLinkedList.head.next.next = new Node(9);
		singlyLinkedList.head.next.next.next = new Node(9);
		
		//SinglyLinkedList res = addOneRecursively(singlyLinkedList.head);
		SinglyLinkedList res1 = addOne(singlyLinkedList);
		res1.print();
	}


	private static SinglyLinkedList addOne(SinglyLinkedList sll) {
		//reverse a linkedList
		sll.reverseLinkedList();
		
		int carry = 1;
		int sum = 0;
		Node cur = sll.head;
		while(cur != null) {
			sum = carry + cur.data;
			carry = sum / 10;
			cur.data = sum % 10;
			cur = cur.next;
		}
		if(carry == 1) {
			sll.addNode(1);
		}
		//reverse
		sll.reverseLinkedList();
		return sll;
	}

	private static SinglyLinkedList addOneRecursively(SinglyLinkedList sll) {
		if(sll == null) {
			 new Node(1);
		}
		return null;
	}
}
