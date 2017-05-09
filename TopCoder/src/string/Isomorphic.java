package string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Isomorphic {
	public static void main(String[] args) {
		String s = "vikai";
		String t = "naman";
		System.out.println(new Isomorphic().isIsomorphic(s, t) ? "YES" : "NO");
	}

	public boolean isIsomorphic(String s, String t) {
		boolean ans = false;
		if (s.length() != t.length())
			return ans;

		int[] a = new int[26];
		Arrays.fill(a, -1);

		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i) - 'a';
			int tt = t.charAt(i) - 'a';
			if (a[c] != -1) {
				if(a[c]!=tt){
					return ans;
				}
			} else {
				a[c] = tt;
			}
		}
		return true;
	}
}
