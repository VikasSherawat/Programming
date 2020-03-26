package dp;

import java.util.Arrays;

public class OutOfBoundary {
    int[][][] dp ;
    int m;
    int n;
    int mod = 1000000007;
    public int findPaths(int m, int n, int N, int p, int q) {
        dp = new int[m][n][N+1];
        this.m = m;
        this.n = n;

        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                Arrays.fill(dp[i][j],-1);

            }
        }
        return fn(N,p,q);
    }

    private int fn(int N, int i, int j){
        if(i<0 || j<0 || i>=this.m || j>=this.n){
            return 1;
        }

        if(N<=0){
            return 0;
        }


        if(dp[i][j][N]!=-1){
            return dp[i][j][N]%mod;
        }

        int ans = fn(N-1, i+1,j)%mod;
        ans = (ans + fn(N-1, i,j+1))%mod;
        ans = (ans + fn(N-1, i-1,j))%mod;
        ans = (ans + fn(N-1, i,j-1))%mod;

        return dp[i][j][N] = ans;
    }
    public static void main(String[] args) {
        System.out.println(new OutOfBoundary().findPaths(2,2,2,0,0));
    }
}
