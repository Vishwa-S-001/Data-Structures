package com.singly_circular_ll;
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
		System.out.println("Insert At start : "+data);
		Node node = new Node(data);
		if(head==null) 
		{
			head=node;
			tail=node;
			
		}
		else if(head!=tail)
		{
			Node temp = head;
			head=node;
			head.next=temp;
			tail.next=head;
		}
		else 
		{
			
			Node temp = head;
			head=node;
			head.next=temp;
			tail=temp;
			tail.next=head;
			
		}
		size++;
	}
	
	public void insertAtEnd(int data)
	{
		System.out.println("Insert At End : "+data);
		Node node = new Node(data);
		if(tail==head)
		{
			head.next=node;
			tail=node;
			tail.next=head;

		}
		else
		{
			tail.next=node;
			tail=node;
			tail.next=head;
		}
		size++;
		
	}
	
	public void insertAt(int data,int pos)
	{
		System.out.println("Insert At : "+pos+" data : "+data);
		if(pos==1) insertAtStart(data);
		else if(pos==size) insertAtEnd(data);
		else
		{
			if(head!=null)
			{
				Node traverse = head;
				Node node= new Node(data);
				for(int i=1;i<pos-1;i++)
				{
					traverse=traverse.next;
				}
				Node t = traverse.next;
				traverse.next=node;
				node.next=t;
				size++;
			}
			else System.out.println("No nodes available");
		}
		
	}
	
	// 1 2 3 
	
	public void deleteAtStart()
	{
		System.out.println("Delete At Start");
		if(head==null) System.out.println("No nodes available");
		else
		{
			head=head.next;
			tail.next=head;
		}
		size--;
	}
	
	public void deleteAtEnd()
	{
		System.out.println("Delete At End");
		if(head==tail)
		{
			System.out.println("Only 1 Node present ... ");
			head=null;
			tail=null;
			size--;
		}
		else
		{
			Node traverse = head;
			while(traverse.next!=tail)
			{
				traverse=traverse.next;
			}
			traverse.next=head;
			tail=traverse;
			size--;
		}
	}
	
	public void showTail()
	{
		System.out.println("Tail : "+tail.data+"\n");
		System.out.println("------------------------------");
	}
	
	public void showHead()
	{
		System.out.println("head : "+head.data+"\n");
	}
	
	
	public void showSize()
	{
		System.out.println("Size : "+size+"\n");
	}
	
	public void show()
	{
		if(head==null) System.out.println("No nodes available");
		else
		{
			Node traverse =head;
			for(int i=1;i<size;i++)
			{
				System.out.print(traverse.data+" -- > ");
				traverse=traverse.next;
			}
			System.out.print(traverse.data);
			System.out.println();
		}
	}
	
	public void showCircularKTimes(int c)
	{
		Node traverse = head;
		while(c!=0)
		{
			System.out.print(traverse.data+" -- > ");
			traverse=traverse.next;
			if(traverse.next==head) 
			{
				System.out.print(traverse.data+"\n");
				c--;
				//traverse=head;
			}
		}
		System.out.println();
	}
}

public class Singly_Circular_LL {

	public static void main(String[] args) {
		
		Linked_List ll = new Linked_List();
		
		//insert at start
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
		
		
		// Insert At end
		
		ll.insertAtEnd(10);
		ll.show();
		ll.showHead();
		ll.showTail();
		
		ll.insertAtEnd(20);
		ll.show();
		ll.showHead();
		ll.showTail();
		
		// PROOF
		System.out.println("----PROOF FOR CIRCULAR-------");
		ll.showCircularKTimes(2);
		
		//insert at
		System.out.println("Before Insertion : ");
		ll.show();
		ll.insertAt(9, 4);
		System.out.println("After Insertion : ");
		ll.show();
		
		// delete at start
		ll.deleteAtStart();
		ll.show();
		ll.showHead();
		ll.showTail();
		
		
		
		// delete at end
		ll.deleteAtEnd();
		ll.show();
		ll.showHead();
		ll.showTail();
		
		

	}

}
