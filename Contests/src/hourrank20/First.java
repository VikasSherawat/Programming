package hourrank20;

/**
 * Created by vikas on 2/5/17.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class First {
	static final String FILENAME = "attempt0";
	static final String QUESTION = "A-";
	static final String SIZE = "small";
	static final String FILEPATH = "/home/vikas/Downloads/";
	static final String IN = FILEPATH + QUESTION + SIZE + ".in";
	static final String OUT = FILEPATH + QUESTION + SIZE + "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;
	BufferedReader br;

	private void solve(int TURN) throws Exception {
		int ans = 0;
        int[] a = sarr2IntArr();
        int min = 35, max = 95;
        for (int i = 35; i <=  95; i++) {
                if(i>=a[0] && i>=a[1] && i<=a[2] && i<=a[3]){
                    pl("YES");
                    return;
                }
        }
        pl("NO");
	}

	private void run() throws Exception {
		configInput();
		//configOutput();
		solve(0);
		br.close();
		//out.close();
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
			//br = new BufferedReader(fr);
			br = new BufferedReader(new InputStreamReader(System.in));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws Exception {
		new First().run();
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
