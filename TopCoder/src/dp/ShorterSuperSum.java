package dp;

import java.util.Arrays;

public class ShorterSuperSum {

	public static void main(String[] args) {
		int k = 4;
		int n = 10;
		System.out.println(new ShorterSuperSum().calculate(k, n));
	}

	public int calculate(int k, int n) {
		if (k == 0)
			return n;

		int[][] dp = new int[k + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				//dp[i][j] = sum(dp, i - 1, j);
				dp[i][j] = dp[i][j-1]+dp[i-1][j];
			}
		}
		return dp[k][n];
		//return 0;
	}
}
