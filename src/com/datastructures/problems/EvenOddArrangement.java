package com.datastructures.problems;

import com.datastructures.model.Node;
import com.datastructures.model.SinglyLinkedList;

public class EvenOddArrangement {

	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList(new Node(1));
		Node cur = singlyLinkedList.head;
		for(int i = 2 ; i < 15 ; i++) {
			cur.next = new Node(i);
			cur = cur.next;
		}
		
		singlyLinkedList = rearrangeOddEven(singlyLinkedList);
	}

	private static SinglyLinkedList rearrangeOddEven(SinglyLinkedList sll) {
		Node odd = sll.head;
		Node even = sll.head.next;
		
		Node evenFirst = even;
		
		while(true) {
			
			if(odd == null || even == null || even.next == null ) {
				odd.next = evenFirst;
				break;
			}
			
			//connect odd nodes
			odd.next = even.next;
			odd = even.next;
			
			if(odd.next == null) {
				even.next = null;
				odd.next = evenFirst;
			}
			
			//connect even nodes
			even.next = odd.next;
			even = odd.next;
		}
		
		sll.print();
		return sll;
		
			
	}

}
