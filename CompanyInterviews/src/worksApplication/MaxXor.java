package worksApplication;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxXor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		
		new MaxXor().solve(arr,N);
	}

	private  void solve(int[] arr,int N) {
		// TODO Auto-generated method stub
		int[] p = new int[N+1];
		int[] s = new int[N+1];
			
		p[0]=arr[0];
		
		for (int i = 1; i <N-1 ; i++) {
			p[i] = arr[i] ^ p[i-1];
		}
		s[N-1]=arr[N-1];
		for (int i = N-2; i >=0; i--){
	        s[i] = s[i+1] ^ arr[i];
	    }
		
		System.out.println(Arrays.toString(p));
		System.out.println(Arrays.toString(s));
		
		long ans = 0;
	    for (int i = 0; i < N; i++){
	        ans = Math.max(ans, Math.max(findLargest(p, 0, i), findLargest(s, i + 1, N)));

	    }
	    
	    System.out.println(ans);
	}
	
	private long findLargest(int ar[], int m, int n){
	    long x = 0;
	    for (int i = m; i <= n; i++){
	        x = Math.max(x, ar[i]);
	    }
	    return x;
	}
}
