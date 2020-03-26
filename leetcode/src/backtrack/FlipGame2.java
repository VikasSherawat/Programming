package backtrack;

import java.util.Arrays;
import java.util.HashMap;

public class FlipGame2 {

    static int count =0;
    static int cache=0;
    public static void main(String[] args) {
        String s = "++++++++++++++";
        StringBuilder sb = new StringBuilder("934");
        int ans = sb.charAt(0)-'0';
        int[] a = {};
        Arrays.asList(a);
        System.out.println(ans);
    }
    public boolean canWin(String s) {
        HashMap<String, Boolean> h = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.deleteCharAt(sb.length()-1);
        return canWin(s.toCharArray(), h);
    }

    private boolean canWin(char[] c, HashMap<String, Boolean> h) {
        for (int i = 1; i < c.length; i++) {
            count++;
            if (c[i] == '+' && c[i - 1] == '+') {
                c[i] = '-';
                c[i - 1] = '-';

                boolean t;
                String key = String.valueOf(c);
                if (!h.containsKey(key)) {
                    t = canWin(c, h);
                    h.put(key, t);      //System.out.println(key + " --> " + t);
                } else {
                    cache++;
                    t = h.get(key);     //System.out.println(key + " ==> " + t);
                }   // can not directly use if (t) return true here, cuz you need to restore

                c[i] = '+';
                c[i - 1] = '+';
                if (!t) return true;
            }
        }
        return false;
    }
}
