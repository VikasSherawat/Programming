package codejam2017;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class B {
	static final String FILENAME = "";
	static final String QUESTION = "B-";
	static final String SIZE = "large";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + QUESTION + SIZE + ".in";
	static final String OUT = FILEPATH + QUESTION + SIZE + "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;
	BufferedReader br;

	private void solve(int TURN) throws Exception {

		long n = getLong();
		long ans = n < 10L ? n : findAns(n);
		fpl(FORMAT + TURN + SEMICOLON + ans);
	}

	private long findAns(long n) {
		// TODO Auto-generated method stub
		int len = String.valueOf(n).length();
		// String s = String.format("%20s", Integer.toBinaryString(i)).replace('
		// ', '0');
		String orgS = String.valueOf(n);
		String s = null;
		boolean flag = true;
		if(len==19)
			len--;
		while (flag) {
			for (int i = 9; i > 0; i--) {
				char c = Character.forDigit(i, 10);
				s = String.format("%" + len + "s", String.valueOf(i)).replace(' ', c);
				if (n - Long.valueOf(s) >= 0) {
					flag = false;
					break;
				}
			}
			len--;
		}
		if (s.length() != orgS.length()) {
			return Long.parseLong(s);
		}

		int[] org = getArray(orgS);
		int[] a = getArray(s);
		for (int i = 1; i < a.length; i++) {
			int[] cpy = a.clone();
			for (int j = 9; j >= a[i]; j--) {
				Arrays.fill(cpy, i, a.length, j);
				if (comp(cpy, org)) {
					a = cpy;
					break;
				}
			}
		}
		return Long.parseLong(getString(a));
	}

	private boolean comp(int[] cpy, int[] org) {
		// TODO Auto-generated method stub
		String b = getString(org);
		String a = getString(cpy);
		if (b.toString().compareTo(a.toString()) >= 0)
			return true;
		else
			return false;
	}

	private String getString(int[] arr) {
		StringBuilder a = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			a.append(arr[i]);
		}

		return a.toString();
	}

	private int[] getArray(String s) {
		// TODO Auto-generated method stub
		int[] a = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			a[i] = s.charAt(i) - '0';
		}
		return a;
	}

	private void run() throws Exception {
		configInput();
		configOutput();
		int t = getInt();
		for (int i = 1; i <= t; i++) {
			solve(i);
		}
		out.flush();
		out.close();
		br.close();
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