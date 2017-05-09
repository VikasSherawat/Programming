package visa.second;

import java.math.BigInteger;

public class C {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3,4 };
		countWays(arr);
	}

	static void countWays(int[] arr) {
		long[] a = notPermutation();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(a[arr[i]]);
		}
	}

	public static long[] notPermutation() {
		long[] count = new long[2000000+1];

		count[0] = 1;
		count[1] = 0;
		count[2] = 1;
		int M = 1000000000 + 7;

		for (int i = 3; i < count.length; i++)
			count[i] = ((i - 1) % M * (count[i - 1] + count[i - 2]) % M) % M;

		return count;
	}

}
