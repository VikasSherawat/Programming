import java.math.BigInteger;

public class Test {
	public static void main(String[] args) {
		System.out.println(200000000*5);
	}

	public boolean isPrime(long val) {
		if (val == 2 || val == 3) {
			return true;
		}
		if (val % 2 == 0 || val % 3 == 0) {
			return false;
		}

		long w = 2l, i = 5l;
		while (i * i <= val) {
			if (val % i == 0)
				return false;
			i += w;
			w = 6 - w;
		}

		return true;
	}
}
