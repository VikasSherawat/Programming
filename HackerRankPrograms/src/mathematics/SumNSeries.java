package mathematics;

import java.math.BigInteger;
import java.util.Scanner;

public class SumNSeries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] ar = new long[n];
		BigInteger[] op = new BigInteger[n];
		for (int i = 0; i < ar.length; i++) {
			ar[i]=in.nextLong();
			op[i]=findSum(BigInteger.valueOf(ar[i]));
		}
		for (BigInteger i : op) {
			System.out.println(i);
		}
	}

	private static BigInteger findSum(BigInteger i) {
		// TODO Auto-generated method stub
		i = i.multiply(i);
		return i.mod(BigInteger.valueOf(1000000007));
	}

}
