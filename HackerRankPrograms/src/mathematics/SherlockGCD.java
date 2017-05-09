package mathematics;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockGCD {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = in.nextInt();
			}
			check(arr);
		}
	}

	private static void check(int[] arr) {
		// TODO Auto-generated method stub
		int gc =0;
		for (int i = 0; i < arr.length; i++) {
			gc = gcd(gc,arr[i]);
		}
		if(gc==1)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	private static int gcd(int a, int b) {
		// TODO Auto-generated method stub
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

}
