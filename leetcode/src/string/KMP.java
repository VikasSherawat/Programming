package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class KMP {
    public int strStr(String str, String pattern) {
        if(pattern.length()==0)
            return 0;
        int[] pi = preparePI(pattern);
        int j =0, index =-1;
        for (int i = 0; i < str.length();) {
            if(str.charAt(i)==pattern.charAt(j)){
                j++;
                i++;
                if(j==pi.length){
                    index = i-1;
                    break;
                }
            }else{
                if(j==0){
                    i++;
                }else{
                    j = pi[j-1];
                }
            }


        }
        return index==-1?-1:index+1-pattern.length();
    }

    private int[] preparePI(String pattern) {
        int[] pi = new int[pattern.length()];
        int k =0;
        for(int i =1;i<pattern.length();){
            if(pattern.charAt(i)==pattern.charAt(k)){
                pi[i]=k+1;
                k++;
                i++;
            }else{
                if(k==0)
                    i++;
                else
                    k=pi[k-1];
            }
        }
        return pi;
    }

    public static void main(String[] args) {
        String s = "ababcabcabababd", p = "ababd";
        int ans = new KMP().strStr(s,p);
        System.out.println(ans);
        System.out.println(s.indexOf(p));
    }
}
