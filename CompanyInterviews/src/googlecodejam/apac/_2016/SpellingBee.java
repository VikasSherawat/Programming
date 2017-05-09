package googlecodejam.apac._2016;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SpellingBee {
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

	private void solve(int TURN) {
		long ans = 1l;
		String s = in.next();
		if (s.length() == 1) {
			fpl(FORMAT + TURN + SEMICOLON + ans);
			return;
		}
		long M = 1000000000 + 7l;
		for (int i = 0; i < s.length(); i++) {
			if (i != 0 && i != s.length() - 1) {
				int count = 1;
				if (s.charAt(i) != s.charAt(i + 1)) {
					count++;
				}
				if (s.charAt(i) != s.charAt(i - 1)) {
					count++;
				}
				if(s.charAt(i)!=s.charAt(i+1) && s.charAt(i-1)==s.charAt(i+1))
					count--;
				ans *= count;
				ans %= M;

			} else if (i == 0) {
				if (s.charAt(i) != s.charAt(i + 1)) {
					ans *= 2;
					ans %= M;
				}
			} else {
				if (s.charAt(i) != s.charAt(i - 1)) {
					ans *= 2;
					ans %= M;
				}
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
		new SpellingBee().run();
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