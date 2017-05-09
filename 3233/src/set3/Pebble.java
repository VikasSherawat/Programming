package set3;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Pebble {
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
	int cnt;

	private void solve(int TURN) throws Exception {
		int ans = 0;
		String s = br.readLine();
		char[] a = new char[15];
		Arrays.fill(a, '-');
		for (int i = 0; i < s.length(); i++) {
			a[i] = s.charAt(i);
		}
		recursive(a);
		System.out.println(cnt);

	}

	void recursive(char a[]) {
		char[] org = new char[15];
		copyArray(org, a);
		// strcpy (org, a);

		for (int i = 0; i < 11; i++) {
			if (a[i] == 'o' && a[i + 1] == 'o') {
				if (i + 2 < 12 && a[i + 2] == '-') {
					a[i + 2] = 'o';
					a[i] = a[i + 1] = '-';
					recursive(a);
					copyArray(a,org);
					// strcpy (a, org);
				}
				if (i - 1 >= 0 && a[i - 1] == '-') {
					a[i - 1] = 'o';
					a[i] = a[i + 1] = '-';
					recursive(a);
					copyArray(a,org);
					// strcpy (a, org);
				}
			}
		}

		int c = 0;

		for (int i = 0; i < 12; i++) {
			if (a[i] == 'o')
				c++;
		}

		if (c < cnt)
			cnt = c;
	}

	private void copyArray(char[] org, char[] a) {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.length; i++) {
			org[i]=a[i];
		}

	}

	private int where2go(char[] a, int idx, int j) {
		// TODO Auto-generated method stub
		if (idx - 3 >= 0 && a[idx - 2] == '-' && a[idx - 3] == 'o') {
			return 0;
		}

		if (idx + 3 < a.length && a[idx + 2] == '-' && a[idx + 3] == 'o') {
			return 1;
		}
		return -1;
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void run() throws Exception {
		configInput();
		configOutput();
		int t = Integer.valueOf(br.readLine());
		for (int i = 1; i <= t; i++) {
			// out.print("Case #" + i + ": ");
			cnt = 100;
			solve(i);
		}
		// in.close();
		// out.close();
	}

	public static void main(String args[]) throws Exception {
		new Pebble().run();
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