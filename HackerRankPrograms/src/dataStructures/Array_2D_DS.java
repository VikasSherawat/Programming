package dataStructures;

import java.util.Scanner;

public class Array_2D_DS {

	/**
	 *
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int[][] ar = new int[6][6];
		int sum=0, maxSum=0,count=0;
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				ar[i][j]=in.nextInt();
			}
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				sum=0;
				sum+=ar[i][j];
				sum+=ar[i][j+1];
				sum+=ar[i][j+2];
				sum+=ar[i+1][j+1];
				sum+=ar[i+2][j];
				sum+=ar[i+2][j+1];
				sum+=ar[i+2][j+2];
				if(maxSum==0&&count++==0)
					maxSum=sum;
				else
					if(maxSum<=sum)
						maxSum=sum;
			}
			
		}//outer for loop
		
		System.out.println(maxSum);
	}

}
