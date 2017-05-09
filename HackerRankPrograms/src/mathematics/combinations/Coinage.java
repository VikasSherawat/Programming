package mathematics.combinations;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Coinage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			int A = in.nextInt();
			int B = in.nextInt();
			int C = in.nextInt();
			int D = in.nextInt();
			calculate(N, A, B, C, D);
		}
	}

	private static void calculate(int N, int A, int B, int C, int D) {
		// TODO Auto-generated method stub
		long ans = 0;
		int[] ways = new int[10000];
		for (int b = 0; b <= B && 2 * b <= N; b++) {
			for (int a = 0; a <= A && a + 2 * b <= N; a++) {
				ways[a + 2 * b]++;
			}
		}

		for (int c = 0; c <= C && 5 * c <= N; c++) {
			for (int d = 0; d <= D && 5 * c + 10 * d <= N; d++) {
				ans += ways[N-5*c-10*d];
			}
		}

		System.out.println(ans);

	}

}
