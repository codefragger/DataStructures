/**
 * 
 */
package com.datastructures.problems;

import com.datastructures.model.Node;
import com.datastructures.model.SinglyLinkedList;

public class DeleteNNodesAfterMNodes {

	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList(new Node(1));
		Node cur = singlyLinkedList.head;
		for(int i = 2 ; i < 15 ; i++) {
			cur.next = new Node(i);
			cur = cur.next;
		}

		deleteNodes(singlyLinkedList,3,2);
	}

	private static void deleteNodes(SinglyLinkedList singlyLinkedList, int m, int n) {
		Node cur = singlyLinkedList.head;
		int i = 1;
		while(cur != null) {
			for(; i < m  ; i++){
				if(cur == null) {
					singlyLinkedList.print();
					return;
				}
				cur = cur.next;
			}
			Node temp = cur;
			for(i = 0 ; i < n  ; i++){
				if(cur == null) {
					singlyLinkedList.print();
					return;
				}
				cur = cur.next;
			}
			if(cur == null) {
				temp.next = null;
				singlyLinkedList.print();
				return;
			}
			temp.next = cur.next;
			i = 0;
		}
		singlyLinkedList.print();
	}
}
