package binarySearch;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class UnionOfIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lower = { 1,5 };
		int[] upper = { 3,7};
		int n = 4;
		int ans = new UnionOfIntervals().nthElement(lower, upper, n);
		System.out.println(ans);
	}

	public int nthElement(int[] lower, int[] upper, int n) {
		// TODO Auto-generated method stub

		int lo = Integer.MIN_VALUE, hi = Integer.MAX_VALUE;
		int ss = 0;
		while (lo < hi) {
			ss++;
			int X = (int) (((long) lo + hi + 1) / 2);
			long count = 0;
			for (int i = 0; i < lower.length; ++i) {
				if (X >= lower[i] && X <= upper[i]) {
					// part of interval i is less than X
					count += (long) X - lower[i];
				}
				if (X >= lower[i] && X > upper[i]) {
					// all numbers in interval i are less than X
					count += (long) upper[i] - lower[i] + 1;
				}
			}

			if (count <= n)
				lo = X;
			else
				hi = X - 1;
		}
		System.out.println(ss);
		return lo;
	}

}
