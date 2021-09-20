package NewLL;
class Node
{
    int data;
    Node next;
}
class LinkedList {
    Node head;
    Node tail;
    public int getHead()
    {
        return head.data;
    }
    public int getTail()
    {
        return tail.data;
    }
    public void insert(int data)
    {
        insertAtEnd(data);
    }
    public void insertAtEnd(int data)
    {
        Node node = new Node();
        node.data=data;
        if(head==null)
        {
            head=node;
            tail=node;
        }
        else
        {
            tail.next=node;
            tail= node;
        }
    }
    public void insertAtStart(int data)
    {
        Node node  = new Node();
        node.data= data;
        if(head==null)
        {
            head=node;
            tail=node;
        }
        else
        {
            // 4  -->  1  --> 2 --> 3
            Node temp = head;

            head=node;
            head.next=temp;
        }
    }
    public void insertAt(int pos,int data)
    {
        Node node =  new Node();
        node.data=data;
        if(pos<1) 
        {
            System.out.println("Invalid position ...");
            return;
        }
        else
        {
            Node last = head;
            Node prev = null;
            for(int i=0;i<=pos-2;i++)
            {
                prev=last;
                last=last.next;
            }
            node.next=last.next;
            prev.next=node;
        }
        
           
        

    }
    public void show()
    {
        if(head==null)
        {
            System.out.println("List is empty...");
            return;
        }
        Node traversal = head;
        while(traversal!=null)
        {
            System.out.print(traversal.data+" ");
            traversal=traversal.next;
        }
        System.out.println();
    }
    public void deleteAtStart()
    {
        if(head==null) 
        {
            System.out.println("List is empty .. ");
            return;
        }
        else
        {
            Node temp = head;
            head=temp.next;
            temp.next=null;
        }
    }
    public void deleteAtEnd()
    {
        if(head==null)
        {
            System.out.println("List is empty ... ");
            return;
        }
        else
        {
            if(head!=tail)
            {
                Node traversal  = head;
                while(traversal.next!=tail)
                {
                    traversal=traversal.next;
                }
                tail=traversal;
                tail.next=null;
            }
          
        }
    }
}
class Main
{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.show();
        list.insertAtStart(0);
        list.show();
        list.insertAtEnd(2);
        list.show();
        list.insertAtStart(3);
        list.show();
        list.insertAtStart(-1);
        list.show();
        list.insertAtEnd(4);
        list.show();
        list.insertAt(4,100); // based on 1 idexing .....
        list.show(); 
        list.deleteAtStart();
        list.deleteAtStart();
        list.show();
        list.deleteAtEnd();
       // list.deleteAt();
        list.show();
        System.out.println("Head : "+list.getHead());
        System.out.println("Tail : "+list.getTail());
        list.show();
    }
}
