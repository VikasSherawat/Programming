package contest;

import java.math.BigInteger;
import java.util.*;

public class Euler3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		long result[] = new long[T];
		int index = 0;
		// ArrayList<Integer> list = getPrimeNumbers(100000);
		while (T-- > 0) {
			long N = in.nextLong();
			result[index++] = findLargestPrime(N);
		}
		for (long i : result) {
			System.out.println(i);
		}
	}

	private static long findLargestPrime(long n) {
		// TODO Auto-generated method stub
		if (BigInteger.valueOf(n).isProbablePrime(11)) {
			return n;
		} else {
			long ans = 0l;
			while (n % 2 == 0) {
				n /= 2;
				ans = 2;
			}
			for (int i = 3; i * i <= n; i += 2) {
				while (n % i == 0) {
					n /= i;
					ans = i;
				}
			}
			if (n > ans)
				ans = n;

			return ans;
		}
	}

}