import java.util.*;
public class MinDistBwTwoWords {

    private static int BFApproach(String str,String word1,String word2)
    {
       // int n=str.length();
        String[] sArr =str.split(" ");
        int min=Integer.MAX_VALUE,distance=0,iLock=-1;
        for(int i=0;i<sArr.length;i++)
        {
            if(!sArr[i].equals(word1)) continue;
            iLock=0;
            for(int j=i+1;j<sArr.length;j++)
            {
                if(word2.equals(sArr[j]))
                {
                   
                    distance=j-i;
                    min=Math.min(min,distance);
                    break;
                }
            }
        }
        if(iLock==-1) return -2;
       // if(jLock==-1) return -3;
        if(min==Integer.MAX_VALUE) return -1;
        return min-1;


    }

    private static int usingMaps(String s,String w1,String w2)
    {
        HashMap<String,Integer> map = new LinkedHashMap<>();
        String[] sArr =s.split(" ");
        int word1Lock=-1,word2Lock=-1,distance=0,min=Integer.MAX_VALUE;
        for(int i=0;i<sArr.length;i++)
        {
            if(!map.containsKey(w1)) map.put(w1,i);
            if(!map.containsKey(w2)) map.put(w2,i);
            if(map.containsKey(w1) && map.containsKey(w2))
            {
                distance=map.get(w2)-map.get(w1);
                min=Math.min(min,distance);
                map.put(w1,i);
                map.put(w2,i);
            }
            
        }
        if(min==Integer.MAX_VALUE) return -1;
        return min;
    }
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String .. ");
        String str=sc.nextLine();
        System.out.println("Enter the word 1 .. ");
        String word1=sc.nextLine();
        System.out.println("enter the word 2 .. ");
        String word2=sc.nextLine();
        sc.close();


       /* int r1=BFApproach(str,word1,word2);
        if(r1==-1) System.out.println("The word 2 is not found in the String");
        else if(r1==-2) System.out.println("The word 1 is not found in the String");
        else if(r1==1) System.out.println("Both the words are next to each other");
        else System.out.println("The minimum distance b/w word 1 and word 2 is : "+r1);*/

        
        int r2=usingMaps(str,word1,word2);
        if(r2==-1) System.out.println("The words are not there");
        else System.out.println("The minimum distacne b/w word 1 and word 2 : "+r2);
    }
}
