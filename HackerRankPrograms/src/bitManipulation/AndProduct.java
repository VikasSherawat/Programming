package bitManipulation;

import java.io.*;
import java.util.*;

public class AndProduct {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			long A = in.nextLong();
			long B = in.nextLong();
			solve(A, B);
			getPowers(A, B);
		}
	}

	private static void solve(long a, long b) {
		// TODO Auto-generated method stub
		long pro = a;
		for (long i = a + 1; i <= b; i++) {
			pro &= i;
		}
		 System.out.println(pro);
	}

	private static void getPowers(long a, long b) {
		long ap = 1, bp = 1;
		while (Math.pow(2, ap) <= a)
			ap += 1;
		ap--;
		while (Math.pow(2, bp) <= b)
			bp += 1;
		bp--;
		if (ap != bp)
			System.out.println(0);
		else {
			long pro = a;
			for (long i = a + 1; i <= b; i+=2) {
				pro &= i;
			}
			System.out.println(pro);
		}

	}
}
