package set3;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Misa {
	static final String FILENAME = "practice";
	static final String QUESTION = "A-";
	static final String SIZE = "large-";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + QUESTION + SIZE + FILENAME + ".in";
	static final String OUT = FILEPATH + QUESTION + SIZE + FILENAME + "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;
	BufferedReader br;

	private void solve(int TURN) throws Exception {
		int ans = 0;
		int[] ip = sarr2IntArr(br.readLine().split("\\s+"));
		int r = ip[0], c = ip[0];
		char[][] a = new char[r][c];
		for (int i = 0; i < r; i++) {
			a[i] = br.readLine().toCharArray();
		}

		int[] mIndex = findMaxPpl(a);
		if (mIndex[0] != -1)
			a[mIndex[0]][mIndex[1]] = 'o';
		ans = findHandShake(a);
		pl(ans);
	}

	private int findHandShake(char[][] a) {
		// TODO Auto-generated method stub
		int ans = 0;
		int r = a.length, c = a[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (a[i][j] == '.')
					continue;
				if (j + 1 < c && a[i][j + 1] == 'o') {
					ans++;
				}
				if (i + 1 < r && a[i + 1][j] == 'o') {
					ans++;
				}
				if (i + 1 < r && j - 1 >= 0 && a[i + 1][j - 1] == 'o') {
					ans++;
				}
				if (i + 1 < r && j + 1 < c && a[i + 1][j + 1] == 'o') {
					ans++;
				}
			}
		}
		return ans;
	}

	private int[] findMaxPpl(char[][] a) {
		// TODO Auto-generated method stub
		int max = 0;
		int[] arr = new int[2];
		int r = a.length, c = a[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (a[i][j] != '.')
					continue;
				if (i != 0 && j != 0 && i != r - 1 && j != c - 1) {
					int count = 0;
					if (j+1<c && a[i][j + 1] == 'o') {
						count++;
					}
					if (j-1>=0 && a[i][j - 1] == 'o') {
						count++;
					}
					if (i-1>=0 && a[i - 1][j] == 'o') {
						count++;
					}
					if (i - 1 >= 0 && j +1 <c && a[i - 1][j + 1] == 'o') {
						count++;
					}
					if (i - 1 >= 0 && j - 1 >= 0 && a[i - 1][j - 1] == 'o') {
						count++;
					}
					if (i + 1 < r && j - 1 >= 0 && a[i + 1][j - 1] == 'o') {
						count++;
					}
					if (i + 1 < r && j + 1 < c && a[i + 1][j + 1] == 'o') {
						count++;
					}
					if (i+1<r && a[i + 1][j] == 'o') {
						count++;
					}
					if (count > max) {
						max = count;
						arr[0] = i;
						arr[1] = j;
					}
				} else if (i == 0 && j == 0) {
					int count = 0;
					if (j + 1 < c && a[i][j + 1] == 'o') {
						count++;
					}
					if (i + 1 < r && a[i + 1][j] == 'o') {
						count++;
					}
					if (i + 1 < r && j + 1 < c && a[i + 1][j + 1] == 'o') {
						count++;
					}
					if (count > max) {
						max = count;
						arr[0] = i;
						arr[1] = j;
					}
				} else if (i == 0 && j == c - 1) {
					int count = 0;
					if (j - 1 >= 0 && a[i][j - 1] == 'o') {
						count++;
					}
					if (i + 1 < r && a[i + 1][j] == 'o') {
						count++;
					}
					if (i + 1 < r && j - 1 >= 0 && a[i + 1][j - 1] == 'o') {
						count++;
					}

					if (count > max) {
						max = count;
						arr[0] = i;
						arr[1] = j;
					}
				} else if (i == r - 1 && j == c - 1) {
					int count = 0;
					if (j - 1 >= 0 && a[i][j - 1] == 'o') {
						count++;
					}
					if (i - 1 >= 0 && a[i - 1][j] == 'o') {
						count++;
					}
					if (i - 1 >= 0 && j - 1 >= 0 && a[i - 1][j - 1] == 'o') {
						count++;
					}

					if (count > max) {
						max = count;
						arr[0] = i;
						arr[1] = j;
					}
				} else if (i == r - 1 && j == 0) {
					int count = 0;
					if (j + 1 < c && a[i][j + 1] == 'o') {
						count++;
					}
					if (i - 1 >= r && a[i - 1][j] == 'o') {
						count++;
					}
					if (i - 1 >= 0 && j + 1 < c && a[i - 1][j + 1] == 'o') {
						count++;
					}

					if (count > max) {
						max = count;
						arr[0] = i;
						arr[1] = j;
					}
				} else if (j == 0) {
					int count = 0;
					if (j + 1 < c && a[i][j + 1] == 'o') {
						count++;
					}
					if (i - 1 >= 0 && a[i - 1][j] == 'o') {
						count++;
					}
					if (i - 1 >= 0 && j + 1 < c && a[i - 1][j + 1] == 'o') {
						count++;
					}
					if (i + 1 < r && j + 1 < c && a[i + 1][j + 1] == 'o') {
						count++;
					}
					if (i + 1 < r && a[i + 1][j] == 'o') {
						count++;
					}

					if (count > max) {
						max = count;
						arr[0] = i;
						arr[1] = j;
					}
				} else if (i == 0) {
					int count = 0;
					if (j + 1 < c && a[i][j + 1] == 'o') {
						count++;
					}
					if (j - 1 >= 0 && a[i][j - 1] == 'o') {
						count++;
					}
					if (i + 1 < r && j - 1 >= 0 && a[i + 1][j - 1] == 'o') {
						count++;
					}
					if (i + 1 < r && j + 1 < c && a[i + 1][j + 1] == 'o') {
						count++;
					}
					if (i + 1 < r && a[i + 1][j] == 'o') {
						count++;
					}

					if (count > max) {
						max = count;
						arr[0] = i;
						arr[1] = j;
					}

				} else if (j == c - 1) {
					int count = 0;
					if (j - 1 >= 0 && a[i][j - 1] == 'o') {
						count++;
					}
					if (i - 1 >= 0 && a[i - 1][j] == 'o') {
						count++;
					}
					if (i - 1 >= 0 && j - 1 >= 0 && a[i - 1][j - 1] == 'o') {
						count++;
					}
					if (i + 1 < r && j - 1 >= 0 && a[i + 1][j - 1] == 'o') {
						count++;
					}
					if (i + 1 < r && a[i + 1][j] == 'o') {
						count++;
					}

					if (count > max) {
						max = count;
						arr[0] = i;
						arr[1] = j;
					}

				} else {
					int count = 0;
					if (j + 1 < c && a[i][j + 1] == 'o') {
						count++;
					}
					if (j - 1 >= 0 && a[i][j - 1] == 'o') {
						count++;
					}
					if (i - 1 >= 0 && j - 1 >= 0 && a[i - 1][j - 1] == 'o') {
						count++;
					}
					if (i - 1 >= 0 && j + 1 < c && a[i - 1][j + 1] == 'o') {
						count++;
					}
					if (i - 1 >= 0 && a[i - 1][j] == 'o') {
						count++;
					}

					if (count > max) {
						max = count;
						arr[0] = i;
						arr[1] = j;
					}
				}
			}
		}
		if (max == 0) {
			arr[0] = -1;
			arr[1] = -1;
		}
		return arr;
	}

	private void configOutput() {
		File file = new File(OUT);
		if (file.exists()) {
			file.delete();
		}
		try {
			out = new PrintWriter(new File(OUT));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void configInput() {
		// TODO Auto-generated method stub
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void run() throws Exception {
		configInput();
		configOutput();
		solve(0);
		// in.close();
		// out.close();
	}

	public static void main(String args[]) throws Exception {
		new Misa().run();
	}

	public void pl(Object inp) {
		System.out.println(inp);
	}

	public void p(Object inp) {
		System.out.print(inp);
	}

	public void fpl(Object inp) {
		out.println(inp);
	}

	public void fp(Object inp) {
		out.print(inp);
	}

	public int s2int(String v) {
		return Integer.valueOf(v);
	}

	public int[] sarr2IntArr(String[] arr) {
		int[] a = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			a[i] = s2int(arr[i]);
		}

		return a;
	}

	public long[] sarr2LongArr(String[] arr) {
		long[] a = new long[arr.length];
		for (int i = 0; i < arr.length; i++) {
			a[i] = s2long(arr[i]);
		}

		return a;
	}

	public long s2long(String v) {
		return Long.valueOf(v);
	}
}