package dynamicProgramming;

import java.util.*;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int M= in.nextInt();
		int[] coins = new int[M];
		for (int i = 0; i < coins.length; i++) {
			coins[i]=in.nextInt();
		}
		Arrays.sort(coins);
		long maxWays = new CoinChange().doCoinChange(T, coins);
		System.out.printf("%d",maxWays);
		//System.out.printf("Jus Checking");
	}

	private long doCoinChange(int sum, int[] coins) {
		// TODO Auto-generated method stub
		long[][] dp = new long[coins.length][sum+1];
		
		//initializing ways to make 0 sum to 1
		for (int i = 0; i < coins.length; i++) {
			dp[i][0] = 1l;
		}
		
		//initializing for the lowest coin
		for (int i = 1; i <=sum ; i++) {
			if(i%coins[0]==0)
				dp[0][i]=1l;
		}
		
		for (int i = 1; i < coins.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if(j<coins[i]){
					dp[i][j] = dp[i-1][j];
				}else{
					dp[i][j] = dp[i][j-coins[i]] + dp[i-1][j];
				}
			}
		}
		
		return dp[coins.length-1][sum];
	}

}
