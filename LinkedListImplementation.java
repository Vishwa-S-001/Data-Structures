import java.util.Scanner;
class Node
{
    int data;
    Node next;
}
class LinkedList
{
    Node head;
    
    public void insert(int data)
    {
        Node node = new Node();
        node.data=data;
        node.next=null;
        if(head==null)
        {
            head=node;
        }
        else
        {
            Node temp = head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=node;
        }
    }
    public void insertAtStart(int data)
    {
        Node node = new Node();
        node.data=data;
        node.next=null;
        node.next=head;
        head=node;
    }
    public void insertAt(int pos,int data)
    {
        Node node =new Node();
        node.data=data;
        node.next=null;
        if(pos==0)
        {
            insertAtStart(data);
        }
        else
        {
          
            Node temp=head;
            for(int i=0;i<pos-1;i++)
            {
                temp=temp.next;
            }
            node.next=temp.next;
            temp.next=node;
        }
    }
    public void deleteAt(int pos)
    {
        if(pos==0)
        {
            head=head.next;
        }
        else
        {
            Node temp=head;
            Node temp1 = null;
            for(int i=0;i<pos-1;i++)
            {
                temp=temp.next;
            }
            temp1=temp.next;
            temp.next=temp1.next;
            System.out.println(temp1.data+" deleted..");
            temp1=null;// releases memory
        }
    }
    public void show()
    {
        Node temp =head;
        while(temp.next!=null)
        {
            System.out.print(temp.data+" ---> ");
            temp=temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }
}
class Main 
{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        LinkedList ll = new LinkedList();
        ll.insert(10);
        ll.show();
        ll.insert(20);
        ll.show();
        //give pos based on '0' indexing
        ll.insertAt(1, 30);
        ll.show();
        ll.deleteAt(0);
        ll.show();
        ll.insertAtStart(100);
        ll.show();
        sc.close();
    }
}