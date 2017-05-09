package set4;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Commercial {
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

	private void solve(int n, int p, int[] a) throws Exception {
		int ans = 0;
		int max = 0, mhere = 0;
		for (int i = 0; i < a.length; i++) {
			int diff = a[i]-p;
			if(mhere + diff <0){
				mhere =0;
				max = Math.max(max, mhere);
			}else{
				mhere += diff;
			}
			
			if(mhere > max)
				max = mhere;
		}
		
		//max = Math.max(max, mhere);
		
		System.out.println(max);
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
			//br = new BufferedReader(fr);
			//in = new Scanner(System.in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void run() throws Exception {
		configInput();
		configOutput();
		int[] b = sarr2IntArr(br.readLine().split("\\s+"));
		int n = b[0];
		int p = b[1];
		int[] a = sarr2IntArr(br.readLine().split("\\s+"));
		solve(n,p,a);
		//in.close();
		//out.close();
	}

	public static void main(String args[]) throws Exception {
		new Commercial().run();
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
