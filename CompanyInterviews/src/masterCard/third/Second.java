package masterCard.third;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Second {
	public static void main(String[] args) {
		int[] a = {1,2,3,45,6};
		int sum = findSum(a);
		System.out.println(sum);
	}

	private static int findSum(int[] a) {
		// TODO Auto-generated method stub
		int sum =0 ;
		for (int i = 0; i < a.length; i++) {
			sum+= a[i];
		}
		return sum;
	}
}
