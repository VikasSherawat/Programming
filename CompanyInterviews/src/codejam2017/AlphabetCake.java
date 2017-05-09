package codejam2017;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AlphabetCake {
	static final String FILENAME = "practice";
	static final String QUESTION = "A-";
	static final String SIZE = "large-";
	static final String FILEPATH = "/home/vikas/Downloads/";
	static final String IN = FILEPATH + QUESTION + SIZE +FILENAME+ ".in";
	static final String OUT = FILEPATH + QUESTION + SIZE +FILENAME+"-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;
	BufferedReader br;

	private void solve(int TURN) throws Exception {
		int[] mat = sarr2IntArr();
		int r = mat[0], c = mat[1];
		char[][] arr = new char[r][c];
		for (int i = 0; i < r; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		char[][] dup = arr.clone();
		boolean qPresent = true;

		for (int i = 0; i < r; i++) {
			char prev = 'a';
			for (int j = 0; j < c; j++) {
				if (dup[i][j] == '?') {
					if (prev == 'a') {
						char ch = findLetter(dup[i]);
						if(ch==prev)
							break;
						prev = ch;
					}
					dup[i][j] = prev;
				} else {
					prev = dup[i][j];
				}
			}
		}

		while (qPresent) {
			qPresent = false;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (dup[i][j] == '?') {
						qPresent = true;
						if(i>0 && dup[i-1][j]!='?'){
							dup[i] = dup[i-1];
							break;
						}else if(i<r-1 && dup[i+1][j]!='?'){
							dup[i]=dup[i+1];
							break;
						}else{
							break;
						}
					}
				}
			}
		}
		
		

		fpl(FORMAT + TURN + SEMICOLON);
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				fp(dup[i][j]);
			}
			//if(i!=r-1)
			out.println();
			
		}
	}

	private char findLetter(char[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != '?')
				return arr[i];
		}
		return 'a';
	}

	private void run() throws Exception {
		configInput();
		configOutput();
		int t = getInt();
		for (int i = 1; i <= t; i++) {
			// out.print("Case #" + i + ": ");
			solve(i);
		}
		System.out.println("Program Completed");
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
		new AlphabetCake().run();
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
