package mathematics.numbertheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JohnGCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = in.nextInt();
			}

			solve(N, arr);
		}
	}

	private static void solve(int n, int[] arr) {
		// TODO Auto-generated method stub
		int[] b = new int[n + 1];
		b[n] = arr[n - 1];
		for (int i = n - 1; i >= 0; i--) {
			int next = b[i + 1];
			int a = arr[i];
			if (b[i + 1] % arr[i] == 0) {
				b[i] = arr[i];
			} else {
				int lcm = lcm(Math.min(arr[i], b[i + 1]),Math.max(arr[i], b[i + 1]));
				if(lcm%arr[i+1]==0)
					b[i+1] = lcm;
				else
					b[i+1] = lcm(Math.min(arr[i+1], b[i + 2]),Math.max(arr[i+1], b[i + 2]));
				b[i] = arr[i];
			}
		}
	/*	boolean flag = true;
		int count =0;
		while (count++<50 && flag) {
			flag = false;
			for (int i = n - 1; i >= 0; i--) {
				int gc = gcd(Math.max(b[i], b[i + 1]), Math.min(b[i], b[i + 1]));
				if (gc != arr[i]) {
					
					int fact = arr[i] / gc;
					flag = true;
					b[i] *= fact;
					// b[i+1]*=fact;
				}
			}
		}*/

		for (int i : b) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static int lcm(int a, int b) {
		// TODO Auto-generated method stub
		return a * (b / gcd(a, b));
		
	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

}
