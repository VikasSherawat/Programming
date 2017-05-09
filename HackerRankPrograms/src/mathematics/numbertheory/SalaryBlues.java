package mathematics.numbertheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SalaryBlues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int Q = in.nextInt();
		long[] arr = new long[N];
		
		for (int i = 0; i < N; i++) {
			long t = in.nextLong();
			arr[i] = t;
		}
		Arrays.sort(arr);
		long gcd =0;
		for (int i = 0; i < arr.length; i++) {
			gcd = findGCD(Math.max(gcd, arr[i]-arr[0]),Math.min(gcd, arr[i]-arr[0]));
		}
		for (int i = 0; i < Q; i++) {
			long t = in.nextLong();
			System.out.println(findGCD(Math.max(t+arr[0],gcd),Math.min(t+arr[0],gcd)));
		}
	}

	private static long findGCD(long a, long b) {
		// TODO Auto-generated method stub
		if(b==0)
			return a;
		return findGCD(b, a%b);
	}

}
