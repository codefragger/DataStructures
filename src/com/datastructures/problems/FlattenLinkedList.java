/**
 * 
 */
package com.datastructures.problems;

/**
 * @author Sourabh
 *
 */
public class FlattenLinkedList {
	
	class LinkedList{
		Node head;
		
		public Node push(Node headRef, int data) {
			Node newNode = new Node(data);
			
			newNode.down = headRef;
			
			headRef = newNode;
			return headRef;  

		}

		public Node flatten(Node root) {
			if(root == null || root.right == null) {
				return root;
			}
			
			root.right = flatten(root.right);
			
			root = merge(root, root.right);
			return root;
			
		}

		private Node merge(Node node1, Node node2) {
			if(node1 == null) {
				return node2;
			}
			if(node2 == null) {
				return node1;
			}
			
			Node result;
			if(node1.data < node2.data) {
				result = node1;
				result.down = merge(node1.down, node2);
			}
			else {
				result = node2;
				result.down = merge(node1, node2.down);
			}
			return result;
		}
		
		void printList()
	    {
	        Node temp = head;
	        while (temp != null)
	        {
	            System.out.print(temp.data + " ");
	            temp = temp.down;
	        }
	        System.out.println();
	    }
	}
	
	class Node{
		
		int data;
		Node right;
		Node down;
		
		public Node(int data) {
			this.data = data;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FlattenLinkedList fll = new FlattenLinkedList();
		
		LinkedList linkedList = fll.new LinkedList();
		linkedList.head = linkedList.push(linkedList.head, 30);
        linkedList.head = linkedList.push(linkedList.head, 8);
        linkedList.head = linkedList.push(linkedList.head, 7);
        linkedList.head = linkedList.push(linkedList.head, 5);
 
        linkedList.head.right = linkedList.push(linkedList.head.right, 20);
        linkedList.head.right = linkedList.push(linkedList.head.right, 10);
 
        linkedList.head.right.right = linkedList.push(linkedList.head.right.right, 50);
        linkedList.head.right.right = linkedList.push(linkedList.head.right.right, 22);
        linkedList.head.right.right = linkedList.push(linkedList.head.right.right, 19);
 
        linkedList.head.right.right.right = linkedList.push(linkedList.head.right.right.right, 45);
        linkedList.head.right.right.right = linkedList.push(linkedList.head.right.right.right, 40);
        linkedList.head.right.right.right = linkedList.push(linkedList.head.right.right.right, 35);
        linkedList.head.right.right.right = linkedList.push(linkedList.head.right.right.right, 20);
 
        // flinkedListatten the linkedListist
        linkedList.head = linkedList.flatten(linkedList.head);
        linkedList.printList();

	}

}
