package dataStructures;

import java.util.Scanner;

public class Array_DS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i]=in.nextInt();
		}
		
		for (int i =ar.length-1;i>=0;i--) {
			System.out.print(ar[i]+" ");
		}
	}

}
