package hackertrail;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int n = in.nextInt();
			int[] a = new int[n];
			int ones = 0;
			for (int i = 0; i < a.length; i++) {
				a[i] = in.nextInt();
				ones ^= a[i];
			}
			solve(a, ones);

		}
	}

	private static void solve(int[] a, int ones) {
		// TODO Auto-generated method stub
		
		if(ones!=0)
			System.out.println(1);
		else
			System.out.println(2);
	}

}
