package dp;

import java.util.Arrays;
import java.util.TreeSet;

public class MiniCostFromLeafValues {
    public static void main(String[] args) {
        int[] a = {6,2,4};
        int ans = new MiniCostFromLeafValues().mctFromLeafValues(a);
        System.out.println(ans);
    }

    public int mctFromLeafValuesBottomUp(int[] arr) {
        int len = arr.length;
        int[][] max = new int[len][len];
        int[][] dp = new int[len][len];

        for(int i =0;i<len;i++){
            for(int j = i;j<len;j++){
                if(i==j)
                    max[i][j] = arr[j];
                else
                    max[i][j] = Math.max(arr[j],max[i][j-1]);
            }
        }

        for(int part = 1;part<len;part++){
            for(int left = 0;left<len-part;left++){
                int right = part+left;
                dp[left][right] = Integer.MAX_VALUE;
                if(len==1){
                    dp[left][right] = arr[left] * arr[right];
                }else{
                    for(int k = left;k<right;k++){
                        dp[left][right] = Math.min(dp[left][right],
                                max[left][k] * max[k+1][right] + dp[left][k] + dp[k+1][right] );
                    }
                }
            }
        }
        return dp[0][len-1];

    }
    public int mctFromLeafValues(int[] arr) {
        int len = arr.length;
        int[][] max = new int[len][len];
        int[][] dp = new int[len][len];

        for(int i =0;i<len;i++){
            for(int j = i;j<len;j++){
                if(i==j)
                    max[i][j] = arr[j];
                else
                    max[i][j] = Math.max(arr[j],max[i][j-1]);
            }
        }
        for(int i = 0;i<len;i++){
            Arrays.fill(dp[i],-1);
        }

        return fn(0,len-1,arr, dp, max);

    }

    private int fn(int start, int end, int[] arr, int[][] dp, int[][] max){
        if(start==end){
            return 0;
        }

        if(dp[start][end]!=-1){
            return dp[start][end];
        }

        int ans = Integer.MAX_VALUE;
        for(int i = start;i<end;i++){
            int left = fn(start,i,arr,dp,max);
            int right = fn(i+1,end,arr,dp,max);
            int result = left + right + max[start][i] * max[i+1][end];
            ans = Math.min(ans, result);
        }

        return dp[start][end] = ans;
    }

}
