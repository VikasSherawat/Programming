package contest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class _4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int i = 143;i<1000;i++){
			for (int j = 100; j <1000 ; j++) {
				int p = i*j;
				if(isPallindrome(String.valueOf(p))){
					set.add(p);
				}
			}
		}
		
		while(T-->0){
			int n = in.nextInt();
			System.out.println(set.lower(n));
		}
	}

	private static boolean isPallindrome(String s) {
		// TODO Auto-generated method stub
		int n = s.length();
		for(int i =0;i<s.length()/2;i++){
			if(s.charAt(i)!=s.charAt(n-1-i)){
				return false;
			}
		}
		return true	;
	}



	

}
