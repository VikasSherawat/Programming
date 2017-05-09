package kickstart.roundA;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class B {
	static final String FILENAME = "attempt0";
	static final String QUESTION = "B-";
	static final String SIZE = "small-";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + QUESTION + SIZE + FILENAME + ".in";
	static final String OUT = FILEPATH + QUESTION + SIZE + FILENAME + "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;
	BufferedReader br;

	private void solve(int TURN) throws Exception {
		boolean ans = false;
		String p = br.readLine();
		String t = br.readLine();
		char[] ap = getArray(p);
		char[] at = getArray(t);
		ans = compare(ap, at);
		String a = ans ? "TRUE" : "FALSE";
		pl(FORMAT + TURN + SEMICOLON + a);
	}

	private boolean compare(char[] ap, char[] at) {
		// TODO Auto-generated method stub
		int n = ap.length;
		int m = at.length;

		for (int i = 0; i < Math.min(n, m); i++) {
			if (ap[i] == '_' || at[i] == '_')
				continue;
			if (ap[i] != at[i]) {
				return false;
			}
		}

		if (m != n) {
			if (m < n) {
				for (int i = m; i < n; i++) {
					if (ap[i] != '_') {
						return false;
					}
				}
			} else {
				for (int i = n; i < m; i++) {
					if (at[i] != '_') {
						return false;
					}
				}
			}
		}

		return true;
	}

	private char[] getArray(String s) {
		// TODO Auto-generated method stub
		List<Character> ls = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != '*') {
				ls.add(c);
			} else {
				for (int j = 0; j < 4; j++) {
					ls.add('_');
				}
			}
		}
		char[] a = new char[ls.size()];
		for (int i = 0; i < a.length; i++) {
			a[i] = ls.get(i);
		}
		return a;
	}

	private void run() throws Exception {
		configInput();
		configOutput();
		int t = getInt();
		for (int i = 1; i <= t; i++) {
			// out.print("Case #" + i + ": ");
			solve(i);
		}
		br.close();
		// out.close();
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
			//br = new BufferedReader(new FileReader(IN));
			br = new BufferedReader(new InputStreamReader(System.in));
			// in = new Scanner(System.in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws Exception {
		new B().run();
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