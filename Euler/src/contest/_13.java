package contest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class _13 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[][] a = new int[T][50];
		int[] out = new int[55];
		int idx = 0;
		BigInteger sum = BigInteger.ZERO;
		while (T-- > 0) {
			String s = in.next();
			sum = sum.add(new  BigInteger(s));
		}
		
		System.out.println(sum.toString().substring(0, 10));
	}
}