import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
class GreatestElementHavingSameFreqAsSameValue
{
    private static int validate(int[] a,int n)
    {
        HashMap<Integer,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<n;i++) map.put(a[i],map.get(a[i])==null ? 1 : map.get(a[i])+1);
        int max=Integer.MIN_VALUE;
        for(Map.Entry e : map.entrySet())
        {
            int key=(int)e.getKey();
            int val=(int)e.getValue();
            if(key==val)
            {
                if(key>max)
                {
                    max=key;
                }
            }
        }
        if(max==Integer.MIN_VALUE) return -1;
        return max;
    }
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the no . o f elements");
        int n=sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        sc.close();
        int result=validate(a,n);
        System.out.println("output : "+result);

    }
}