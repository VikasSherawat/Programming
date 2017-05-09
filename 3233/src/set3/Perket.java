package set3;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Perket {
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
	int cnt = 1000000000;

	private void solve(int[][] a) throws Exception {
		int c = a.length;
		for (int i = 1; i < (1 << c); i++) {
	        int ts = 1, tb = 0;
	        for (int j = 0; j < c; j++) {
	            if ((i & (1 << j)) > 0) { 
	                ts *= a[j][0];
	                tb += a[j][1];
	            }
	        }
	        cnt = Math.min(cnt, Math.abs(ts - tb));
	    }
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
		int t = Integer.valueOf(br.readLine());
		int[][] a = new int[t][2];
		for (int i = 1; i <= t; i++) {
			// out.print("Case #" + i + ": ");
			a[i-1] = sarr2IntArr(br.readLine().split("\\s+"));
		}
		solve(a);
		System.out.println(cnt);
		// in.close();
		// out.close();
	}

	public static void main(String args[]) throws Exception {
		new Perket().run();
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