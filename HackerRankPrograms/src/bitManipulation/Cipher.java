package bitManipulation;

import java.util.*;


public class Cipher {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		String S = in.next();
		solve(N, K, S);

	}

	private static void solve(int n, int k, String s) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(0));
		// int count = countOne(s, k);
		boolean lcount = s.charAt(0) == '1' ? true : false;
		for (int i = 1; i < n - 1; i++) {
			char c = s.charAt(i);
			if (i < k) {
				if (c == '1') { // means odd number of one till now
					if (lcount) {
						sb.append(0);
					} else {
						sb.append(1);
						lcount = !lcount;
					}
				} else {// when current char is 0
					if (lcount) {
						sb.append(1);
						lcount = !lcount;
					} else {
						sb.append(0);
					}
				}
			} else { // when i > k
				char t = sb.charAt(i - k);
				if (t == '1') {
					lcount = !lcount;
				}
				if (c == '1') {
					if (lcount) {
						sb.append(0);
					} else {
						sb.append(1);
						lcount = !lcount;
					}
				} else {
					if (lcount) {
						sb.append(1);
						lcount = !lcount;
					} else {
						sb.append(0);
					}
				}
			}
		}
		sb.append(s.charAt(s.length() - 1));
		System.out.println(sb.toString());
	}

}
