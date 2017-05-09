package mathematics;

import java.util.Scanner;

import sorting.FindMedian;

public class Diwali {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n= in.nextInt();
		int[] ar = new int[n];
		long[] result = new long[n];
		for (int i = 0; i < n; i++) {
			ar[i]=in.nextInt();
			result[i]= FindPattern(ar[i]);
		}
		for (long d : result) {
			System.out.println((int)d);
		}
	}

	private static long FindPattern(int i) {
		// TODO Auto-generated method stub
		long result = 1;
		for (int j = 0; j < i; j++) {
			result*=2;
			result%=100000;
		}
	return result-1;
	}

}
