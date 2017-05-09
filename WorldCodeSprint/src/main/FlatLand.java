package main;

import java.util.Arrays;
import java.util.Scanner;

public class FlatLand {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int m = in.nextInt();
	        int c[] = new int[m];
	        for(int c_i=0; c_i < m; c_i++){
	            c[c_i] = in.nextInt();
	        }
	        int diff[] = new int[n];
	        int locDiff = 0;
	        for(int i=0;i<n;i++){
	        	for (int j = 0; j < c.length; j++) {
					if(i==c[j]){
						diff[i]=0;
						break;
					}else{
						locDiff = Math.abs(i-c[j]);
					}
					if(j==0){
						diff[i]=locDiff;
					}else{
						diff[i]=Math.min(diff[i], locDiff);
					}
				}//inner for loop closed here
	        }
	        Arrays.sort(diff);
	        System.out.println(diff[diff.length-1]);
	}

}
