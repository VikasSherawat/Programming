package backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BeautifulArrangement {

    public static void main(String[] args) {
        int ans = new BeautifulArrangement().countArrangement(4);
        System.out.println(ans);
    }
    int count =0;
    public int countArrangement(int n) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ls.add(i);
        }
        bt(n,0, ls);
        return count;
    }

    private void bt(int n, int start, List<Integer> subset){
        if (start == n){
            count++;
        }

        for (int i = start; i < n; i++) {
            Collections.swap(subset,start,i);
            if (subset.get(start) % (start + 1) == 0 || (start + 1) % subset.get(start) == 0) {
                bt(n,start+1,subset);
            }

            Collections.swap(subset,start,i);
        }
    }
}
