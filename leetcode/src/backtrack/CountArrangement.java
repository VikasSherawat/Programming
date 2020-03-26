package backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountArrangement {
    static List<List<Integer>> superset = new ArrayList<>();
    static int count =0;

    public static void main(String[] args) {
        int ans = new CountArrangement().countArrangement(7);
        System.out.println(ans);
        System.out.println(count);
    }
    public int countArrangement(int n) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ls.add(i);
        }
        bt(n,0, ls);
        return superset.size();
    }

    private void bt(int n, int start, List<Integer> subset){
        count++;
        if (start == n){
            if(beautiful(subset))
                superset.add(new ArrayList<>(subset));
        }

        for (int i = start; i < n; i++) {
            Collections.swap(subset,start,i);
            bt(n,start+1,subset);
            Collections.swap(subset,start,i);
        }
    }

    private boolean beautiful(List<Integer> subset) {
        for (int i = 0; i < subset.size(); i++) {
            if (subset.get(i) % (i + 1) != 0 && (i + 1) % subset.get(i) != 0) {
                return false;
            }
        }
        return true;
    }
}
