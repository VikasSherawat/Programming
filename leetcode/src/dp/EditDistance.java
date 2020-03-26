package dp;

public class EditDistance {

    public static void main(String[] args) {
        int ans = new EditDistance().minDistance("horse","ros");
        System.out.println(ans);
    }
    public int minDistance(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        int[][] dp = new int[blen+1][alen+1];
        for(int i =1;i<=alen;i++){
            dp[0][i]=dp[0][i-1]+1;
        }

        for(int i =1;i<=blen;i++){
            dp[i][0]=dp[i-1][0]+1;
        }

        for(int i =1;i<=blen;i++){
            for(int j = 1;j<=alen;j++){
                if(b.charAt(i-1)==a.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else
                    dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j])+1;
            }
        }

        return dp[blen][alen];
    }
}
