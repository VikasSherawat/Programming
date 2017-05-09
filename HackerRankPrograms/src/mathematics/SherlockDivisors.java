package mathematics;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockDivisors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> prime = getPrime(100000);
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			int res = N % 2 == 1 ? 0 : findEvenDiv(N, prime);
			System.out.println(res);
		}
	}

	public static int findEvenDiv(int n, List<Integer> prime) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < prime.size(); i++) {
			while (n % prime.get(i) == 0) {
				n = n / prime.get(i);
				if (map.containsKey(prime.get(i))) {
					map.put(prime.get(i), map.get(prime.get(i)) + 1);
				} else {

					map.put(prime.get(i), 1);
				}

			}
		}
		if(n!=1){
			BigInteger big = BigInteger.valueOf(n);
			if(big.isProbablePrime(10))
				map.put(big.intValue(), 1);
		}
		int count = 0;
		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			int key = m.getKey();
			int value = m.getValue();
			if (key == 2)
				count = value;
			else {
				count = count * (value+1);
			}

		}

		return count;
	}

	public static boolean isprime(long n) {
		// """Returns true; if n is prime."""
		if (n == 2)
			return true;
		if (n == 3)
			return true;
		if (n % 2 == 0)
			return false;
		if (n % 3 == 0)
			return false;

		int i = 5;
		int w = 2;

		while (i * i <= n) {
			if (n % i == 0)
				return false;

			i += w;
			w = 6 - w;
		}

		return true;
	}

	public static List<Integer> getPrime(int N) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i <= N; i++) {
			if (isprime(i))
				list.add(i);

		}

		return list;
	}
}
