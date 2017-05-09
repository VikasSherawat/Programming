package bitManipulation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class XoringNinja {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while (cases-- > 0) {
			int n = sc.nextInt();
			long sum = 0;
			for (int i = 0; i < n; i++) {
				int t = sc.nextInt();
				sum |= t;
			}
			System.out.println(sum);
			long tt = modPow(n - 1) % 1000000007;
			sum = (tt * (sum % 1000000007)) % 1000000007;
			System.out.println(sum);
		}
	}

	static long modPow(int n) {
		if (n == 0)
			return 1;
		if (n % 2 == 0) {
			long x = modPow(n / 2);
			return (x % 1000000007 * x % 1000000007) % 1000000007;
		} else {
			return 2 * modPow(n - 1) % 1000000007;
		}
	}
}
