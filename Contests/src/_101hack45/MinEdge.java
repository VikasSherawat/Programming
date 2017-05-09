package _101hack45;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinEdge {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		solve(n, k);
	}

	private static void solve(int n, int k) {
		// TODO Auto-generated method stub
		if (n < k || (k == 2 && n > k)) {
			System.out.println(-1);
			return;
		}

		if (n == k) {
			System.out.println(n-1);
			return;
		}

		int[] a = new int[k];
		Arrays.fill(a, 1);
		n -= k;
		while (n > 0) {
			for (int i = 1; i < a.length - 1 && n>0; i += 2) {
				a[i]++;
				n--;
			}
		}

		int prod = 0;
		for (int i = 0; i < a.length - 1; i++) {
			prod += a[i] * a[i + 1];
		}

		System.out.println(prod);
	}
}
