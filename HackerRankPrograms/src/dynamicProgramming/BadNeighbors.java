package dynamicProgramming;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BadNeighbors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7, 7, 7, 7, 7, 7, 7};
		int ans = new BadNeighbors().maxDonations(arr);
		System.out.println(ans);
	}

	public int maxDonations(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
		if(arr.length==2){
			return Math.max(arr[0], arr[1]);
		}
		
		int[] dp = new int[n];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[1], arr[0]);
		int max = 0,i=0;
		for (i = 2; i < dp.length-1; i++) {
			dp[i] = Math.max(dp[i-1], arr[i]+dp[i-2]);
			max = Math.max(max, dp[i]);
		}
		dp[i] = Math.max(i-1, arr[i]+dp[i-2]-arr[0]);
		max = Math.max(max, dp[i]);
		return max;
	}

}
