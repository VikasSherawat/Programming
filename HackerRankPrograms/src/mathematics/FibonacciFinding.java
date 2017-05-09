package mathematics;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FibonacciFinding {

	static long CONS = 1000000007;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int A = in.nextInt();
			int B = in.nextInt();
			int N = in.nextInt();
			long ans = findFibo(A, B, N);
			System.out.println(ans);
		}
	}

	private static long findFibo(int a, int b, int n) {
		// TODO Auto-generated method stub
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		long[][] M = {{1,1},{1,0}};
		long[][] res = matrix_pow(M,n-1);
		return res[0][0]%CONS;
	}

	private static long[][] matrix_pow(long[][] A, int p) {
		// TODO Auto-generated method stub
		if(p==1)
			return A;
		if(p%2==1)
			return mul(A,matrix_pow(A, p-1));
		long[][] B = matrix_pow(A, p/2);
		return mul(B,B);
	}
	
	private static long[][] mul(long[][] A, long[][] B){
		long[][] res = new long[2][2];
		res[0][0] = A[0][0]*B[0][0]+ A[0][1]*B[1][0];
		res[0][1] = A[0][0]*B[0][1]+ A[0][1]*B[1][1];
		res[1][0] = A[1][0]*B[0][0]+ A[1][1]*B[1][0];
		res[1][1] = A[1][0]*B[0][1]+ A[1][1]*B[1][1];
		return res;
	}
}
