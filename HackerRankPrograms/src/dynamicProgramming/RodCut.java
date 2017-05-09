package dynamicProgramming;

import java.io.*;
import java.util.*;

public class RodCut {
	public static void main(String[] args) {
		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(bi.readLine());
			int[] prices = new int[N];
			String[] arr = bi.readLine().split("\\s+");
			for (int i = 0; i < N; i++) {
				prices[i] = Integer.parseInt(arr[i]);
			}
			int[] maxPrice = new RodCut().solve(prices);
			System.out.println(Arrays.toString(maxPrice));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int[] solve(int[] prices) {
		// TODO Auto-generated method stub
		int N = prices.length;
		int[] maxPrice = new int[N+1];
		int max = 0;
		for (int i = 1; i <=N ; i++) {
			max  = -1;
			for (int j = 1; j <=i ; j++) {
				max = Math.max(max, prices[j-1]+maxPrice[i-j]);
			}
			
			maxPrice[i] = max;
		}
		
		return maxPrice;
	}
}
