package dp;

import java.util.Arrays;

public class KnapSnack01 {
    public static void main(String[] args) {
        int[] n = {1,5,11,5};
        System.out.println(new KnapSnack01().canPartition(n));
    }
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int n: nums){
            sum+= n;
        }

        if(sum%2==1)
            return false;

        sum /=2;
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i =0;i<=n;i++){
            dp[i][0]=true;
        }
        Arrays.sort(nums);

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=sum;j++){
                if(nums[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}
