package dynamicProgramming;

import java.util.Scanner;

public class MaxSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int N;
		int[] ar ;
		int[] maxC = new int[T];
		int[] maxNC = new int[T];
		for (int i = 0; i < T; i++) {
			N= in.nextInt();
			ar = new int[N];
			int sum = 0;
			for (int j = 0; j < ar.length; j++) {
				ar[j]=in.nextInt();
				if(ar[j]>0)
					sum += ar[j];
			}
		maxC[i] = findMaxContigiousSum(ar);
		maxNC[i] = sum==0?maxC[i]:sum;
		}
		
		for (int i = 0; i < maxNC.length; i++) {
			System.out.println(maxC[i]+" "+maxNC[i]);
		}
	}

	private static int findMaxContigiousSum(int[] ar) {
		// TODO Auto-generated method stub
		int maxSofar =0, maxEndhere=0;;
		for (int i = 0; i < ar.length; i++) {
			maxEndhere+= ar[i];
			if(maxEndhere<0)
				maxEndhere=0;
			if(maxSofar<maxEndhere)
				maxSofar = maxEndhere;
		}
		if(maxSofar==0)
			maxSofar = findLowestNum(ar);
		return maxSofar;
	}
	private static int findLowestNum(int[] ar) {
		// TODO Auto-generated method stub
		int min = -1000000;
		for (int i = 0; i < ar.length; i++) {
			if(min<ar[i])
				min = ar[i];
		}
		return min;
	}

	

}
