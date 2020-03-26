package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestStringChain {
    int max =1;
    Map<String, Integer> dp = new HashMap<>();
    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int res =0;

        for(String w: words){
            int curr = 0;
            for(int i =0;i<w.length();i++){
                String sub = w.substring(0,i)+w.substring(i+1);
                curr = Math.max(curr, map.getOrDefault(sub,0)+1);
            }
            res = Math.max(res, curr);
            map.put(w, curr);
        }
        return res;
    }
    public int longestStrChainRecursion(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(int i =0;i<words.length;i++){
            map.put(words[i],i);
        }
        for(int i =words.length-1;i>=0;i--)
            max = Math.max(max,helper(words, map, i,1));
        return max;
    }

    private int helper(String[] words,Map<String,Integer> map,int j,int count){
        if(words[j].length()==1)
            return count;

        if(dp.containsKey(words[j])){
            return dp.get(words[j]);
        }

        String word = words[j];
        int curr = count;
        for(int i =0;i<word.length();i++){
            String sub = word.substring(0,i)+word.substring(i+1);
            if(map.containsKey(sub)){
                int local = 1 + helper(words, map, map.get(sub), 1);
                curr = Math.max(curr, local);
            }
        }

        dp.put(words[j],curr);
        max = Math.max(max, curr);
        return curr;
    }
}
