package greedy;

import java.util.Scanner;

public class TwoArrays {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int n,max;
		String[] result = new String[num];
		int[][] ar;
		for (int i = 0; i < num; i++) {
			n = in.nextInt();
			max = in.nextInt();
			ar = new int[2][n];
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < n; k++) {
					ar[j][k] = in.nextInt();
				}
			}//inner for loop closed here
			
			result[i]=findResult(ar,max);
		}//outer for loop closed here
		
		for (String str : result) {
			System.out.println(str);
		}
	}

	private static String findResult(int[][] ar, int max) {
		// TODO Auto-generated method stub
			
			ar[0] = sortArray(ar[0]);
			ar[1] = reverseSortArray(ar[1]);
			for (int i = 0; i < ar[0].length; i++) {
				if(max<=ar[0][i]+ar[1][i])
					continue;
				else
					return "NO";
			}
		return "YES";
	}

	private static int[] reverseSortArray(int[] ar) {
		// TODO Auto-generated method stub
		int max = ar[0],temp;
		for (int i = 0; i < ar.length-1; i++) {
			for (int j = 0; j < ar.length-1; j++) {
				if(ar[j]<ar[j+1]){
					temp = ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=temp;
				}
			}
		}
		return ar;
	}

	private static int[] sortArray(int[] ar) {
		// TODO Auto-generated method stub
		
		int max = ar[0],temp;
		for (int i = 0; i < ar.length-1; i++) {
			for (int j = 0; j < ar.length-1; j++) {
				if(ar[j]>ar[j+1]){
					temp = ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=temp;
				}
			}
		}
		return ar;
	}



}
