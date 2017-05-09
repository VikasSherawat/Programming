package bitManipulation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class XorMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int[][] a = new int[M][N];
		for (int i = 0; i < N; i++) {
			a[0][i] = in.nextInt();
		}
		
		
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if(j==N-1){
					a[i][j] =a[i-1][j]^a[i-1][0];
				}else{
					a[i][j] =a[i-1][j] ^a[i-1][j+1]; 
				}
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
