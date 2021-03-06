package graph;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TriangleEasy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 20;
		int[] x = { 16, 4, 15, 6, 1, 0, 10, 12, 7, 15, 2, 4, 8, 1, 10, 15, 13, 10, 1, 16, 3, 19, 8, 7, 13, 1, 15, 15,
				15, 5, 16, 7, 5, 6, 4, 18, 3, 8, 6, 2, 16, 8, 19, 14, 17, 16, 4, 6, 9, 17, 4, 10, 8, 12, 2, 3, 18, 9,
				13, 17, 4, 7, 10, 0, 13, 11, 15, 17, 11, 15, 11, 19, 19, 4, 10, 14, 16, 6, 3, 17, 1, 4, 14, 9, 7, 18,
				10, 11, 5, 0, 5, 9, 9, 7, 16, 12, 4, 10, 17, 3 };
		int[] y = { 17, 18, 6, 16, 18, 6, 11, 2, 15, 10, 1, 15, 17, 8, 5, 9, 7, 0, 0, 4, 16, 1, 9, 0, 9, 5, 17, 14, 1,
				12, 14, 11, 9, 18, 0, 12, 11, 3, 19, 14, 7, 6, 3, 19, 0, 1, 19, 5, 11, 19, 2, 13, 12, 0, 6, 2, 14, 16,
				14, 18, 5, 5, 19, 3, 6, 14, 12, 5, 17, 3, 1, 12, 7, 11, 8, 8, 10, 11, 13, 2, 13, 13, 0, 18, 2, 7, 2, 12,
				14, 9, 3, 19, 2, 8, 12, 13, 8, 18, 13, 18 };
		int ans = new TriangleEasy().find(n, x, y);
		System.out.println(ans);
	}

	public int find(int n, int[] x, int[] y) {
		if (x.length == 0)
			return 3;

		int ans = 2;
		int[][] g = makeGraph(n, x, y);
		for (int i = 0; i < g.length; i++) {
			int p = -1, q = -1, count = 0;
			for (int j = 0; j < g.length; j++) {
				if (g[i][j] == 0)
					continue;
				if (count++ < 2) {
					if (p == -1) {
						p = j;
						continue;
					}
					if (q == -1) {
						q = j;
					}
				} else {
					p = q;
					q = j;
				}

				if (p != -1 && q != -1) {
					if (g[p][q] == 1 || g[q][p] == 1) {
						return 0;
					} else {
						ans = Math.min(ans, 1);
					}
				}
			}
		}
		return ans;
	}

	private int[][] makeGraph(int n, int[] x, int[] y) {
		// TODO Auto-generated method stub
		int[][] a = new int[n][n];
		for (int i = 0; i < x.length; i++) {
			int xi = x[i], yi = y[i];
			a[xi][yi] = a[yi][xi] = 1;
		}
		return a;
	}
}
