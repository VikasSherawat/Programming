package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BraceExpansion {

    public static void main(String[] args) {
        String[] ans = new BraceExpansion().expand("{a,b}c{d,e}f");
        System.out.println(Arrays.toString(ans));
    }
    public String[] expand(String S) {
        int n = S.length();
        if (n == 0) {
            return new String[]{""};
        }
        if (n == 1) {
            return new String[]{S};
        }
      List<String> res = new ArrayList<>();
        if(S.charAt(0)=='{'){
            int i = 1;
         while(S.charAt(i++)!='}'){
         }
         String[] left = S.substring(1,i-1).split(",");
         String[] right = expand(S.substring(i));
         for(String l: left){
             for(String r: right){
                 res.add(l+r);
             }
         }
        }else{
            String[] right = expand(S.substring(1));
            for(String r: right){
                res.add(S.charAt(0)+r);
            }
        }
        Collections.sort(res);
        return res.toArray(new String[0]);
    }
}
