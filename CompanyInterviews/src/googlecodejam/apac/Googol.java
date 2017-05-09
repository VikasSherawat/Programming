package googlecodejam.apac;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Googol {
	static final String FILENAME = "practice";
	static final String QUESTION = "A-";
	static final String SIZE = "large-";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + QUESTION + SIZE + FILENAME + ".in";
	static final String OUT = FILEPATH + QUESTION + SIZE + FILENAME
			+ "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;
	StringBuilder sb;

	private void solve(int TURN) {
		Long b = in.nextLong();
		
		int ans = sol(b);
		fpl(FORMAT + TURN + SEMICOLON + ans);
	}

	int sol(Long k) {
	    if ((k&(k-1))==0)
	        return 0;
	    Long a = 1l;
	    while (a < k)
	        a <<= 1;
	    return 1-sol(a-k);
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
			//in = new Scanner(file);
			in = new Scanner(System.in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void run() throws Exception {
		configInput();
		configOutput();
		int t = in.nextInt();
		//initialize();
		for (int i = 1; i <= t; i++) {
			// out.print("Case #" + i + ": ");
			solve(i);
		}
		in.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new Googol().run();
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
