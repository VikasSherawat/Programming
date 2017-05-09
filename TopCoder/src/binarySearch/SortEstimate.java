package binarySearch;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SortEstimate {
	public static void main(String[] args) {
		double ans = new SortEstimate().howMany(1, 2000000000);
		System.out.println(ans);
		//System.out.println(1 *  * Math.log() / Math.log(2));
	}

	public double howMany(int c, int time) {
		// TODO Auto-generated method stub
		// c*n*logn
		double lo = 0.0d, hi = 1e8;
		double m = 0.0d;
		int count = 0;
		while (hi - lo > 1e-10 && count++<1e5) {
			m = lo + (hi - lo) / 2;
			double T = c * m * Math.log(m) / Math.log(2);
			//System.out.println(m);
			if (T - time > 1e-10) {
				hi = m;
			} else
				lo = m;
		}
		return m;
	}
}
