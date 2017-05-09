package googlecodejam.apac;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class GCube {
	static final String FILENAME = "practice";
	static final String QUESTION = "B-";
	static final String SIZE = "large-";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + QUESTION + SIZE + FILENAME + ".in";
	static final String OUT = FILEPATH + QUESTION + SIZE + FILENAME
			+ "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;

	private void solve(int TURN) {
		int ans = 0;
		int N = in.nextInt();
		int M = in.nextInt();
		int[] dimension = new int[N];

		for (int i = 0; i < dimension.length; i++) {
			dimension[i] = in.nextInt();
		}
		fpl(FORMAT + TURN + SEMICOLON);
		for (int i = 0; i < M; i++) {
			int L = in.nextInt();
			int R = in.nextInt();
			double y = findLength(dimension,L,R);
			out.format("%.9f%n",y);
		}
	}

	private double findLength(int[] dimension, int L, int R) {
		// TODO Auto-generated method stub
		int D = R-L+1;
		
		BigInteger big = BigInteger.ONE;
		
		for (int i = L; i <=R; i++) {
			big = big.multiply(BigInteger.valueOf(dimension[i]));
		}
		
		double logValue = findLog(big);
		
		double y = logValue/D;
		y = Math.pow(10, y);
		return y;
	}

	private double findLog(BigInteger big) {
		// TODO Auto-generated method stub
		int len  = big.toString().length()-1;
		BigInteger ten = BigInteger.TEN;
		BigInteger rem = big.divide(ten.pow(len));
		double logValue = Math.log10(rem.doubleValue());
		return len+logValue;
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
			//out.print("Case #" + i + ": ");
			solve(i);
		}
		in.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new GCube().run();
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
