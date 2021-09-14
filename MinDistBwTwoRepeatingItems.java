import java.util.*;
class MinDistBwTwoRepeatingItems {
    private static int BFApproach(int[] a,int n)
    {
        int lock=-1,min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
           
            for(int j=i+1;j<n;j++)
            {
                if(a[i]==a[j])
                {
                    int count=j-i;
                    lock=j;
                    min=Math.min(min,count);
                    break;
                }
            }
        }
        if(lock==-1) return -1;
        return min-1;
    }

    private static int usingMap(int[] a,int n)
    {
        int min=Integer.MAX_VALUE;
        Map<Integer,Integer> map =new LinkedHashMap<>(); // 1 0 2 3 1 4 1
        for(int i=0;i<n;i++) 
        {
            if(!map.containsKey(a[i]))
            {
                map.put(a[i],i);
            }
            else{
                min=Math.min(min,i-map.get(a[i]));
                map.put(a[i],i);
            }
        }
        if(min==Integer.MIN_VALUE) return -1;
        return min-1;

    }
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the no . o f elements");
        int n=sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        sc.close();
        
        int r1=BFApproach(a,n);
        if(r1==-1) System.out.println("There is no  repeating element found..");
        else if(r1==0) System.out.println("Both the elements are next to each other..");
        else System.out.println("The min dist b/w two repeating items is : "+r1);

        int r2=usingMap(a,n);
        if(r2==-1) System.out.println("There is no  repeating element found..");
        else if(r2==0) System.out.println("Both the elements are next to each other..");
        else System.out.println("The min dist b/w two repeating items is : "+r2);
        
    }
}
