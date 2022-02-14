package com.singly_ll_using_tail;


class Node
{
	int data;
	Node next;
	Node(int data)
	{
		this.data=data;
	}
}
class Linked_List
{
	int size=0;
	Node head,tail;
	public void insertAtStart(int data)
	{
		Node node = new Node(data);
		if(head==null) 
		{
			head=node;
			tail=node;
			size++;
		}
		else
		{
			Node temp = head;
			head=node;
			head.next=temp;
			size++;
		}
	}
	
	public void insertAtEnd(int data)
	{
		Node node = new Node(data);
		Node traverse = head;
		while(traverse.next!=null)
		{
			traverse=traverse.next;
		}
		traverse.next=node;
		tail=node;
		
		
	}
	
	public void showTail()
	{
		System.out.println("Tail : "+tail.data);
	}
	
	public void showHead()
	{
		System.out.println("head : "+head.data);
	}
	
	public void show()
	{
		if(head==null) System.out.println("No nodes available");
		else
		{
			Node traverse = head;
			while(traverse.next!=null)
			{
				System.out.print(traverse.data+" -- > ");
				traverse=traverse.next;
			}
			System.out.println(traverse.data);
		}
		System.out.println();
	}
}

public class Singly_LL_Using_Tail {

	public static void main(String[] args) {
		
		Linked_List ll = new Linked_List();
		ll.insertAtStart(0);
		ll.show();
		ll.showHead();
		ll.showTail();
		ll.insertAtStart(-1);
		ll.show();
		ll.showHead();
		ll.showTail();
		ll.insertAtStart(-2);
		ll.show();
		ll.showHead();
		ll.showTail();
		ll.insertAtEnd(10);
		ll.show();
		ll.showHead();
		ll.showTail();
		ll.insertAtEnd(20);
		ll.show();
		ll.showHead();
		ll.showTail();
		ll.insertAtEnd(30);
		ll.show();
		ll.showHead();
		ll.showTail();
		

	}

}
