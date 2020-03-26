package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javafx.util.Pair;

public class WordLadder {
    public static void main(String[] args) {
        List<String> d  = Arrays.asList("hot","dot","dog","lot","log","cog");
        int ans = new WordLadder().ladderLength("hit","cog",d);
        System.out.println(ans);
    }
    public int ladderLength(String begin, String end, List<String> dict) {
        if(!dict.contains(end)){
            return 0;
        }
        Map<String, List<String>> combo = new HashMap<>();
        int len = end.length();

        dict.forEach(word->{
            for(int i =0;i<len;i++){
                String newWord = word.substring(0,i) + "*"+word.substring(i+1);
                List<String> ls = combo.getOrDefault(newWord, new ArrayList<>());
                ls.add(word);
                combo.put(newWord, ls);
            }
        });

        LinkedList<Pair<String, Integer>> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.add(new Pair(begin,1));
        set.add(begin);
        while(!q.isEmpty()){
            Pair<String, Integer> pair = q.removeFirst();
            String word  = pair.getKey();
            int level = pair.getValue();
            for(int i =0;i<len;i++){
                String w = word.substring(0,i) + "*"+word.substring(i+1);
                for(String s: combo.getOrDefault(w, new ArrayList<>())){
                    if(s.equals(end)){
                        return level + 1;
                    }

                    if(!set.contains(s)){
                        q.addLast(new Pair<>(s, level+1));
                        set.add(s);
                    }

                }
            }
        }
        return 0;
    }
}
