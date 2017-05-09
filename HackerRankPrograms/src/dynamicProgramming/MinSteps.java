package dynamicProgramming;

import java.util.*;
public class MinSteps {

	/**
	 * @param args
	 * Description: you have to find minimum number of ways to reach any number N to 1
	 * by using three operations
	 * 1. N = N-1
	 * 2. N = N/2
	 * 3. N = N/3
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int steps = findMinSteps(N);
		System.out.println(steps);
	}

	private static int findMinSteps(int n) {
		// TODO Auto-generated method stub
		int[] arr  = new int[n+1];
		if(n==1)
			return 0;
		if(arr[n]!=0)
			return arr[n];
		
		for (int i = 2; i <=n; i++) {
			arr[i]=1+arr[i-1];
			if(i%2==0){
				arr[i]= Math.min(arr[i], 1+arr[i/2]);
			}
			if(i%3==0){
				arr[i]=Math.min(arr[i], 1+arr[i/3]);
			}
		}
		return arr[n];
	}

}
