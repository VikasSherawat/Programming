package dynamicProgramming;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AltIncSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
				67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 249,
				22, 176, 279, 23, 22, 617, 462, 459, 244 };
		
		int ans = new AltIncSeq().longestZigZag(arr);
		System.out.println(ans);

	}

	public int longestZigZag(int[] arr) {
		// TODO Auto-generated method stub
		int[] dp = new int[arr.length];
		int[] sign = new int[arr.length];

		Arrays.fill(dp, 1);
		int max = 1;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (sign[j] == 0) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
					if (arr[i] > arr[j]) {
						sign[i] = 1;
						sign[i] = 1;
					} else if (arr[i] < arr[j]) {
						sign[i] = -1;
					} else {
						sign[i] = 0;
					}
				} else if (sign[j] == 1) {
					if (arr[i] < arr[j]) {
						sign[i] = -1;
						dp[i] = Math.max(dp[j] + 1, dp[i]);
					}

				} else {
					if (arr[i] > arr[j]) {
						dp[i] = Math.max(dp[j] + 1, dp[i]);
						sign[i] = 1;
					}

				}
				max = Math.max(max, dp[i]);
			}
		}

		return max;
	}

}
