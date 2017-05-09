package implementations;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EmaSuperComputer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		char[][] grid = new char[N][M];
		for (int i = 0; i < N; i++) {
			grid[i] = in.next().toCharArray();
		}

		solve(N, M, grid);
	}

	private static void solve(int m, int n, char[][] grid) {
		// TODO Auto-generated method stub
		int msq = Math.min(m, n);
		msq += msq % 2 == 0 ? -1 : 0;
		int size = msq;
		int total = 0;
		char[][] org = copyArray(grid);
		int[] area = new int[2];
		Arrays.fill(area, 1);
		while (size>1) {
			int count = 0;
			grid = copyArray(org);
			Arrays.fill(area, 1);
			msq = size;
			while (count != 2 && msq >= 1) {
				for (int i = msq / 2; count != 2 && i < m - msq / 2; i++) {
					for (int j = msq / 2; count != 2 && j < n - msq / 2; j++) {
						if (i + msq / 2 >= m || j + msq / 2 >= n)
							break;
						if (grid[i][j] == 'G' && valid(grid, i, j, msq, m, n)) {
							area[count] = msq;
							count++;
						}
					}
				}
				msq -= 2;
			}
			int temp  = (2 * area[0] - 1) * (2 * area[1] - 1);
			if(temp>total)
				total = temp;
			size -=2;
		}
		if(total ==0)
			total = 2;
		System.out.println(total);
	}


	private static char[][] copyArray(char[][] org) {
		// TODO Auto-generated method stub
		char[][] res = new char[org.length][org[0].length];
		for (int i = 0; i < org.length; i++) {
			for (int j = 0; j < org[i].length ; j++) {
				res[i][j] = org[i][j];
			}
		}
		return res;
	}

	private static boolean valid(char[][] grid, int a, int b, int msq, int m,
			int n) {
		// TODO Auto-generated method stub
		int size = msq / 2;
		msq /= 2;
		while (msq > 0) {
			if (grid[a - msq][b] != 'G' || grid[a + msq][b] != 'G'
					|| grid[a][b - msq] != 'G' || grid[a][b + msq] != 'G')
				return false;
			msq--;
		}
		msq = size;
		while (msq > 0) {
			grid[a - msq][b] = 'B';
			grid[a + msq][b] = 'B';
			grid[a][b - msq] = 'B';
			grid[a][b + msq] = 'B';
			msq--;
		}
		return true;
	}

}
