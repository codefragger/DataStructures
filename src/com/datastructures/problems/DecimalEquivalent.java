package com.datastructures.problems;

import com.datastructures.model.Node;
import com.datastructures.model.SinglyLinkedList;

/**
 * @author codeFragger
 *
 * Finding the decimal equivalent of binary linked list
 */
public class DecimalEquivalent {
	public static void main(String[] args) {
SinglyLinkedList singlyLinkedList = new SinglyLinkedList(new Node(1));
		
		singlyLinkedList.head.next = new Node(1);
		singlyLinkedList.head.next.next = new Node(1);
		singlyLinkedList.head.next.next.next = new Node(1);
		
		int res = 0;
		Node temp = singlyLinkedList.head;
		while(temp != null) {
			res = res * 2 + temp.data;
			temp = temp.next;
		}
		System.out.println(res);
	}
}
