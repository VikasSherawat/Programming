package codejam2017;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class A {
	static final String FILENAME = "attempt0";
	static final String QUESTION = "A-";
	static final String SIZE = "Large";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + QUESTION + SIZE +".in";
	static final String OUT = FILEPATH + QUESTION + SIZE + "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;
	BufferedReader br;

	private void solve(int TURN) throws Exception {
		String[] arr = br.readLine().split("\\s+");

		StringBuilder sb = new StringBuilder(arr[0]);
		int k = Integer.valueOf(arr[1]);

		if (allHappy(sb)) {
			fpl(FORMAT + TURN + SEMICOLON + 0);
			return;
		}

		int ans = 0;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '+') {
				continue;
			}
			if (swap(sb, i, k)) {
				ans++;
			} else {
				fpl(FORMAT + TURN + SEMICOLON + "IMPOSSIBLE");
				return;
			}

		}
		
		fpl(FORMAT + TURN + SEMICOLON + ans);

		
	}

	private boolean swap(StringBuilder sb, int i, int k) {
		// TODO Auto-generated method stub
		if (i + k > sb.length())
			return false;
		else {
			for (int j = i; j < i + k; j++) {
				if (sb.charAt(j) == '-')
					sb.replace(j, j + 1, "+");
				else
					sb.replace(j, j + 1, "-");
			}

			return true;
		}
	}

	private boolean allHappy(StringBuilder s) {
		// TODO Auto-generated method stub
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '-')
				return false;
		}
		return true;
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
		out.close();
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
			FileReader fr = new FileReader(IN);
			br = new BufferedReader(fr);
			//br = new BufferedReader(new InputStreamReader(System.in));
			// in = new Scanner(System.in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws Exception {
		new A().run();
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
