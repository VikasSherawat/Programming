package implementations;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AppendDelete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int slen = s.length();
		String t = in.next();
		int tlen = t.length();
		int K = in.nextInt();
		int index = 0, i = 0;

		for (i = 0; i < slen && i < t.length(); i++) {
			index = i;
			if (s.charAt(i) == t.charAt(i)) {
				continue;
			} else {
				break;
			}
		}
		if (i!=tlen) {
			int remove = slen -index;
			if(slen > tlen){
				equal(slen - remove, tlen, K - remove);
			}else if(slen<tlen){
				append(slen,tlen,K);
			}else{
				append(slen-remove, tlen, K-remove);
			}
		} else {
			if (slen == tlen) {
				equal(slen, tlen, K);
			} else if (slen > tlen) {// remove character then append
				int remove = slen - tlen;
				equal(slen - remove, tlen, K - remove);
			} else { // append character
				append(slen, tlen, K);
			}
		}

	}

	public static void equal(int slen, int tlen, int K) {
		if (K % 2 == 0) {
			System.out.println("Yes");
		} else {
			if (K / 2 >= slen) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}

	public static void append(int slen, int tlen, int K) {
		if (K < tlen - slen) {
			System.out.println("No");
		} else {
			if (K == tlen - slen)
				System.out.println("Yes");
			else {
				if ((K - tlen - slen) % 2 == 0 || K >= slen + tlen) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}
	}

}
