package string;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t= "ABC";
        System.out.println(new MinWindow().minWindow(s,t));
    }
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c: t.toCharArray()){
            map.put(c,  map.getOrDefault(c,0)+1);
        }
        int unique = map.size();
        int st = 0, end =0, len = Integer.MAX_VALUE, i=0;
        String ans = "";
        for(i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                continue;
            }

            map.put(c,map.get(c)-1);

            if(map.get(c)==0){
                unique--;
            }
            while(unique == 0){
                if(len>i-st+1){
                    ans = s.substring(st,i+1);
                    len = i-st+1;
                }
                char ch = s.charAt(st);
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)+1);
                    if(map.get(ch)==1){
                        unique++;
                    }
                }
                st++;
            }
        }

        return ans;
    }
}
