package com.datastructures.problems;

import com.datastructures.model.Node;
import com.datastructures.model.SinglyLinkedList;

public class DetectAndRemoveLoop {
	
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.head = new Node(0);
		sll.addNode(1);
		sll.addNode(2);
		sll.addNode(3);
		sll.addNode(4);
		sll.addNode(5);
		sll.addNode(6);
		
		Node temp = sll.head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = sll.head.next.next.next;
		//sll.print();
		sll = findAndRemoveLoop(sll);
		sll.print();
	}

	private static SinglyLinkedList findAndRemoveLoop(SinglyLinkedList sll) {
		Node slow = sll.head;
		Node fast = sll.head;
		
		while(slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				sll = removeLoop(slow, sll);
			}
		}
		return sll;
	}

	private static SinglyLinkedList removeLoop(Node loopNode, SinglyLinkedList sll) {
		Node cur = sll.head;
		Node temp;
		while(true) {
			
			temp = loopNode;
			while(temp.next != loopNode && temp.next != cur) {
				temp = temp.next;
			}
			
			if(temp.next == cur) {
				temp.next = null;
				break;
			}
			
			cur = cur.next;
			
		}
		return sll;
	}
}
