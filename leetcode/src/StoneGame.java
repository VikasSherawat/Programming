import java.util.Arrays;

public class StoneGame {

    public static void main(String[] args) {
        int[] a = {1,2};
        System.out.println(new StoneGame().coinChange(a,2));
    }
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        if(len==0|| amount ==0)
            return 0;
        Arrays.sort(coins);
        int[][] dp = new int[len][amount+1];
        for(int i = 0;i<len;i++){
            Arrays.fill(dp[i],amount+1);
            dp[i][0]=0;
            for(int j = 1;j<=amount;j++){
                int c = coins[i];
                if(i==0 ){
                    if(j%c==0)
                        dp[i][j] = j/c;
                }else {
                    if (c <= j)
                        dp[i][j] = Math.min(dp[i-1][j], dp[i][j - c] + 1);
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }

        return dp[len-1][amount]==amount+1?-1:dp[len-1][amount];
    }}
