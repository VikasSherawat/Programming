package search;

import java.util.Scanner;

public class SherlockArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        String[] result = new String[n];
	        for (int i = 0; i < n; i++) {
	        	int len = in.nextInt();
	        	int[] ar = new int[len];
	        	long[] lSum = new long[len];
	        	long[] rSum = new long[len];
	        	lSum[0]=0l;
	        	for (int j = 0; j < len; j++) {
					ar[j]=in.nextInt();
					if(j>0)
						lSum[j]=lSum[j-1]+ ar[j-1];
				}
	        	long tSum = lSum[len-1]+ar[len-1];
	        	/*rSum[0]= tSum-ar[0];
	        	for (int j = 1; j < rSum.length-1; j++) {
					rSum[j]=rSum[j-1]-ar[j];
				}*/
	        	result[i] = findIndex(lSum,tSum);
			}
	        for (String string : result) {
				System.out.println(string);
			}
	}

	private static String findIndex(long[] lSum, long tSum) {
		// TODO Auto-generated method stub
		if(lSum.length==1)
			return "YES";
		int len = lSum.length;
		for (int i = 1; i < len; i++) {
			if(lSum[i]==tSum - lSum[i-1])
				return "YES";
		}
		return "NO";
	}

}
