import java.util.Scanner;
class Stack
{
    public static final int MAX= 1000;
    int[] stack = new int[MAX];
    int top;
    Stack()
    {
        top=-1;

    }

    public boolean isFull()
    {
        return top>MAX-1;
    }
    public boolean isEmpty()
    {
        return top<0;
    }
    public void push(int data)
    {
        if(isFull())
        {
            System.out.println("The Stack is Full!!.. Overflow has Occurred !!!..");
        }
        else{
            stack[++top]=data;
        }
    }
    public int pop()
    {
        if(isEmpty()) System.out.println("There is no element in the stack .. Underflow has occurred!!..");
        else
        {
            return stack[top--];
        }
        return 0;
    }
    public int peek()
    {
        return stack[top];
    }
    public int size()
    {
        return top+1;
    }
    public void show()
    {
        for(int i=top;i>=0;i--) 
        {
            if(i>0) System.out.print(stack[i]+" --> ");
            else System.out.print(stack[i]);
        }
        System.out.println();
    }
} 
class Main 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Stack myStack = new Stack();
        System.out.println("Enter the no. of elements you want to push into the stack: ");
        int n=sc.nextInt();
        System.out.println("Enter the elements : ");
        for(int i=1;i<=n;i++) myStack.push(sc.nextInt());
        myStack.pop();
        myStack.show();
        myStack.pop();
        myStack.show();
        myStack.pop();
        myStack.show();
        System.out.println("peek : "+myStack.peek());
        System.out.println("Size : "+myStack.size());

        

    }
        
    
}
 