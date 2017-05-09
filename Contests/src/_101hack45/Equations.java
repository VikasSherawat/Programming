package _101hack45;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Equations {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] arr = new int[T];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		
		solve(arr);
	}

	private static void solve(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= arr.length; i++) {
			int x = indexOf(arr,indexOf(arr,i));
			System.out.println(x);
		}		
	}

	private static int indexOf(int[] arr, int j) {
		// TODO Auto-generated method stub
		int i = 0;
		for (i = 0; i < arr.length; i++) {
			if(arr[i]==j)
				break;
		}
		return ++i;
	}
}
