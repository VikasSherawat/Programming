package bitManipulation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaximiseXor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int L = in.nextInt();
		int R = in.nextInt();
		int mxor = -1;
		if (Integer.toBinaryString(R).length()
				- Integer.toBinaryString(L).length() >= 1) {
			mxor = (int)(Math.pow(2, Integer.toBinaryString(R).length())-1);
		} else {
			for (int i = L; i <= R; i++) {
				for (int j = i; j <=R ; j++) {
					int temp = i ^ j;
					if(temp>mxor)
						mxor = temp;
				}
			}
		}
		System.out.println(mxor);

	}

	private static String reverse(String s) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(1);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				sb.append(0);
			} else {
				sb.append(1);
			}
		}
		return sb.toString();
	}

}
