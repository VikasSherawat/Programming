package string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NonDeterministicSubstring {
	public static void main(String[] args) {
		String A = "11110";
		String B = "?";
		System.out.println(new NonDeterministicSubstring().ways(A, B));
	}

	public long ways(String A, String B) {
		long ans = 0l;
		char q = '?';
		HashSet<String> set = getHashSet(A, B.length());
		Iterator<String> iter = set.iterator();
		for (;iter.hasNext();) {
			String s = iter.next();
			boolean flag = true;
			for (int k = 0; k < B.length(); k++) {
				if (B.charAt(k) == q) {
					continue;
				} else if (s.charAt(k) != B.charAt(k)) {
					flag = false;
					break;
				}
			}
			if (flag)
				ans++;
		}
		return ans;
	}

	private HashSet<String> getHashSet(String s, int length) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i <= s.length()-length; i ++) {
			set.add(s.substring(i, i + length));
		}
		return set;
	}
}
