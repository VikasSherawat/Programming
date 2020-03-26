package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] a = {" "," "};

        List<List<String>> ans = new GroupAnagram().groupAnagrams(a);
        for(List<String> ls: ans){
            System.out.println(Arrays.toString(ls.toArray()));
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs.length == 1) {
            List<String> ls = new ArrayList<>();
            ls.add(strs[0]);
            ans.add(ls);
            return ans;
        }

        Map<Integer, Integer> anagrams = new HashMap<>();
        Dsu dsu = new Dsu(strs.length);
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram(strs[i], strs[j])) {
                    dsu.union(i, j);
                    int pi = dsu.find(j);
                    anagrams.put(i, pi);
                    anagrams.put(j, pi);
                } else {
                    if (!anagrams.containsKey(i)) {
                        anagrams.put(i, dsu.find(i));
                    }
                    if (!anagrams.containsKey(j)) {
                        anagrams.put(j, dsu.find(j));
                    }
                }

            }
        }
        Map<Integer, List<String>> map = new HashMap<>();
        for (Map.Entry<Integer, Integer> m1 : anagrams.entrySet()) {
            Integer key = m1.getKey();
            Integer value = m1.getValue();
            map.computeIfAbsent(value, a -> new ArrayList<>()).add(strs[key]);
        }

        for (List<String> ls : map.values()) {
            ans.add(new ArrayList<>());
            for (String st : ls) {
                ans.get(ans.size() - 1).add(st);
            }
        }

        return ans;

    }

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        boolean ans = false;
        Map<Character, Integer> fr = new HashMap<>();

        for (char c : t.toCharArray()) {
            fr.put(c, fr.getOrDefault(c, 0) + 1);
        }
        int count = t.length();
        for (char c : s.toCharArray()) {
            if (!fr.containsKey(c) || fr.get(c) == 0) {
                return false;
            }
            count--;
            fr.put(c, fr.get(c) - 1);
        }
        return true;
    }
}


class Dsu {
    int[] parent;

    public Dsu(int size) {
        parent = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            return find(parent[x]);
        } else {
            return x;
        }
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}
