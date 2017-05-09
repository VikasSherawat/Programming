package graph;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StepsConstruct {

	int min = Integer.MAX_VALUE;

	String[] as = { "-1", "" };
	boolean[][] bool;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] board = { ".#...", ".#.#.", ".#.#.", ".#.#.", "...#." };
		int k = 20;
		String ans = new StepsConstruct().construct(board, k);
		System.out.println(ans);
	}

	public String construct(String[] board, int k) {
		String path = "";
		char[][] a = new char[board.length][board[0].length()];
		for (int i = 0; i < board.length; i++) {
			a[i] = board[i].toCharArray();
		}
		if (a[0][0] == '#' || a[a.length - 1][a[0].length - 1] == '#') {
			return path;
		}

		bool = new boolean[a.length][a[0].length];

		String[] ans = getPath(a, 0, 0, path, 0);
		int kans = Integer.valueOf(ans[0]);
		if (kans == k || kans == -1) {
			return ans[1];
		} else if (kans > k) {
			return path;
		} else {
			int krem = k - kans;
			if (krem % 2 == 1) {
				return path;
			} else {
				String ap = "", bk = "";
				if (a[0].length > 1 && a[0][1] != '#') {
					ap = "R";
					bk = "L";
				} else {
					ap = "D";
					bk = "U";
				}
				int r = 0;
				while (krem-- > 0) {
					if (r == 0) {
						path += ap;
					} else {
						path += bk;
					}
					r = 1 - r;
				}

				return path + ans[1];
			}
		}
	}

	private String[] getPath(char[][] a, int i, int j, String path, int k) {
		// TODO Auto-generated method stub
		if (i == a.length - 1 && j == a[0].length - 1) {
			return new String[] { String.valueOf(k), path };
		}

		if (i < 0 || i >= a.length || j < 0 || j >= a[0].length || bool[i][j])
			return as;

		if (a[i][j] == '#')
			return as;

		bool[i][j] = true;

		String[] arr = getPath(a, i + 1, j, path + "D", k + 1);
		if (arr[0] != "-1") {
			return arr;
		}

		arr = getPath(a, i, j + 1, path + "R", k + 1);
		if (arr[0] != "-1") {
			return arr;
		}

		arr = getPath(a, i - 1, j, path + "U", k + 1);
		if (arr[0] != "-1") {
			return arr;
		}

		arr = getPath(a, i, j - 1, path + "L", k + 1);
		if (arr[0] != "-1") {
			return arr;
		}

		return arr;
	}

}
