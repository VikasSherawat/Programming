package googlecodejam.apac._2016.b;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class B {
	static final String FILENAME = "practice";
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
	long MOD = 1000000000 + 7l;

	private void solve(int TURN) throws Exception {
		long res = 0l;
		long[] ar = sarr2LongArr();
		long A = ar[0];
		long B = ar[1];
		long N = ar[2];
		long K = ar[3];
		int nn = 100000+1;
		long[] i_A = new long[nn];
		long[] j_B = new long[nn];
		long[] i_j_same = new long[nn];
		for (int p = 1; p <= Math.min(N, K); p++) {
			long cnt = ((N - p) / K + 1) % MOD;
			long tmp_A = pow_mod(p, A, K), tmp_B = pow_mod(p, B, K);
			i_A[(int) tmp_A] += cnt;
			j_B[(int) tmp_B] += cnt;
			if ((tmp_A + tmp_B) % K == 0) // (0 + 0) != K, but (0 + 0) % K == 0
				i_j_same[p % (int) K] += cnt;
		}

		for (int p = 0; p < K; p++) {
			int q = (int) ((K - p) % K); // Convert (0, K) to (0, 0)
			res += ((i_A[p] % MOD) * (j_B[q] % MOD)) % MOD;
			res -= i_j_same[p];
			res %= MOD;
		}

		res += MOD;
		res %= MOD;

		fpl(FORMAT + TURN + SEMICOLON + res);
	}

	private long howMany(long i, long n, long k) {
		// TODO Auto-generated method stub
		long ans = 0l;
		ans = (n - i) / k + 1;

		return ans;
	}

	long pow_mod(long base_value, long exponent, long modulus) {
		base_value = base_value % modulus;
		long result = 1;
		while (exponent > 0) {
			if (exponent % 2 == 1)
				result = (result * base_value) % modulus;
			base_value = (base_value * base_value) % modulus;
			exponent = exponent / 2;
		}
		return result;
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
			// br = new BufferedReader(new InputStreamReader(System.in));
			br = new BufferedReader(fr);
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
