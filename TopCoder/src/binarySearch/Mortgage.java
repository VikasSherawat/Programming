package binarySearch;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Mortgage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = new Mortgage().monthlyPayment(2000000000, 6000, 1);
		System.out.println(ans);
	}

	public int monthlyPayment(int L, int I, int T) {
		// TODO Auto-generated method stub
		long lo = 0l;
		long hi = Integer.MAX_VALUE;
		while (hi > lo + 1) {
			long m = (lo + hi) / 2;
			int t = 0;
			long l = L;
			while (t <= 12 * T) {
				l -= m;
				t++;
				if (l <= 0) {
					break;
				}
				l = (long)Math.ceil(l*(1d+I/12000d));
				 
			}

			if (t <= 12 * T) {
				hi = m;
			} else {
				lo = m;
			}
		}

		return (int) hi;
	}

}
