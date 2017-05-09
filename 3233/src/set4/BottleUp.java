package set4;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BottleUp {
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

	private void solve(int c, int a, int b) throws Exception {
		if (c % a == 0) {
			System.out.println(c / a + " " + 0);
			return;
		}
		int x = 0, y = 0, xx= 0, yy = 0;
		int min = Integer.MAX_VALUE;

		if (c % b == 0) {
			// System.out.println(0 + " " + c / b);
			min = Math.min(min, c / b);
			xx = 0;
			yy = c / b;
			// return;
		}
		for (int i = 1; i * b <= c; i++) {
			if ((c - i * b) % a == 0) {
				y = i;
				x = (c - i * b) / a;
				//min = y+x;
				if (min > y + x){
					xx = x;
					yy = i;
					min = y+x;
				}
					
			}
		}

		if (min != Integer.MAX_VALUE)
			System.out.println(xx + " " + yy);
		else
			System.out.println("Impossible");

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
		int[] a = sarr2IntArr(br.readLine().split("\\s+"));
		solve(a[0], a[1], a[2]);
		// in.close();
		// out.close();
	}

	public static void main(String args[]) throws Exception {
		new BottleUp().run();
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