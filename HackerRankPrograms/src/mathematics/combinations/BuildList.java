package mathematics.combinations;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BuildList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			String S = in.next();
			char[] arr = S.toCharArray();
			Arrays.sort(arr);
			solve(N, arr);
		}
	}

	private static void solve(int n, char[] arr) {
		// TODO Auto-generated method stub
		int len = (int) Math.pow(2, n);
		int[] numbers = new int[len - 1];
		for (int i = 0; i < len - 1; i++) {
			numbers[i] = i;
		}
		int start = 0, end = 0;
		for (int i = n - 1; i >= 0; i--) {
			end = (int) Math.pow(2, i);
			shift(numbers, start, start + end - 1);
			//exchangefirstandlast(numbers, start, start+end-1);
			start += end;
		}

		for (int i = 0; i < numbers.length; i++) {
			String s = String.format("%" + n + "s", Integer.toBinaryString(numbers[i]))
					.replace(' ', '0');
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < s.length(); j++) {
				if(s.charAt(j)=='0'){
					sb.append(arr[j]);
				}
			}
			System.out.println(sb.toString());
		}

	}

	private static void shift(int[] numbers, int start, int end) {
		// TODO Auto-generated method stub
		if (start == end || start > end) {
			return;
		}
		if (end == start + 1) {
			int temp = numbers[start];
			numbers[start] = numbers[end];
			numbers[end] = temp;
		} else {
			shift(numbers, start, end / 2);
			numbers = exchangefirstandlast(numbers, start, end);
		}
	}

	private static int[] exchangefirstandlast(int[] numbers, int start, int end) {
		// TODO Auto-generated method stub
		int temp = numbers[end];
		for (int i = end - 1; i >= start; i--) {
			numbers[i + 1] = numbers[i];
		}
		numbers[start] = temp;

		return numbers;
	}

}
