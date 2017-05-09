package contest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class _18 {
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
	static int t;

	private void solve(int TURN) throws Exception {
		int[][] a = new int[t][t];
		for (int i = 0; i < a.length; i++) {
			String[] b = br.readLine().split("\\s+");
			for (int j = 0; j < b.length; j++) {
				a[i][j] = getInt(b[j]);
			}
		}

		int[][] out = new int[t][t];
		for (int i = 0; i < out.length; i++) {
			out[i] = copyArray(a[i]);
		}
		out[0][0] = a[0][0];
		for (int i = 1; i < t; i++) {
			out[i][0] = a[i][0] + out[i - 1][0];
			out[i][i] = a[i][i] + out[i - 1][i - 1];
			for (int j = 1; j < i; j++) {
				out[i][j] = a[i][j] + (int) max(out[i - 1][j - 1], out[i - 1][j]);
			}
		}

		int max = -1;
		for (int j = 0; j < a[0].length; j++) {
			if (out[a.length - 1][j] > max) {
				max = out[a.length - 1][j];
			}
		}

		System.out.println(max);
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
			// FileReader fr = new FileReader(IN);
			br = new BufferedReader(new InputStreamReader(System.in));
			// br = new BufferedReader(fr);
			// in = new Scanner(System.in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void run() throws Exception {
		configInput();
		configOutput();
		int n = getInt();
		for (int i = 1; i <= n; i++) {
			t = getInt();
			solve(i);
		}
		// in.close();
		// out.close();
	}

	public static void main(String args[]) throws Exception {
		new _18().run();
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

	public int getInt() throws NumberFormatException, IOException {
		return Integer.valueOf(br.readLine());
	}

	public int getInt(String i) {
		return Integer.valueOf(i);
	}

	public int[] sarr2IntArr() throws IOException {
		String[] arr = br.readLine().split("\\s+");
		int[] a = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			a[i] = getInt(arr[i]);
		}

		return a;
	}

	public long[] sarr2LongArr() throws IOException {
		String[] arr = br.readLine().split("\\s+");
		long[] a = new long[arr.length];
		for (int i = 0; i < arr.length; i++) {
			a[i] = getLong(arr[i]);
		}

		return a;
	}

	public long getLong(String i) {
		return Long.valueOf(i);
	}

	public long getLong() throws NumberFormatException, IOException {
		return Long.valueOf(br.readLine());
	}

	public double getDouble() throws NumberFormatException, IOException {
		return Double.valueOf(br.readLine());
	}

	public long max(int a, int b) {
		return Math.max(a, b);
	}

	public long min(int a, int b) {
		return Math.min(a, b);
	}

	public int[] copyArray(int[] a) {
		int[] arr = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			arr[i] = a[i];
		}
		return arr;
	}

	public int intFromChar(char c) {
		return Character.getNumericValue(c);
	}
}