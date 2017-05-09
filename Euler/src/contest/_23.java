package contest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class _23 {
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
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static ArrayList<Integer> abun= new ArrayList<Integer>();
	static HashSet<Integer> set = new HashSet<Integer>();
	
	
	private static void init(){
		getPrime(400);
		getAbundantNumber();
		//makeSum();
	}
	
	private static void makeSum() {
		// TODO Auto-generated method stub
		for (int i = 0; i < abun.size()-1; i++) {
			for (int j = i; j < abun.size(); j++) {
				set.add(abun.get(i)+abun.get(j));
			}
		}
	}

	private void solve(int TURN) throws Exception {
		int n = getInt();
		boolean flag = false;
		for (int i = 0; i < abun.size() && abun.get(i)<n;i++) {
			int start = abun.get(i);
			int key = n-start;
			if(key<start)
				break;
			
			if(Collections.binarySearch(abun, key)>=0){
				flag = true;
				break;
			}
		}
		pl(flag?"YES":"NO");
	}
	
	private static void getAbundantNumber() {
		// TODO Auto-generated method stub
		abun.add(12);
		for (int i = 13; i <=100000 ; i++) {
			int d = divSum(i);
			if(d>i){
				abun.add(i);
			}
		}
		
	}
	
	private static int divSum(int n) {
		// TODO Auto-generated method stub
		// sum of divisors = [2^(7+1) –1]/(2–1) × [3^(2+1) –1]/(3–1) × [7^(1+1)
		// –1]/(7–1)
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		int m1 = n;
		for (int i = 0; i < list.size(); i++) {
			int y = list.get(i);
			if (y > n) {
				break;
			}

			if (n % y == 0) {
				int count = 0;
				while (n % y == 0) {
					n /= y;
					count++;
				}
				map.put(y, count);
			}
		}

		long sum = 1l;
		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			int key = m.getKey();
			int val = m.getValue();
			long prod = (long) Math.pow(key, val+1)-1;
			--key;
			prod /=(key);
			sum *= prod;
		}
		
		return (int) (sum-m1);

	}
	
	private static void getPrime(int n) {
		// TODO Auto-generated method stub
		list.add(2);
		list.add(3);
		int i = 5, w = 2;
		while (i < n) {
			if (isPrime(i)) {
				list.add(i);
			}
			i += w;
			w = 6 - w;
		}
	}

	private static boolean isPrime(int n) {
		// TODO Auto-generated method stubif(
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
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
		init();
		int t = getInt();
		for (int i = 1; i <= t; i++) {
			// out.print("Case #" + i + ": ");
			solve(i);
		}
		// in.close();
		// out.close();
	}

	public static void main(String args[]) throws Exception {
		long start = System.currentTimeMillis();
		new _23().run();
		//System.out.println((System.currentTimeMillis()-start)/1000);
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
		return c - '0';
	}
}
