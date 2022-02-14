package com.doublylinkedlist;
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
		}
		else if(head!=tail)
		{
			head.prev=node;
			node.next=head;
			node.prev=null;
			head=node;
		}
		else if(head==tail)
		{
			Node temp = head;
			head.prev=node;
			head.next=null;
			node.next=head;
			node.prev=null;
			head=node;
			tail=temp;
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
			tail=node;
			size++;
		}
		else if(head==null)
		{
			insertAtStart(data);
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
			Node temp = head.next;
			temp.prev=null;
			head=temp;
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
			Node temp = tail.prev;
			temp.next=null;
			tail=temp;
		}
	}
	
	public void deleteAfter(Node node)
	{
		if(node.next!=null)
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
		else if(node.next==tail)
		{
			deleteAtEnd();
			return;
		}
		else
		{
			System.out.println("No nodes available after the node : "+node);
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
			while(traverse.next!=null)
			{
				System.out.print(traverse.data+" -- > ");
				traverse=traverse.next;
			}
			System.out.print(traverse.data);
			System.out.println("\nhead : "+head.data+" tail : "+tail.data);
			System.out.println();
		}
	}
}
public class DLL {

	public static void main(String[] args) {
		Linked_List ll = new Linked_List();
		ll.insertAtStart(0);
		ll.show();
		ll.insertAtStart(-1);
		ll.show();
		ll.insertAtStart(-2);
		ll.show();
		ll.insertAtStart(10);
		ll.show();
		ll.insertAtEnd(12);
		ll.show();
		ll.insertAtEnd(13);
		ll.show();
		ll.insertAtStart(-99);
		ll.show();
		ll.insertAtEnd(15);
		ll.show();
		ll.insertAtEnd(16);
		ll.show();
		System.out.println("Deletion At Start");
		ll.deleteAtStart();
		ll.show();
//		ll.deleteAtStart();
//		ll.show();
//		ll.deleteAtStart();
//		ll.show();
//		ll.deleteAtStart();
		ll.show();
		System.out.println("Deletion At End");
		ll.deleteAtEnd();
		ll.show();
//		ll.deleteAtEnd();
//		ll.show();
//		ll.deleteAtEnd();
//		ll.show();
//		ll.deleteAtEnd();
//		ll.show();
//		ll.deleteAtEnd();
		ll.show();
		System.out.println("Deletion  Node");
		//Node node;
		ll.deleteAfter(ll.head.next);
		ll.show();
		ll.deleteAfter(ll.head.next);
		ll.show();
		ll.deleteAfter(ll.head.next);
		ll.show();
//		ll.deleteAfter(ll.head.next);
//		ll.show();
//		ll.deleteAfter(ll.head);
//		ll.show();
//		ll.deleteAfter(ll.head);
//		ll.show();
//		ll.deleteAfter(ll.head);
		//ll.show();
		System.out.println("Deletion of Node");
		ll.deleteNode(ll.head.next);
		ll.show();
		ll.deleteNode(ll.head.next);
		ll.show();
		ll.deleteNode(ll.head.next);
		ll.show();
		
	

	}

}
