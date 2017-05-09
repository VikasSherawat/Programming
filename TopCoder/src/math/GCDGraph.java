package math;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GCDGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//147198, 114, 44121, 127576
		int n = 147198, k = 114, x = 44121, y = 127576;
		System.out.println(new GCDGraph().possible(n, k, x, y));
	}

	public String possible(int n, int k, int x, int y) {
		String p = "Possible", im = "Impossible";
		if (GCD(x, y) > k)
			return p;

		if (isPrime(x)) {
			if (n / x < 2)
				return im;
		}
		if (isPrime(y)) {
			if (n / y < 2)
				return im;
		}

		int xx = x;
		for (int i = 2; i <= n; i++) {
			if (i == xx || i==y)
				continue;
			
			if (GCD(x, i) > k) {
				x = i;
			}
			
			//check
			if (GCD(x, y) > k) {
				return p;
			}
		}

		return im;
	}

	private boolean isPrime(int y) {
		// TODO Auto-generated method stub
		if (y == 2 || y == 3)
			return true;
		if (y % 2 == 0 || y % 3 == 0)
			return false;
		int i = 5;
		int w = 2;
		for (i = 5; i * i <= y;) {
			if (y % i == 0)
				return false;

			i += w;
			w = 6 - w;
		}
		return true;
	}

	public int GCD(int a, int b) {
		int mx = Math.max(a, b);
		int mn = Math.min(a, b);

		if (mn == 0)
			return mx;
		else
			return GCD(mn, mx % mn);
	}

}
