package dp;

import java.util.Arrays;

public class HouseRobber {
    int[] dp;
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        else if(nums.length==1)
            return nums[0];
        else if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        else{
            int[] r = new int[nums.length];
            r[0] = nums[0]; r[1]=Math.max(r[0],nums[1]);
            int max = Math.max(nums[0],nums[1]);
            for(int i =2;i<nums.length;i++){
                r[i] = Math.max(nums[i]+r[i-2],r[i-1]);
                max = Math.max(max, r[i]);
            }

            return max;
        }

    }


    public int robRecursive(int[] nums) {
        if(nums==null ||nums.length==0)
            return 0;

        if(nums.length==1)
            return nums[0];

        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        int ans = recursive(nums,nums.length-1);
        return ans;
    }


    private int recursive(int[] c, int i){
        if(i<2){
            return dp[i];
        }

        if(dp[i]!=-1)
            return dp[i];

        dp[i] = Math.max(recursive(c,i-1),c[i]+recursive(c, i-2));
        return dp[i];
    }
}
