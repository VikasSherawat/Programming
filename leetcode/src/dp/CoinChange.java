package dp;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        if (len == 0 || amount == 0)
            return 0;
        int[][] dp = new int[len][amount + 1];

        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = i % coins[0] == 0 ? i / coins[0] : amount + 1;
        }

        for (int i = 1; i < len; i++) {
            int c = coins[i];
            for (int j = 1; j <= amount; j++) {
                if (c > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - c]);
                }
            }
        }

        return dp[len - 1][amount] == amount + 1 ? -1 : dp[len - 1][amount];
    }
}
