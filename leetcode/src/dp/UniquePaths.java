package dp;

import java.util.Arrays;

public class UniquePaths {
    int[][] dp;

    public static void main(String[] args) {
        int ans = new UniquePaths().uniquePaths(3,3);
        System.out.println(ans);
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        return dfs(m,n, m-1,n-1);
    }

    private int dfs(int m, int n, int r, int c){
        if(r==0 || c==0)
            return 1;

        if(r<0 || c<0 || r>=m || c>=n){
            return 0;
        }

        if(dp[r][c]!=0){
            return dp[r][c];
        }

        return dp[r][c] = dfs(m,n, r-1, c ) + dfs(m,n, r, c-1);
    }
}
