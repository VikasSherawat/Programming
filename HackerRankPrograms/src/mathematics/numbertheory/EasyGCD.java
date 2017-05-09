package mathematics.numbertheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EasyGCD {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		int gc = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
			gc = gcd(Math.max(arr[i], gc), Math.min(arr[i], gc));
		}

		int rem = k % gc;
		
			List<Integer> prime = findFactor(gc, getPrime(5000));
			rem = Integer.MAX_VALUE;
			for (int i = 0; i < prime.size() && prime.get(i) <= k; i++) {
				rem = (int) Math.min(k % prime.get(i), rem);
				if (rem == 0)
					break;
			}
			
			rem = Math.min(rem, k%gc);
			System.out.println(rem == Integer.MAX_VALUE ? 0 : k - rem);
		

	}

	private static List<Integer> findFactor(long N, List<Long> prime) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < prime.size() && prime.get(i) <= N; i++) {
			long item = prime.get(i);
			if (N % item != 0)
				continue;
			list.add((int) item);
			while (N % item == 0) {
				N /= item;
			}
		}
		return list;
	}

	static boolean isprime(long n) {
		// """Returns true; if n is prime."""
		if (n == 2)
			return true;
		if (n == 3)
			return true;
		if (n % 2 == 0)
			return false;
		if (n % 3 == 0)
			return false;

		long i = 5l;
		long w = 2l;

		while (i * i <= n) {
			if (n % i == 0)
				return false;

			i += w;
			w = 6 - w;
		}

		return true;
	}

	public static List<Long> getPrime(long N) {
		List<Long> list = new ArrayList<Long>();
		for (long i = 2; list.size() != N; i++) {
			if (isprime(i))
				list.add(i);

		}

		return list;
	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}
}
