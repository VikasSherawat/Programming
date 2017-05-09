package binarySearch;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SellingFruits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 15000000;
		int f = 100;
		int d = 2000000000;
		int p = 1;
		int ans = new SellingFruits().maxDays(x, f, d, p);
		System.out.println(ans);
	}

	public int maxDaysk(int x, int f, int d, int p) {
		int dollarDays = d / x;
		if (dollarDays < f) {
			return dollarDays;
		} else {
			int remainingDollars = d - f * x;
			int days = remainingDollars / (p + x);
			return f + days;
		}
	}

	public int maxDays(int x, int f, int d, int p) {
		int ans = 0;
		if (x > d) {
			return 0;
		}

		if (d / x <= f) {
			return d / x;
		}

		long lo = f, hi = d / x + 10000;
		ans = (int) lo;
		while (lo < hi) {
			long m = (long) (lo + hi) / 2;
			long days = (long) x * m + (m - f) * p;
			if (days <= d) {
				ans = (int) m;
				lo = m + 1;
			} else {
				hi = m;
			}
		}

		return ans;
	}

}
