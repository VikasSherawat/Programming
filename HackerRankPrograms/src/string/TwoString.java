package string;

import java.util.*;
public class TwoString {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        List<Boolean> result = new ArrayList<Boolean>();
        while(T-->0){
            String A = in.next();
            String B = in.next();
            Map<Character,Integer> map1 = convertDatatoMap(A);
            Map<Character,Integer> map2 = convertDatatoMap(B);
            Set<Character> set;
            boolean flag=false,subString=false;
            if(A.length()>=B.length()){
              set = map2.keySet();
                flag = true;
            }
            else{
              set = map1.keySet();
            }
            Iterator<Character> iter = set.iterator();
            while(iter.hasNext()){
                char key = iter.next();
                if(!flag &&  map2.containsKey(key))
                {
                    subString = true;
                    break;
                }
                
                   if(flag && map1.containsKey(key)){
                       subString = true;
                         break;
                    }
                
            }
            result.add(subString);
        }//outer while loop
        
        for(Boolean b: result){
            if(b)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        
    }//main function
    
    static Map<Character,Integer> convertDatatoMap(String inp){
        Map<Character,Integer> map = new TreeMap<Character,Integer>();
        for(int i=0;i<inp.length();i++){
            char key = inp.charAt(i);
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }
        return map;
    }
}
