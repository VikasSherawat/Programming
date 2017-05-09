package implementations;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AbsolutePermutation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			int K = in.nextInt();
			if (K==0)
				print(N);
			else
				solve(N,K);
		}
	}

	private static void print(int n) {
		// TODO Auto-generated method stub
		for (int i = 1; i <=n; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

	private static void solve(int n, int k) {
		// TODO Auto-generated method stub
		boolean[] arr = new boolean[n+1];
		Arrays.fill(arr, true);
		int[] perm = new int[n+1];
		perm[1] = 1+k;
		perm[1+k] = 1;
		arr[1] = false;
		arr[1+k] = false;
		if(perm[n]!=0 || arr[n]){
			perm[n] = n-k;
			perm[n-k] = n;
			arr[n] = arr[n-k] = false;
		}else{
			System.out.println(-1);
			return;
		}
			
		for (int i = 2; i < perm.length-1; i++) {
			
			if(perm[i]!=0)
				continue;
			
			if(arr[i] && i+k <=n){
				arr[i] = false;
				perm[i] = i+k;
				perm[i+k] = i;
				arr[i+k] = false;
			}else{
				System.out.println(-1);
				return;
			}
		}
		
		for (int i = 1; i <=n; i++) {
			System.out.print(perm[i]+" ");
		}
		System.out.println();
	}
}
