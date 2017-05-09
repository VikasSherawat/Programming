package dynamicProgramming;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Abbreviation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			String a = in.next();
			String b = in.next();
			if (LCS(a.toLowerCase(), b.toLowerCase()) == b.length()) {
				int len = check(a, b);
				if (len != -1) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}else{
				System.out.println("NO");
			}
		}
	}

	private static int check(String a, String b) {
		// TODO Auto-generated method stub
		int[] barr = new int[255];
		for (int i = 0; i < b.length(); i++) {
			int c = b.charAt(i);
			barr[c]++;
		}

		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			if (Character.isUpperCase(c)) {
				if (barr[(int) c] > 0) {
					barr[(int) c]--;
				} else {
					return -1;
				}
			}
		}

		for (int i = 0; i < a.length(); i++) {

		}
		return 0;

	}

	public static int LCS(String a, String b) {
		// TODO Auto-generated method stub
		int[][] lcs = new int[b.length() + 1][a.length() + 1];
		for (int i = 1; i < lcs.length; i++) {
			int len = lcs[i].length;
			for (int j = 1; j < len; j++) {
				char ac = a.charAt(j - 1);
				char bc = b.charAt(i - 1);
				if (ac == bc) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}
		return lcs[lcs.length - 1][lcs[0].length - 1];
	}
}
