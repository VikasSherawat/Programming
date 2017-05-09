package set3;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Sums {
	static final String FILENAME = "practice";
	static final String QUESTION = "A-";
	static final String SIZE = "large-";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + "test.txt";
	static final String OUT = FILEPATH + QUESTION + SIZE + FILENAME + "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;
	BufferedReader br;

	private void solve(int TURN) throws Exception {
		int ct = 1;
		while (in.hasNext()) {
			int N = in.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = in.nextInt();
			}

			Arrays.sort(arr);
			int Q = in.nextInt();
			System.out.println("Case " + ct + ":");
			while (Q-- > 0) {
				int c = in.nextInt();
				int ans = closest(c, arr);
				System.out.println("Closest sum to " + c + " is " + ans + ".");
			}
			ct++;
		}
	}

	private int closest(int c, int[] arr) {
		// TODO Auto-generated method stub
		int i = 0, j = arr.length - 1, ans = 0;
		int close = Integer.MAX_VALUE;
		if (arr[arr.length - 1] + arr[arr.length - 2] <= c) {
			return arr[arr.length - 1] + arr[arr.length - 2];
		}

		if (c <= arr[0]) {
			return arr[0] + arr[1];
		}

		for (i = 0; i < j;) {
			int sum = arr[i] + arr[j];
			if (Math.abs(sum - c) < close) {
				close = Math.abs(sum - c);
				ans = sum;
				if (sum > c)
					j--;
				else {
					i++;
				}
			} else {
				if (sum > c)
					j--;
				else
					i++;
			}
		}
		return ans;
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
			//FileReader fr = new FileReader(IN);
			br = new BufferedReader(new InputStreamReader(System.in));
			// br = new BufferedReader(fr);
			in = new Scanner(new File(IN));
			//in = new Scanner(System.in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void run() throws Exception {
		configInput();
		configOutput();
		solve(0);
		in.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new Sums().run();
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
