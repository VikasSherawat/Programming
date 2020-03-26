package dp;

import java.util.Arrays;

public class ClimbingStairs {
    int[] dp;

    public static void main(String[] args) {
        int[] a = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new ClimbingStairs().minCostClimbingStairsRecursive(a));
    }
    public int minCostClimbingStairs(int[] cost) {
        if(cost==null || cost.length==0){
            return 0;
        }
        if(cost.length==1)
            return cost[0];
        if(cost.length==2)
            return Math.min(cost[0],cost[1]);

        int[] dp = new int[cost.length];
        dp[0] = cost[0]; dp[1]=cost[1];

        for(int i = 2;i<cost.length;i++){
            dp[i]=Math.min(cost[i]+dp[i-2], cost[i]+dp[i-1]);
        }

        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }

    public int minCostClimbingStairsRecursive(int[] cost) {
        if(cost==null || cost.length==0){
            return 0;
        }
        if(cost.length==1)
            return cost[0];
        dp = new int[cost.length];
        Arrays.fill(dp,-1);
        dp[0]=cost[0];
        dp[1]=cost[1];
        int n = cost.length;
        int ans = recurse(cost,cost.length-1);
        return Math.min(dp[n-1],dp[n-2]);
    }

    private int recurse(int[] cost, int index) {
        if(index<=1){
            return dp[index];
        }

        if(dp[index]!=-1){
            return dp[index];
        }

        dp[index]= cost[index]+Math.min(recurse(cost,index-1),recurse(cost,index-2));
        return dp[index];
    }

}
