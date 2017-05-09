package bruteforce;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Dubs {
	public static void main(String[] args) {
		long L = 10;
		long R = 999;

		System.out.println(new Dubs().count(L, R));
	}

	public long count(long L, long R) {
		long ans = 0l;

		long rem = L % 100l;
		L -= rem;
		rem = countInRem(--rem);
		L /= 10;
		L += rem;

		rem = R % 100l;
		R -= rem;
		R /= 10;
		rem = countInRem(rem);
		R += rem;
		ans = R - L;

		return ans;
	}

	private int countInRem(long rem) {
		// TODO Auto-generated method stub
		int ans = 0;
		for (int i = 11; i <= rem; i++) {
			if (i % 11 == 0)
				ans++;
		}
		return ans;
	}
}
