package mathematics;

import java.util.ArrayList;
import java.util.List;

public class Prime {
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

	public static List<Long> getPrime(long N) {
		List<Long> list = new ArrayList<Long>();
		for (long i = 2; i <= N; i++) {
			if (isprime(i))
				list.add(i);

		}

		return list;
	}

	void printPrimeNumbers(int n) {
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
		primeNumbers.add(2);
		for (int i = 3; i < n; i += 2) { // skip over even numbers since they
											// are not prime
			boolean isPrime = true;
			for (Integer prime : primeNumbers) { // check current prime numbers
													// to see if it evenly
													// divides into number
				if (i % prime == 0) { // when number is not prime
					isPrime = false;
					break; // optimization: stop checking when number is already
							// not prime
				}
			}
			if (isPrime) {
				primeNumbers.add(i);
			}
		}
		System.out.println(primeNumbers);
	}
}
