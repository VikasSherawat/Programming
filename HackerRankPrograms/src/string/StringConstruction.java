package string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StringConstruction {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String s = in.next();
            solve(s);
        }
    }
    
    private static void solve(String s){
        int count = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for(int i =1;i<s.length();i++){
          char c = s.charAt(i);
            if(s.indexOf(c)==i)
                count++;
        }
        
        System.out.println(count);
    }
}

