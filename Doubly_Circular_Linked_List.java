package com.doublylinkedlistcircular;


class Node
{
	Node next,prev;
	int data;
	Node(int data)
	{
		this.data=data;
	}
}
class Linked_List
{
	Node head,tail;
	public int size=0;
	public void insertAtStart(int data)
	{
		Node node = new Node(data);
		if(head==null)
		{
			head=node;
			tail=node;
			head.next=tail;
			head.prev=tail;
		}
		else if(head!=tail)
		{
			head.prev=node;
			node.next=head;
			node.prev=tail;
			head=node;
			tail.next=head;
		}
		else if(head==tail)
		{
			node.next=head;
			head.prev=node;
			node.prev=head;
			tail=head;
			tail.next=node;
			head=node;
		}
		size++;
	}
	
	public void insertAtEnd(int data)
	{
		Node node = new Node(data);
		if(head!=tail)
		{
			Node temp = tail;
			temp.next=node;
			node.prev=temp;
			node.next=head;
			tail=node;
			head.prev=tail;
			size++;
		}
		else if(head==null)
		{
			insertAtStart(data);
		}
		else if(head==tail)
		{
			head.next=node;
			node.prev=head;
			node.next=head;
			tail=node;
			head.prev=tail;
			size++;
		}
	}
	
	
	public void insertAfterNode(Node node,int data)
	{
		Node newNode = new Node(data);
		if(node.next==null) insertAtEnd(data);
		else if(node.next==head) insertAtEnd(data);
		else if(node.next!=null)
		{
			newNode.next=node.next;
			node.next.prev=newNode;
			node.next=newNode;
			newNode.prev=node;
			size++;
		}
	}
	public void deleteAtStart()
	{
		if(head==null) 
		{
			System.out.println("No nodes available...");
			return ;
		}
		else if(head==tail)
		{
			System.out.println("Only  1 node present...");
			head=null;
			tail=null;
		}
		else if(head!=tail)
		{
			head=head.next;
			head.prev=tail;
			tail.next=head;
		}
		size--;
	}
	
	public void deleteAtEnd()
	{
		if(head==null) 
		{
			System.out.println("No nodes available...");
			return ;
		}
		else if(head==tail)
		{
			System.out.println("Only  1 node present...");
			head=null;
			tail=null;
			
		}
		else
		{
//			Node temp = tail.prev;
//			temp.next=null;
//			tail=temp;
			tail=tail.prev;
			tail.next=head;
		}
		size--;
	}
	
	public void deleteAfter(Node node)
	{
		if(node.next==tail) 
		{
			deleteAtEnd();
			return ;
		}
		if(node.next!=head)
		{
			Node temp = node.next;
			if(temp.next!=null)
			{
				node.next=temp.next;
				temp.next.prev=node;
			}
			else
			{
				node.next=null;
				tail=node;
			}
		}
		else
		{
			System.out.println("No nodes available after the node : "+node.data);
			return ;
		}
		size--;
	}
	
	public void deleteNode(Node node)
	{
		if(head==null)
		{
			System.out.println("NO nodes available");
			return;
		}
		if(node.next==null) deleteAtStart();
		if(node==head) deleteAtStart();
		else if(node==tail) deleteAtEnd();
		else
		{
			node.prev.next=node.next;
			node.next.prev=node.prev;
			size--;
		}
	}
	

	public void show()
	{
		if(head!=null)
		{
			Node traverse =  head;
			while(traverse.next!=head)
			{
				System.out.print(traverse.data+" -- > ");
				traverse=traverse.next;
			}
			System.out.print(traverse.data);
			System.out.println("\nhead : "+head.data+" tail : "+tail.data);
			System.out.println();
		}
	}
	
	public void getNextOfTail()
	{
		System.out.println("Tail next : "+tail.next.data);
	}
	public void getPrevOfHead()
	{
		System.out.println("Head prev : "+head.prev.data);
	}
}
public class Doubly_Circular_Linked_List {

	public static void main(String[] args) {
		Linked_List ll = new Linked_List();
		System.out.println("Insert At Start");
		ll.insertAtStart(0);
		ll.show();
		ll.insertAtStart(-1);
		ll.show();
		ll.insertAtStart(-2);
		ll.show();
		ll.insertAtStart(-3);
		ll.show();
		ll.insertAtStart(-4);
		ll.show();
		System.out.println("Insert At End");
		ll.insertAtEnd(5);
		ll.show();
		ll.insertAtEnd(6);
		ll.show();
		ll.insertAtEnd(7);
		ll.show();
		ll.insertAtEnd(8);
		ll.show();
		ll.getNextOfTail();
		ll.getPrevOfHead();
		ll.insertAtEnd(9);
		ll.show();
		ll.insertAtEnd(10);
		ll.show();
		ll.getNextOfTail();
		ll.getPrevOfHead();
		System.out.println("Insert After Node...");
		ll.insertAfterNode(ll.head.next.next, 100);
		ll.show();
		ll.getNextOfTail();
		ll.getPrevOfHead();
		ll.insertAfterNode(ll.head.next.next.next.next, 200);
		ll.show();
		ll.getNextOfTail();
		ll.getPrevOfHead();
		System.out.println("Delete At Start ...");
		ll.deleteAtStart();
		ll.show();
		ll.deleteAtStart();
		ll.show();
		ll.deleteAtStart();
		ll.show();
		ll.deleteAtStart();
		ll.show();
		System.out.println("Delete At End...");
		ll.deleteAtEnd();
		ll.show();
		ll.deleteAtEnd();
		ll.show();
		ll.deleteAtEnd();
		ll.show();
		System.out.println("Delete After Node ...");
		ll.deleteAfter(ll.head.next);
		ll.show();
//		ll.deleteAfter(ll.head.next);
//		ll.show();
//		ll.deleteAfter(ll.head.next);
//		ll.show();
//		ll.deleteAfter(ll.head);
//		ll.show();
//		ll.deleteAfter(ll.tail);
		ll.show();
		
		
		
		
		
	

	}

}
