package bruteforce;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DistinguishableSetDiv2 {
	public static void main(String[] args) {
		String[] answer = { "XYZ","XAB","YAC"};
		System.out.println(new DistinguishableSetDiv2().count(answer));
	}

	public int count(String[] answer) {
		int ans = 0;
		int r = answer.length, c = answer[0].length();
		long L = 1 << c;
		for (int i = 0; i < L; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < c; j++) {
				int k = 1<<j;
				int nn = (i & k);
				if (nn > 0) {
					sb.append(j);
				}
			}
			if (sb.length()>0 && unique(sb.toString().toCharArray(), answer)) {
				ans++;
			}
		}
		return ans;
	}

	private boolean unique(char[] a, String[] answer) {
		// TODO Auto-generated method stub
		Arrays.sort(a);
		HashSet<String> set = new HashSet<String>();
		for (int j = 0; j < answer.length; j++) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < a.length; i++) {
				sb.append(answer[j].charAt(Character.getNumericValue(a[i])));
			}

			if (set.contains(sb.toString())) {
				return false;
			} else {
				set.add(sb.toString());
			}
		}
		return true;
	}

}
