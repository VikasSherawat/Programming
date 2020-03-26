package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterCasePermutation {
    static int count=0;

    public static void main(String[] args) {
        List<String> ans = new LetterCasePermutation().letterCasePermutation("abc");
        for(String s: ans){
            System.out.println(s);
        }
        System.out.println(count);
    }

    Set<String> ans ;
    public List<String> letterCasePermutation(String S) {
        ans= new HashSet<>();
        ans.add(S);
        backt(S.toCharArray(),0);

        return new ArrayList(ans);
    }

    private void backt(char[] arr, int idx){
        count++;
        if(idx>=arr.length)
            return;

        for(int i=idx;i<arr.length;i++){
            char c = arr[i];
            //ans.add(new String(arr));
            char[] n = Arrays.copyOf(arr,arr.length);
            if(c>=97)
                n[i]=Character.toUpperCase(c);
            else
                n[i]=Character.toLowerCase(c);
            ans.add(new String(n));
            backt(n,i+1);

        }
    }
}
