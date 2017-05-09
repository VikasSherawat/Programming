package string;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by vikas on 9/5/17.
 */
public class MakePalindrome {

    public static void main(String[] args){
        String card = "aaabbbccc";
        String[] a = new MakePalindrome().constructMinimal(card);
        System.out.println(a.length);
        for(String s:a){
            if(s.length()>0)
                System.out.println(s);
        }
    }

    public String[] constructMinimal(String card){
        List<String> list = new ArrayList<>();
        ConcurrentHashMap<Character,Integer> map = new ConcurrentHashMap<>(getMap(card));
        char  alone = 'A';
        while(map.size()>0) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Character, Integer> m : map.entrySet()) {
                char c = m.getKey();
                int val = m.getValue();
                if(val == 1 ) {
                    if(alone=='A')
                        alone = c;
                    else{
                        list.add(String.valueOf(c));
                        map.remove(c);
                    }
                } else {
                    int times = val/2;
                    if(val%2==0){
                        map.remove(c);
                    }else{
                        if(alone=='A')
                            alone = c;
                        map.put(c, 1);
                    }
                    for (int i = 0; i < times; i++) {
                        sb.append(c);
                    }
                }
            }
            if(sb.length()>0) {
                String rev = sb.toString();
                if (alone != 'A' && alone != '?') {
                    rev = rev + alone;
                    map.remove(alone);
                    alone = '?';
                }
                list.add(rev + sb.reverse().toString());
            }

        }


        return getArray(list);
    }

    private HashMap<Character, Integer> getMap(String card) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < card.length(); i++) {
            char c = card.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }

        return map;
    }

    private String[] getArray(List<String> list) {
        String[] a = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }

        return a;
    }
}
