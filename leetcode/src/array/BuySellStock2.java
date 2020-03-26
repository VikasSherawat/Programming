package array;

import java.util.Stack;

public class BuySellStock2 {
    //{7,1,5,3,6,4}

    public int maxProfit(int[] prices) {
        int profit =0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }

    public void moveZeroes(int[] nums) {
        int j =0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[j]=nums[i];
                if(i!=j)
                    nums[i]=0;
                j++;
            }
        }
    }
}
