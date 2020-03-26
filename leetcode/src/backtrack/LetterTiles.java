package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterTiles {

   static List<List<Character>> set = new ArrayList<>();

    public static void main(String[] args) {
        int ans = new LetterTiles().numTilePossibilities("AAB");
        for(List<Character> a: set){
            System.out.println(Arrays.toString(a.toArray()));
        }
        System.out.println(ans);
        boolean[] v = new boolean[3];
        Arrays.copyOf(v,v.length);

    }

    public int numTilePossibilities(String tiles) {
        dfs(tiles.toCharArray(), 0, new ArrayList<>());
        return set.size();
    }

    private void dfs(char[] arr, int start, List<Character> ls) {
        set.add(new ArrayList<>(ls));
        for (int i = start; i < arr.length; i++) {
            if(i > start && arr[i] == arr[i-1])
                continue;
            ls.add(arr[i]);
            dfs(arr, i + 1, ls);
            ls.remove(ls.size() - 1);
        }
    }
}
