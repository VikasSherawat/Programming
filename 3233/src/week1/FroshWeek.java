package week1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FroshWeek {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] ar = new int[T];
		for (int i = 0; i < T; i++) {
			ar[i] =  in.nextInt();
		}
		
		solve(ar);
	}

	private static void solve(int[] ar) {
		// TODO Auto-generated method stub
		int len = ar.length;
		long count = 0L;
		for (int i = 0; i < len; i++) {
			for (int j = 1; j < len; j++) {
				if(ar[j-1]>ar[j]){
					swap(ar,j-1,j);
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

	private static void swap(int[] ar, int i, int j) {
		// TODO Auto-generated method stub
		int temp = ar[i];
		ar[i]= ar[j];
		ar[j] = temp;
	}

}
