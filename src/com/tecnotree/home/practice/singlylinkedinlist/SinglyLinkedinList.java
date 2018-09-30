package com.tecnotree.home.practice.singlylinkedinlist;

public class SinglyLinkedinList
{

	private ListNode head;

	public void displayNode(ListNode head)
	{
		if (head == null) { return; }

		ListNode current = head;
		while (current != null)
		{
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.println(current);
	}

	public int length(ListNode head)
	{
		if (head == null) { return 0; }
		int count = 0;
		ListNode current = head;

		while (current != null)
		{
			count++;
			current = current.next;
		}
		System.out.println("Node count is :: " + count);
		
		return count;
	}
	
	public ListNode inserNodeAtFirst(ListNode head, int data) {
		
		ListNode newNode = new ListNode(data);
		if(head == null) {
			return newNode;
		}
		newNode.next = head;
		head = newNode;
		return head;
	}
	
	public ListNode insertNodeAtLast(ListNode head, int data) {
		ListNode newNode = new ListNode(data);
		if(head == null) {
			return newNode;
		}
		ListNode current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = newNode;
		
		return head;
	}

	public void insertNodeAfter(ListNode previous, int data) {
		if(previous == null) {
			System.out.println("Given Prevous Node cannot be null");
			return;
		}
		
		ListNode newNode = new ListNode(data);
		newNode.next = previous.next;
		previous.next = newNode;
	}
	
	public ListNode insertNodeAtSpecificLocation(ListNode head, int data, int position)
	{
		int size = length(head);
		if(position > size + 1 || position< 1) {
			System.out.println("Invalid position");
			return head;
		}
		
		ListNode newNode = new ListNode(data);
		
		if(position == 1) {
			newNode.next = head;
			return newNode;
		} else {
			ListNode previous = head;
			int count = 1;
			while (count < position-1) {
				previous = previous.next;
				count++;
			}
			ListNode current = previous.next;
			newNode.next = current;
			previous.next = newNode;
			return head;
		}
	}
	
	public ListNode deleteFirstNode(ListNode head)
	{
		if(head == null) {
			return head;
		}
		
		ListNode temp = head;
		head = head.next;
		temp = null;
		
		return head;
	}
	
	private ListNode deleteLastNode(ListNode head)
	{
		if(head == null) {
			return head;
		}
		ListNode last = head;
		ListNode privousLastNode = null;
		
		while(last.next != null) {
			privousLastNode = last;
			last = last.next;
			
		}
		privousLastNode.next = null;
		return last;
	}
	
	private ListNode deleteNodeAtSpecificLocation(ListNode head, int position)
	{
		int size = length(head);
		
		if(position > size || position < 1 ) {
			System.out.println("Given position is invalid");
			return head;
		}
		
		if( position == 1) {
			ListNode temp = head;
			head = temp.next;
			temp.next = null;
			return head;
		} else {
			ListNode previous = head;
			int counter = 1;
			while(counter < position - 1) {
				previous = previous.next;
				counter++;
			}
			// 10 -> 4 -> 43 ->15 ->19
			ListNode current = previous.next;
			previous.next = current.next;
			current.next = null;
			return current;
		}
	}
	
	private boolean searchNode(ListNode head, int searchKey)
	{
		if(head == null) {
			return false;
		}
		ListNode current = head;
		
		while(current != null) {
			if(current.data == searchKey) {
				return true;
			}
			current = current.next;
		}
		return false;
	
	}
	
	private ListNode reverseNode(ListNode head)
	{
		if(head == null) {
			System.out.println("No Nodes");
			return head;
		}

		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		
		while (current != null)
		{
			next = current.next;
			current.next = previous ;
			previous = current;
			current = next;
		}
		
		return previous;
	}

	private ListNode findMiddleOfNode(ListNode head)
	{

		if(head == null) {
			return null;
		}
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = slowPtr.next.next;
		}
				
		return slowPtr;
	}
	
	static class ListNode
	{
		private int data;
		private ListNode next;

		ListNode(int data)
		{
			this.data = data;
			this.next = null;
		}
	}


	
	
	
	public static void main(String[] args)
	{
		ListNode head = new ListNode(10);
		ListNode second = new ListNode(4);
		ListNode third = new ListNode(43);
		ListNode fourth = new ListNode(15);
		ListNode fifth = new ListNode(19);
		ListNode sixth = new ListNode(20);
		ListNode sixth1 = new ListNode(30);
		ListNode sixth2 = new ListNode(35);
		ListNode sixth3 = new ListNode(40);
		ListNode sixth4 = new ListNode(45);
		ListNode sixth5 = new ListNode(50);
		ListNode sixth6 = new ListNode(55);

		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		
		sixth.next = sixth1;
		sixth1.next = sixth2;
		sixth2.next = sixth3;
		sixth3.next = sixth4;
		sixth4.next = sixth5;
		sixth5.next = sixth6;
	
		

		SinglyLinkedinList singlyLinkedList = new SinglyLinkedinList();
		singlyLinkedList.displayNode(head);

		singlyLinkedList.length(head);
		
		//ListNode newListNode = singlyLinkedList.inserNodeAtFirst(head, 18);
		//singlyLinkedList.displayNode(newListNode);
		
		//inserting node at last 
		/*
		
		 ListNode newListNode = singlyLinkedList.insertNodeAtLast(head, 25);
		singlyLinkedList.displayNode(newListNode);
		
		//Inserting node at specific position
		singlyLinkedList.insertNodeAfter(second, 50);
		singlyLinkedList.displayNode(newListNode);
		
		head = singlyLinkedList.insertNodeAtSpecificLocation(head,75,5);
		singlyLinkedList.displayNode(head);
		
		//Delete node at first position
		ListNode first = singlyLinkedList.deleteFirstNode(head);
		System.out.println("Firtst Node ::"+first.data);
		singlyLinkedList.displayNode(first);
		
		//Delete node at last position
		ListNode last = singlyLinkedList.deleteLastNode(head);
		System.out.println("Last Node ::"+last.data);
		//linkedinList.displayNode(last);
		singlyLinkedList.displayNode(first);
		
		
		
		//Delete node at specific position
		ListNode deleteNode = singlyLinkedList.deleteNodeAtSpecificLocation(head,3);
		System.out.println("Last Node ::"+deleteNode.data);
		//linkedinList.displayNode(last);
		singlyLinkedList.displayNode(head);
		
		boolean searchNode = singlyLinkedList.searchNode(head,13);
		if(searchNode == true) {
			System.out.println("Searching Key found");
		} else {
			System.out.println("Searching Key Not found");
		}
		
		singlyLinkedList.displayNode(head);
		ListNode reverse = singlyLinkedList.reverseNode(head);
		singlyLinkedList.displayNode(reverse);
		*/
		
		ListNode middleNode = singlyLinkedList.findMiddleOfNode(head);
		System.out.println(middleNode.data);
		
	}
	
}
