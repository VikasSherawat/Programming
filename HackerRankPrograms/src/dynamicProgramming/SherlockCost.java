package dynamicProgramming;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockCost {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = in.nextInt();
			}
			SherlockCost c = new SherlockCost();
			c.solve(arr, N);
		}
	}

	private void solve(int[] ar, int N) {
		// TODO Auto-generated method stub
		long[][] dp = new long[N][2];
		for (int i = 0; i < N - 1; i++) {
			dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + Math.abs(ar[i] - 1)); // if we choose the element as 1
			dp[i + 1][1] = Math.max(dp[i][0] + Math.abs(ar[i + 1] - 1), dp[i][1] + Math.abs(ar[i] - ar[i + 1]));
		}
		System.out.println(Math.max(dp[N - 1][0], dp[N - 1][1]));
	}

}
