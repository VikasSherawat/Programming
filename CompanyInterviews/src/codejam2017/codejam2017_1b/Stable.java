package codejam2017.codejam2017_1b;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Stable {
	static final String FILENAME = "attempt0";
	static final String QUESTION = "B-";
	static final String SIZE = "small-";
	static final String FILEPATH = "/home/vikas/Downloads/";
	static final String IN = FILEPATH + QUESTION + SIZE + FILENAME+ ".in";
	static final String OUT = FILEPATH + QUESTION + SIZE +FILENAME+ "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;
	BufferedReader br;

	private void solve(int TURN) throws Exception {
		int ans = 0;
		int[] arr = sarr2IntArr();
		int n = arr[0];
		int r = arr[1];
		int o = arr[2];
		int y = arr[3];
		int g = arr[4];
		int b = arr[5];
		int v = arr[6];
		char[] c = new char[n];
		Arrays.fill(c, 'a');
		int h = n / 2;
		if (r > h || o > h || y > h || g > h || b > h || v > h) {
			pl(FORMAT + TURN + SEMICOLON + "IMPOSSIBLE");
			return;
		}

	}
    private void allEqual(char[] arr, int max){
	    for(int i = 0; i < arr.length && max>0; i=i+3) {
	        arr[i]='R';
            arr[i+1]='Y';
            arr[i+2]='B';
	    }
    }
	private void fill(char[] arr, int max, char c){
        for(int i = 0; i < arr.length&&max>0; i++) {
            if(arr[i]=='a'){
                arr[i]=c;
                max--;
            }
        }
    }

    private void fillmax(char[] arr, int max, char c){
	    for(int i = 0; i < arr.length && max>0; i=i+2) {
            arr[i]=c;
            max--;
        }
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws Exception {
		new Stable().run();
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

