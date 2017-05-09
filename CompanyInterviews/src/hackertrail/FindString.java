package hackertrail;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FindString {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		//int T = in.nextInt();
		while (in.hasNext()) {
			int n = in.nextInt();
			String p = in.next();
			String s = in.next();
			//System.out.println("Prefix Array");
			int[] preArray = getPrefixArray(p);
			solve(p, s, preArray);
		}
	}

	private static void solve(String p, String s, int[] preArray) {
		// TODO Auto-generated method stub
		int index = indexOfPattern(s, p, 0, preArray);
		if (index == -1) {
			System.out.println("\n");
			return;
		} else {
			System.out.println(index);
			while (index != -1) {
				index = indexOfPattern(s, p, index + p.length() - preArray[preArray.length - 1], preArray);
				if (index == -1) {
					break;
				} else {
					System.out.println(index);
				}
			}
		}

	}

	public static int indexOfPattern(String s, String p, int start, int[] preArray) {
		int j = 0, i = 0;
		for (i = start; i < s.length() && j < p.length(); i++) {
			if (s.charAt(i) == p.charAt(j)) {
				j++;
			} else {
				if (j == 0)
					continue;

				j = preArray[j - 1];
				if (s.charAt(i) == p.charAt(j)) {
					j++;
				} else {
					j = 0;
				}
			}
		}

		if (j == p.length()) {
			return i - j;
		} else
			return -1;
	}

	private static int[] getPrefixArray(String p) {
		int[] arr = new int[p.length()];
		arr[0] = 0;
		int j = 0;
		for (int i = 1; i < p.length(); i++) {
			if (p.charAt(i) == p.charAt(j)) {
				arr[i] = j + 1;
				j++;
			} else {

				while (j > 0) {
					j = arr[j - 1];
					if (p.charAt(i) == p.charAt(j)) {
						arr[i] = j + 1;
						j++;
						break;
					} else {
						if (j == 0) {
							arr[i] = 0;
							break;
						}

						j = arr[j - 1];
					}
				}
			}
		}

		return arr;
	}

}
