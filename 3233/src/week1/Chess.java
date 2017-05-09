package week1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Chess {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		while (T-- > 0) {
			String ss1 = in.next();
			int s1 = getIndex(ss1);
			int s2 = in.nextInt();
			String ds1 = in.next();
			int d1 = getIndex(ds1);
			int d2 = in.nextInt();
			if ((s1 + s2) % 2 != (d1 + d2) % 2) {
				System.out.println("Impossible");
				continue;
			}

			solve(s1, s2 - 1, d1, d2 - 1);

		}
	}

	private static void solve(int s1, int s2, int d1, int d2) {

		int a = s1, b = s2;
		if (s1 == d1 && s2 == d2) {
			print(s1, s2, a, b, d1, d2, 0);
			return;
		}
		int count = 1;

		int slope1 = getSlove(a, b, d1, d2);
		if (slope1 == 1 || slope1 == -1) {
			print(s1, s2, a, b, d1, d2, 1);
			return;
		}

		while (true) {
			a++;
			b++;
			count++;
			if (!(a >= 0 && a < 8) || !(b >= 0 && b < 8)) {
				break;
			}
			int slope = getSlove(a, b, d1, d2);
			if (slope == 1 || slope == -1) {
				print(s1, s2, a, b, d1, d2, count);
				return;
			}

		}
		a = s1;
		b = s2;
		while (true) {
			a--;
			b--;
			count++;
			if (!(a >= 0 && a < 8) || !(b >= 0 && b < 8)) {
				break;
			}
			int slope = getSlove(a, b, d1, d2);
			if (slope == 1 || slope == -1) {
				print(s1, s2, a, b, d1, d2, count);
				return;
			}
		}

		a = s1;
		b = s2;
		while (true) {
			a++;
			b--;
			count++;
			if (!(a >= 0 && a < 8) || !(b >= 0 && b < 8)) {
				break;
			}
			int slope = getSlove(a, b, d1, d2);
			if (slope == 1 || slope == -1) {
				print(s1, s2, a, b, d1, d2, count);
				return;
			}
		}
		a = s1;
		b = s2;
		while (true) {
			a--;
			b++;
			count++;
			if (!(a >= 0 && a < 8) || !(b >= 0 && b < 8)) {
				break;
			}
			int slope = getSlove(a, b, d1, d2);
			if (slope == 1 || slope == -1) {
				print(s1, s2, a, b, d1, d2, count);
				return;
			}
		}

	}

	private static void print(int s1, int s2, int a, int b, int d1, int d2,
			int count) {
		// TODO Auto-generated method stub
		String[] ar = { "A", "B", "C", "D", "E", "F", "G", "H" };
		s2++;
		b++;
		d2++;
		if (count == 0) {
			System.out.println(count + " " + ar[s1] + " " + s2);
		} else if (count == 1) {
			System.out.println(count + " " + ar[s1] + " " + s2 + " " + ar[d1]
					+ " " + d2);
		} else {
			System.out.println(2 + " " + ar[s1] + " " + s2 + " " + ar[a] + " "
					+ b + " " + ar[d1] + " " + d2);
		}

	}

	private static int getSlove(int a, int b, int d1, int d2) {
		// TODO Auto-generated method stub
		int num = Math.abs(d2 - b);
		int den = Math.abs(d1 - a);
		float slope = (float) num / den;
		if (slope == 1.0)
			return 1;
		else
			return 5;
	}

	private static int getIndex(String ss1) {
		// TODO Auto-generated method stub
		String[] arr = { "A", "B", "C", "D", "E", "F", "G", "H" };
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equalsIgnoreCase(ss1))
				return i;
		}
		return -1;
	}
}
