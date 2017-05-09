package contest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class _35 {
	static final String FILENAME = "practice";
	static final String QUESTION = "A-";
	static final String SIZE = "large-";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + QUESTION + SIZE + FILENAME + ".in";
	static final String OUT = FILEPATH + QUESTION + SIZE + FILENAME + "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	int t;
	PrintWriter out;
	BufferedReader br;
	List<Integer> list = new ArrayList<Integer>();

	private void solve(int t) throws Exception {
		int ans = 0;
		for (int i = 0; i<list.size() && list.get(i) < t; i++) {
			
			if (isCircular(list.get(i))) {
				ans += list.get(i);
				//p(list.get(i) + " ");
			}
		}
		pl(ans);
	}

	private boolean isCircular(int n) {
		// TODO Auto-generated method stub
		if (n < 19) {
			return true;
		}

		String s = String.valueOf(n);
		/*for (int i = 0; i < s.length(); i++) {
			if (Integer.valueOf(s.substring(i, i + 1)) % 2 == 0) {
				return false;
			}
			if (Integer.valueOf(s.substring(i, i + 1)) % 5 == 0) {
				return false;
			}
		}*/
		int len = s.length();
		int m = n;
		int count = len - 1;
		while (count-- > 0) {
			int div = (int) Math.pow(10, len - 1);
			int rem = m % div;
			m /= div;
			div = (int) Math.pow(10, String.valueOf(m).length());
			m = rem * (div) + m;
			if (Collections.binarySearch(list, m) < 0) {
				return false;
			}

		}
		// pl(n);

		return true;
	}

	private void init() {
		// TODO Auto-generated method stub
		getPrime(t);
	}

	private List<Integer> getPrime(int n) {
		// TODO Auto-generated method stub
		list.add(2);
		list.add(3);
		list.add(5);
		int i = 7, w = 4;
		while (i < n) {
			if (isPrime(i)) {
				list.add(i);
			}
			i += w;
			w = 6 - w;
		}
		return list;
	}

	private static boolean isPrime(int n) {
		// TODO Auto-generated method stubif(
		String s = String.valueOf(n);
		for (int i = 0; i < s.length(); i++) {
			if (Integer.valueOf(s.substring(i, i + 1)) % 2 == 0) {
				return false;
			}
			if (Integer.valueOf(s.substring(i, i + 1)) % 5 == 0) {
				return false;
			}
		}
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	private void run() throws Exception {
		configInput();
		configOutput();
		t = Integer.valueOf(br.readLine());
		init();
		solve(t);
		
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
		new _35().run();
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