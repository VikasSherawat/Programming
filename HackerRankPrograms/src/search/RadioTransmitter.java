package search;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RadioTransmitter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] x = new int[n];
		for (int x_i = 0; x_i < n; x_i++) {
			x[x_i] = in.nextInt();
		}
		Arrays.sort(x);
		int ans = solve(x, k, 0, n);
		System.out.println(ans);
	}

	private static int solve(int[] x, int k, int start, int end) {
		// TODO Auto-generated method stub
		int count = 0;

		if (start == x.length - 1) {
			return ++count;
		}
		if (!(x[start] + k >= x[start + 1])) {
			count = 1 + solve(x, k, ++start, end);
			return count;
		}
		int z = start+1;
		int dis = x[start]+k;
		while(z<end && x[z]<=dis){
			z++;
		}

		int aft = x[--z] + k;
		int y = z + 1;
		while (y < end && x[y] <= aft) {
			y++;

		}
		if (y >= end)
			return ++count;
		else {
			count = 1 + solve(x, k, y, end);
			return count;
		}
	}

	// private static

}
