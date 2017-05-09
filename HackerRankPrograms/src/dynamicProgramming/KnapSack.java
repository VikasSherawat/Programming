package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class KnapSack {

	/**
	 * @param args
	 * 
	1
2 22
4 7
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] result = new int[T];
		for (int i = 0; i < T; i++) {
			int N = in.nextInt(), K = in.nextInt();
			int[] ar = new int[N];
			for (int j = 0; j < ar.length; j++) {
				ar[j]= in.nextInt();
			}
			
			result[i] = findKnapSack(ar,K);
		}
		for (int i : result) {
			System.out.println(i);
		}
	}

	private static int findKnapSack(int[] c, int k) {
		// TODO Auto-generated method stub
		Arrays.sort(c);
		int dp[]= new int[k+1];
		 for (int g=1;g<=k; g++)
		    {
		        for (int y=0;y<c.length; y++)
		        {
		            if (c[y]>g) continue;
		            dp[g]=Math.max(dp[g], c[y]+dp[g-c[y]]); 
		        }
		    }
	return dp[k];
	}

	
}
