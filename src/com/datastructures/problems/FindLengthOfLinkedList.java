package com.datastructures.problems;

import com.datastructures.model.Node;
import com.datastructures.model.SinglyLinkedList;

public class FindLengthOfLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.head = new Node(0);
		sll.addNode(1);
		sll.addNode(2);
		sll.addNode(3);
		sll.addNode(4);
		sll.addNode(5);
		sll.addNode(6);
		
		System.out.println("Length by iterative method : " + findLength(sll));
		System.out.println("Length by recursive method : " + findLengthRecursively(sll));
		findLengthRecursively(sll);

	}

	/**
	 * Recursive method
	 * @param sll
	 * @return
	 */
	private static int findLengthRecursively(SinglyLinkedList sll) {
		Node node = sll.head;
		
		return getLength(node);
		
	}

	private static int getLength(Node node) {
		if(node == null) {
			return 0;
		}
		
		return 1 + getLength(node.next);
	}

	/**
	 * Iterative method
	 * @param sll
	 * @return
	 */
	private static int findLength(SinglyLinkedList sll) {
		int count = 0 ; 
		Node temp = sll.head;
		while(temp != null){
			temp = temp.next;
			count++;
		}
		return count;
	}

}
