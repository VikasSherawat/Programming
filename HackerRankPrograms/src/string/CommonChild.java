package string;

import java.util.*;
public class CommonChild {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String A = in.next(), B = in.next();
		int len = A.length();
		int[][] dp = new int[len+1][len+1];
		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= len; j++) {
				if(A.charAt(j-1)==B.charAt(i-1))
					dp[i][j]=dp[i-1][j-1]+1;
				else
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		System.out.println(dp[len][len]);
		in.close();
		
	}

}
