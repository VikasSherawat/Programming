package dynamicProgramming;
// Java program to find length of longest increasing subsequence
// in O(n Log n) time
import java.io.*;
import java.util.*;
import java.lang.Math;
 
class LongestIncSubSequence
{
	
	public int LISubSeq(int[] arr) {
		// TODO Auto-generated method stub
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);
		int max = 1;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i]>arr[j]){
					dp[i] = Math.max(dp[j]+1,dp[i]);
					max = Math.max(max, dp[i]);
				}
			}
		}
		return max;
	}
 
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
		 int arr[] = { 3,4,-1,0,2,6,3 };
		 int len = new LongestIncSubSequence().LISubSeq(arr);
		 System.out.println(len);
        
    }
}