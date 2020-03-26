package dp;

public class BuyStock2 {
    int[][] dp;
    int[] pr;
    int fee;
    public static void main(String[] args) {
        int[] p = {1,3,2,8,4,9};
        int ans = new BuyStock2().maxProfit(p,2);
        System.out.println(ans);
    }
    public int maxProfit(int[] prices, int fee) {
        int l = prices.length;
        int min = Integer.MAX_VALUE;
        int p = 0;
        this.pr = prices;
        this.fee =fee;
        dp = new int[l][l];
        for(int i =0;i<l;i++){
            if(prices[i]<min){
                min = prices[i];
                int profit = rec(i,l-1);
                p = Math.max(p,profit);
            }
        }

        return p;
    }

    private int rec(int start , int end){
        if(start>=end){
            return 0;
        }
        if(dp[start][end]!=0){
            return dp[start][end];
        }
        int max  = 0, min = Integer.MAX_VALUE;
        for(int i = start; i<=end;i++){
            if(pr[i]<min) {
                min = pr[i];
            }else {
                continue;
            }
            for(int j = i+1;j<=end;j++){
                    if(pr[j]-pr[i]>fee){
                        int profit = pr[j]-pr[i]-fee + rec(j+1,end);
                        max = Math.max(max, profit);
                    }
            }
        }
        return dp[start][end]=max;
    }
}
