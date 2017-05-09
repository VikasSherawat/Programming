package mathematics;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Euler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int A = in.nextInt();
			int M = in.nextInt();
			long res = A == 0 || A == 1 ? 1 : modpow(A, (M - 1) / 2, M);
			System.out.println(res == 1 ? "YES" : "NO");
		}
	}

	static long modpow(long base_value, long exponent, long modulus) {
		base_value = base_value % modulus;
		long result = 1;
		while (exponent > 0) {
			if (exponent % 2 == 1)
				result = (result * base_value) % modulus;
			base_value = (base_value * base_value) % modulus;
			exponent = exponent / 2;
		}
		return result;
	}

}
