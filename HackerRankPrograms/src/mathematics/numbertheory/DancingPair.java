package mathematics.numbertheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DancingPair {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			long N = in.nextLong();
			long sqrt = sqrt(N);
			System.out.println(sqrt);
			System.out.println(sqrt%2==1?"odd":"even");
		}
	}
	
	public static long sqrt(long x) {
		long lo = 0;
		long hi = 1000000000l;
		while (true) {
			long mid = (lo+hi)/2;
			if (mid*mid <= x && x < (mid+1)*(mid+1))
				return mid;
			else if (mid*mid <= x)
				lo = mid+1;
			else
				hi = mid-1;
		}
	}

}
