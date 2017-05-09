package universityCodeSprint;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SpellNumber {
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
		String s = br.readLine();
		seperateNum(s);
	}

	private void seperateNum(String s) {
		// TODO Auto-generated method stub
		/*
		 * 1234 91011 99100 45035996273704964503599627370497
		 */
		int bn = 0, suf = 1, end = 1, st = 0;
		boolean flag = true;
		String ans = "";
		BigInteger _1 = BigInteger.ONE;
		while (suf < s.length()) {
			String pre = s.substring(0, suf);
			end = suf;
			int count = pre.length();
			flag = false;
			for (; end < s.length();) {
				String next = new BigInteger(pre).add(_1).toString();
				if(end+count>s.length()){
					flag = false;
					break;
				}
				String nm = s.substring(end, end+count);
				if (nm.equalsIgnoreCase(next)) {
					flag = true;
					if(bn==0){
						bn = 1;
						ans = new String(pre);
					}
					pre = next;
					end = end + next.length();
				} else {
					flag = false;
					if (new BigInteger(nm).compareTo(new BigInteger(next)) > 0) {
						break;
					}
					count++;
					continue;
				}
				
			}
			if (flag) {
				pl("YES" + " " + ans);
				return;
			}
			bn=0;
			suf++;
		}
		pl("NO");

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
			br = new BufferedReader(new InputStreamReader(System.in));
			// br = new BufferedReader(fr);
			// in = new Scanner(System.in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws Exception {
		new SpellNumber().run();
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