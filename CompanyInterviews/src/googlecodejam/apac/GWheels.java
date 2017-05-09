package googlecodejam.apac;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GWheels {
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
		int nP = in.nextInt();
		int nE = in.nextInt();
		int nT = in.nextInt();
		
		long[] pArr = new long[nP];
		for (int i = 0; i < nP; i++) {
			pArr[i] = in.nextLong();
		}
		
		long[] eArr = new long[nE];
		for (int i = 0; i < nE; i++) {
			eArr[i] = in.nextLong();
		}
		
		long[] tArr = new long[nT];
		for (int i = 0; i < nT; i++) {
			tArr[i] = in.nextLong();
		}
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < nE; i++) {
			for (int j = 0; j < nE; j++) {
				if(i!=j){
					long gcd = eArr[i]>=eArr[j]?findGCD(eArr[i], eArr[j]):findGCD(eArr[j],eArr[i]);
					long n1 = eArr[i]/gcd;
					long n2 = eArr[j]/gcd;
					set.add(n1+"/"+n2);
				}
			}
		}
		
		
		int M = in.nextInt();
		fpl(FORMAT + TURN + SEMICOLON);
		while(M-->0){
			int P = in.nextInt();
			int Q = in.nextInt();
			findRatio(pArr,eArr,tArr,P,Q,set);
		}
		
	}


	
	private void findRatio(long[] pArr, long[] eArr, long[] tArr, int p, int q,
			Set<String> set) {
		// TODO Auto-generated method stub
		for (int i = 0; i < pArr.length ; i++) {
			for (int j = 0; j < tArr.length; j++) {
				long r1 = p*tArr[j];
				long r2 = q*pArr[i];
				long gcd = r1>=r2?findGCD(r1, r2):findGCD(r2, r1);
				r1 /=gcd;
				r2 /=gcd;
				if(set.contains(r1+"/"+r2)){
					fpl("Yes");
					return;
				}
				
			}
		}
		
		fpl("No");
	}



	private long findGCD(long a, long b){
		if(b==0)
			return (long) a;
		
		if(a<b)
			return 1;
		
		return findGCD(b, a%b);
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
		new GWheels().run();
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
