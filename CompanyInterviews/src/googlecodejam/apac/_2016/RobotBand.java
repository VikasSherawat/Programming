package googlecodejam.apac._2016;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RobotBand {

	static final String FILENAME = "practice";
	static final String QUESTION = "B-";
	static final String SIZE = "large-";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + QUESTION + SIZE + FILENAME + ".in";
	static final String OUT = FILEPATH + QUESTION + SIZE + FILENAME + "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;
	BufferedReader br;

	private void solve(int TURN) throws IOException {
		long ans = 0l;
		int N = in.nextInt();
		int K = in.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		int[] c = new int[N];
		int[] d = new int[N];

		for (int i = 0; i < d.length; i++) {
			a[i] = in.nextInt();
		}
		for (int i = 0; i < d.length; i++) {
			b[i] = in.nextInt();
		}
		for (int i = 0; i < d.length; i++) {
			c[i] = in.nextInt();
		}
		for (int i = 0; i < d.length; i++) {
			d[i] = in.nextInt();
		}

		HashMap<Integer, Long> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				int ii = a[i] ^ b[j];
				if (map.containsKey(ii)) {
					map.put(ii, map.get(ii) + 1);
				} else {
					map.put(ii, 1l);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int x = c[i] ^ d[j] ^ K;
				if(map.containsKey(x))
					ans+=map.get(x);
			}
		}
		fpl(FORMAT + TURN + SEMICOLON + ans);
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
		File file = new File(IN);
		try {
			 in = new Scanner(file);
			//in = new Scanner(System.in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void run() throws Exception {
		configInput();
		configOutput();
		int t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			// out.print("Case #" + i + ": ");
			solve(i);
		}
		in.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new RobotBand().run();
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

}
