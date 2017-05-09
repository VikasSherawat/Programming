package week27;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Hackonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int Q = in.nextInt();
		int[] arr = printHacko(20000);
		while (Q-- > 0) {
			int angle = in.nextInt();
		}

		printHacko(N);
	}

	private static int[] printHacko(int n) {
		// TODO Auto-generated method stub
		BigInteger[] a = new BigInteger[n + 1];
		int[] arr = new int[n+1];
		BigInteger two = BigInteger.valueOf(2);
		BigInteger th = BigInteger.valueOf(3);
		a[1] = BigInteger.ONE;
		a[2] = two;
		a[3] = th;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		BigInteger nn = BigInteger.valueOf(n);

		for (BigInteger i = BigInteger.valueOf(4); i.compareTo(nn) <= 0;) {
			BigInteger sum = a[i.subtract(BigInteger.ONE).intValue()];
			sum = sum.add(two.multiply(a[i.subtract(two).intValue()]));
			sum = sum.add(th.multiply(a[i.subtract(th).intValue()]));
			a[i.intValue()] = sum.remainder(two).compareTo(BigInteger.ZERO) == 0 ? BigInteger.ZERO
					: BigInteger.ONE;

			a[i.intValue()] = a[i.intValue()];
			i = i.add(BigInteger.ONE);
		}
		
		return arr;
	}

}
