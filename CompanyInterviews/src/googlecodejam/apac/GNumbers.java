package googlecodejam.apac;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GNumbers {
	static final String FILENAME = "practice";
	static final String QUESTION = "C-";
	static final String SIZE = "large-";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + QUESTION + SIZE + FILENAME + ".in";
	// static final String IN = FILEPATH + "100.txt";
	static final String OUT = FILEPATH + QUESTION + SIZE + FILENAME
			+ "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;

	private void solve(int TURN) {
		int ans = 0;
		BigInteger big = in.nextBigInteger();
		// pl(big);
		int result = findWinner(big, 0);
		if (result == 1)
			fpl(FORMAT + TURN + SEMICOLON + "Seymour");
		else
			fpl(FORMAT + TURN + SEMICOLON + "Laurence");
	}

	private int findWinner(BigInteger big, int count) {
		// TODO Auto-generated method stub
		if (big.equals(BigInteger.ONE) || isGNumber(big)) {
			return 1 - count;
		} else {
			// pl("hi");
			List<Long> factors = findFactors(big);
			for (int i = factors.size() - 1; i >= 0; i--) {
				BigInteger dup = new BigInteger(big.toString());
				long val = factors.get(i);
				while (dup.remainder(BigInteger.valueOf(val)).equals(
						BigInteger.ZERO)) {
					dup = dup.divide(BigInteger.valueOf(val));
				}
				if (dup.equals(BigInteger.ONE) || isGNumber(dup)) {
					if (count == 0) {
						return 0;
					} else {
						return 1;
					}
				}
			}
			int result = count;
			for (int i = 0; i < factors.size(); i++) {
				long val = factors.get(i);
				BigInteger dup = new BigInteger(big.toString());
				while (dup.remainder(BigInteger.valueOf(val)).equals(
						BigInteger.ZERO)) {
					dup = dup.divide(BigInteger.valueOf(val));
				}
				result = findWinner(dup, 1 - count);
				if(result == 0)
					return result;
			}

		return 	1;
		}
	}

	private List<Long> findFactors(BigInteger n) {
		// TODO Auto-generated method stub
		List<Long> set = new ArrayList<Long>();
		if (n.remainder(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0) {
			set.add(2l);
			while (n.remainder(BigInteger.valueOf(2))
					.compareTo(BigInteger.ZERO) == 0) {
				n = n.divide(BigInteger.valueOf(2));
			}

		}

		if (n.remainder(BigInteger.valueOf(3)).compareTo(BigInteger.ZERO) == 0) {
			set.add(3l);
			while (n.remainder(BigInteger.valueOf(3))
					.compareTo(BigInteger.ZERO) == 0) {
				n = n.divide(BigInteger.valueOf(3));
			}
		}

		BigInteger i = BigInteger.valueOf(5);
		BigInteger w = BigInteger.valueOf(2);
		BigInteger six = BigInteger.valueOf(6);

		if (isPrime(n)) {
			set.add(n.longValue());
			return set;
		}

		while (i.compareTo(n) <= 0) {
			if (n.remainder(i).equals(BigInteger.ZERO)) {
				set.add(i.longValue());
				while (n.remainder(i).equals(BigInteger.ZERO)) {
					n = n.divide(i);
				}
			}
			i = i.add(w);
			w = six.subtract(w);
		}
		return set;
	}

	private boolean isGNumber(BigInteger big) {
		// TODO Auto-generated method stub
		int sum = 0;
		String inp = big.toString();
		for (int i = 0; i < inp.length(); i++) {
			sum += Character.getNumericValue(inp.charAt(i));
		}
		BigInteger b = new BigInteger(String.valueOf(sum));
		if (b.equals(BigInteger.ONE))
			return true;

		return isPrime(b);
	}

	private boolean isPrime(BigInteger n) {

		BigInteger i = BigInteger.valueOf(5);
		BigInteger w = BigInteger.valueOf(2);
		BigInteger six = BigInteger.valueOf(6);
		BigInteger two = BigInteger.valueOf(2);
		BigInteger three = BigInteger.valueOf(3);

		if (n.equals(two) || n.equals(three)) {
			return true;
		}

		if (n.remainder(two).equals(BigInteger.ZERO)
				|| n.equals(BigInteger.ONE)) {
			return false;
		}

		if (n.remainder(three).equals(BigInteger.ZERO)) {
			return false;
		}

		while (i.multiply(i).compareTo(n) <= 0) {
			if (n.remainder(i).equals(BigInteger.ZERO)) {
				return false;
			}

			i = i.add(w);
			w = six.subtract(w);
		}
		return true;
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
		new GNumbers().run();
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
