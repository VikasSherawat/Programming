package mathematics.numbertheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MansaFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] arr = { 0, 5, 10, 15, 20 };

		while (T-- > 0) {
			long N = in.nextLong();
			if (N <= 4) {
				System.out.println(arr[(int) N]);
				continue;
			}
			solve(N);
		}
	}

	private static void solve(long n) {
		// TODO Auto-generated method stub
		long L = 0, R = 5 * n;
		while (R - L > 1) {
			long M = L + R >> 1;
			long cnt =pcount(5, M);
			if (cnt < n)
				L = M;
			else
				R = M;
		}
		System.out.println(R);
	}

	private static long pcount(int p, long n) {
		// TODO Auto-generated method stub
		if (n < p)
			return 0;
		return n / p + pcount(p, n / p);
	}

}
