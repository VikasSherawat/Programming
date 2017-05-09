package binarySearch;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BearPlaysDiv2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T-->0){
			int A = in.nextInt();
			int B = in.nextInt();
			int C = in.nextInt();
			System.out.println(new BearPlaysDiv2().equalPiles(A,B,C));
		}
	}

	public String equalPiles(int A, int B, int C) {
		String s = "possible", np = "impossible";
		if ((A + B + C) % 3 != 0)
			return np;
		if (A == B && A == C)
			return s;

		int avg = (A + B + C) / 3;
		int c = 0;
		while (c++ < 10) {
			int div = 1 << c;
			int q = avg / div;
			if (q * div != avg) {
				c--;
				break;
			}
		}
		int _2p = 1 << c;
		avg /= _2p;

		if (Math.abs(A - B) == avg || Math.abs(A - C) == avg || Math.abs(B - C) == avg)
			return s;
		else
			return np;
	}
}
