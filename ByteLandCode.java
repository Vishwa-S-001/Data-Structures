import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

class ByteLandCode
{

    private static boolean check(String s)
    {
        if(s.length()==1 && s.charAt(0)=='a') return true;
        HashMap<Character,Integer> map = new LinkedHashMap<>();
        for(char c : s.toCharArray())
        {
            map.put(c,map.get(c)==null ? 1 : map.get(c)+1);
        }
        for(Map.Entry e : map.entrySet())
        {
            int position=(char) e.getKey()-'a'+1;
            if((int)e.getValue()!=position) return false;
        }
        return true;

    }
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the String");
        String str= sc.nextLine();
        if(check(str)) System.out.println("True");
        else System.out.println("False");
    }
}