package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FindAndReplace {
    public static void main(String[] args) {
        String[] arr = {"abc","deq","mee","aqq","dkd","ccc"};
        String p = "abb";
        List<String> ans = new FindAndReplace().findAndReplacePattern(arr,p);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        Map<Character,Character> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for(String w: words){
            int j =0;
            if(w.length()!=pattern.length())
                continue;
            boolean match = false;
            for(int i=0;i<pattern.length();i++){
                char c = pattern.charAt(i);
                if(map.containsKey(c)){
                    if(map.get(c)!=w.charAt(j)){
                        match = false;
                        break;
                    }
                }else{
                    match = true;
                    map.put(c, w.charAt(j));
                }
                j++;
            }

            if(match)
                ans.add(w);

        }
        return ans;
    }
}
