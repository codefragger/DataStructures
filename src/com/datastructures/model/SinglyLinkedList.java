package com.datastructures.model;

public class SinglyLinkedList {
	
	public Node head;

	public SinglyLinkedList(Node head) {
		super();
		this.head = head;
	}
	
	public SinglyLinkedList() {
		
	}

	public void print() {
		Node i = head;
		while(i != null) {
			System.out.println(i.data);
			i = i.next;
		}
	}
	
	public void reverseLinkedList() {
		Node prev = null;
		Node next = null;
		Node current = this.head;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		 this.head = new SinglyLinkedList(prev).head;
	}
	
	public void addNode(int data) {
		Node i = head;
		if(head == null) {
			this.head = new Node(data);
			return;
		}
		while(i.next != null) {
			
			i = i.next;
		}
		i.next = new Node(data);
	}
	
	public void push(int data) {
		Node node = new Node(data);
		node.next = this.head;
		this.head = node;
	}
	
	public void deleteNode(int data) {
		if(this.head == null) {
			return;
		}
		Node prev = this.head;
		Node temp = prev.next;
		
		if(prev.data == data) {
			this.head = temp;
		}
		
		while(temp != null && temp.data != data) {
			
			prev = temp;
			temp = temp.next;
		}
		if(temp == null) {
			return;
		}
		prev.next = temp.next;
	}
	
	public void deleteNodeAtPosition(int pos) {
		if(head == null) {
			return;
		}
		if(pos == 0) {
			head = head.next;
		}
		Node prev = head;
		Node temp = prev.next;
		
		for(int i = 0 ; temp != null && i < pos -1 ; i++) {
			temp = temp.next;
		}
		if(temp == null || temp.next == null) {
			return;
		}
		temp.next = temp.next.next;
		
		
	}
	
	public Node mergeSort(Node h) {
		if(h == null || h.next == null) {
			return h;
		}
		Node mid = getMidNode(h);
		Node nextOfMiddle = mid.next;
		
		//separting left and right part
		mid.next = null;
		
		Node left = mergeSort(h);
		Node right = mergeSort(nextOfMiddle);
		
		Node sortedList = sortedMerge(left, right);
		return sortedList;
	}
	
	private Node sortedMerge(Node left, Node right) {
		if(right == null) {
			return left;
		}
		if(left == null) {
			return right;
		}
		Node result;
		if(left.data < right.data) {
			result = left;
			result.next = sortedMerge(left.next	, right);
		}
		else {
			result = right;
			result.next = sortedMerge(left, right.next);
		}
		return result;
	}

	private Node getMidNode(Node h) {
		Node fast = h.next;
		Node slow = h;
		while(fast != null) {
			fast = fast.next;
			if(fast != null) {
				fast = fast.next;
				slow = slow.next;
			}
		}
		return slow;
	}

	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList(new Node(1));
		Node cur = singlyLinkedList.head;
		for(int i = 10 ; i > 1 ; i--) {
			cur.next = new Node(i);
			cur = cur.next;
		}
		
		//singlyLinkedList.print();
		Node sorted = singlyLinkedList.mergeSort(singlyLinkedList.head);
		singlyLinkedList.head = sorted;
		singlyLinkedList.print();
		
	}
}
