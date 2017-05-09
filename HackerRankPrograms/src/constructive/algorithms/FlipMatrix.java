package constructive.algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FlipMatrix {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			int[][] arr = new int[2*N][2*N];
			for (int i = 0; i < 2*N; i++) {
				for (int j = 0; j < 2*N; j++) {
					arr[i][j] = in.nextInt();
				}
			}
			
			solve(arr,N);
		}
	}

	private static void solve(int[][] arr, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			reverserows(arr,i);
		}
		
		for (int i = 0; i < arr.length; i++) {
			reversecolumns(arr,i);
		}
		int sum =0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum += arr[i][j];
			}
		}
		
		System.out.println(sum);
	}

	private static void reversecolumns(int[][] arr, int index) {
		// TODO Auto-generated method stub
		int sl = 0, sr = 0;
		int n = arr.length;
		for (int j = 0; j < arr[index].length; j++) {
			if(j<n/2)
				sl += arr[j][index];
			else
				sr += arr[j][index];
		}
		
		if(sl<sr){
			for (int i = 0; i < n/2; i++) {
				int temp = arr[i][index];
				arr[i][index] = arr[n-1-i][index];
				arr[n-1-i][index] = temp;
			}
		}
	}

	private static void reverserows(int[][] arr, int index) {
		// TODO Auto-generated method stub
		int sl = 0, sr = 0;
		int n = arr.length;
		for (int j = 0; j < arr[index].length; j++) {
			if(j<n/2)
				sl += arr[index][j];
			else
				sr += arr[index][j];
		}
		
		if(sl<sr){
			for (int i = 0; i < n/2; i++) {
				int temp = arr[index][i];
				arr[index][i] = arr[index][n-1-i];
				arr[index][n-i-1] = temp;
			}
		}
	}
}
