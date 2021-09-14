import java.util.*;
public class IntegerEqualToStrLen {

    private static String check(String s)
    {
       // Map<Integer,Integer> map = new HashMap<>();
        int n=0,charCount=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isAlphabetic(c)) charCount++;
            if(Character.isDigit(c))
            {
                n=0;
                while(Character.isDigit(c))
                {
                    n=(n*10)+(int)c-'0';
                    i++;
                    c=s.charAt(i);
                }
                i--;
               // System.out.println(n);
               // map.put(n, charCount);
            }
        }
        if(n==charCount) return "TRUE "+String.valueOf(n);
        else return "FALSE "+String.valueOf(n);
       /* for(Map.Entry e : map.entrySet())
        {
            int key=(int)e.getKey();
            int val=(int)e.getValue();
            if(key!=val) return false;
        }
        return true;*/
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String s =sc.nextLine();
        sc.close();
        System.out.println(check(s));
       
    }
}
