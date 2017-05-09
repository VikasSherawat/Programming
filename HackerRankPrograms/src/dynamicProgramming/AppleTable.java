package dynamicProgramming;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AppleTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = in.nextInt();
			}
		}

		solve(arr);

	}

	private static void solve(int[][] arr) {
		// TODO Auto-generated method stub
		int N = arr.length;
		int M = arr[0].length;
		int[][] dp = new int[N][M];
		// dp[0][0] = arr[0][0];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i != 0 && j != 0) {
					dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
				} else if (i == 0 && j != 0) {
					dp[i][j] = arr[i][j] + Math.max(0, dp[i][j - 1]);
				} else if (i != 0 && j == 0) {
					dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j],0);
				} else {
					dp[i][j] = arr[i][j];
				}

			}
		}
		
		System.out.println(dp[N-1][M-1]);
	}

}
