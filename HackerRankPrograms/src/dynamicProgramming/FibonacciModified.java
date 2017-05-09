package dynamicProgramming;

import java.math.BigInteger;
import java.util.*;
public class FibonacciModified {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		long A = in.nextLong(),B=in.nextLong(),N=in.nextLong();
		BigInteger output;
		
		output = findTerm(A,B,N);
		System.out.println(output);
	}

	private static BigInteger findTerm(long a, long b, long n) {
		// TODO Auto-generated method stub
		BigInteger[] ar = new BigInteger[(int)n];
		ar[0]=BigInteger.valueOf(a);
		ar[1]=BigInteger.valueOf(b);
		for (int i = 2; i < n; i++) {
		
			ar[i] = ar[i-1].multiply(ar[i-1]).add(ar[i-2]);
		}
		return ar[(int)n-1]; 
	}

}
