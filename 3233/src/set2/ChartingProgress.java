package set2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ChartingProgress {
	static final String FILENAME = "practice";
	static final String QUESTION = "B-";
	static final String SIZE = "small-";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + QUESTION + SIZE + FILENAME + ".in";
	Scanner in;
	BufferedReader br;
	PrintWriter out;

	private void solve() throws IOException {
		int ans = 0;
		ArrayList<String> s = new ArrayList<String>();

		String line = null;
		while ((line = br.readLine()) != null) {
			if (line.length() > 1)
				s.add(line);
			else {
				String[] arr = s.toArray(new String[s.size()]);
				logPrint(arr);
				s = new ArrayList<String>();
			}
		}

		String[] arr = s.toArray(new String[s.size()]);
		logPrint(arr);

		// System.out.println("\n");
	}

	private void logPrint(String[] arr) {
		// TODO Auto-generated method stub
		char[][] op = new char[arr.length][arr[0].length()];
		int last = -1;
		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(op[i], '.');
			int star = countStar(arr[i]);
			if (last == -1) {
				last = arr[i].length() - 1;
			}

			if (star != 0) {
				if (last + 1 - star >= 0 && last< arr[i].length())
					Arrays.fill(op[i], last + 1 - star, last + 1, '*');
				last -= star;
			}
		}

		for (int i = 0; i < op.length; i++) {
			pl(String.valueOf(op[i]));
		}
		System.out.println();

	}

	private int countStar(String s) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '*')
				count++;
		}
		return count;
	}

	private void run() throws Exception {
		// br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new FileReader(IN));
		solve();
	}

	public static void main(String args[]) throws Exception {
		new ChartingProgress().run();
	}

	public void pl(Object inp) {
		System.out.println(inp);
	}

	public void p(Object inp) {
		System.out.print(inp);
	}

}
