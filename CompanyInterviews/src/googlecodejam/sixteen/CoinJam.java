package googlecodejam.sixteen;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/*
 * Problem

 A jamcoin is a string of N>= 2 digits with the following properties:

 Every digit is either 0 or 1.
 The first digit is 1 and the last digit is 1.
 If you interpret the string in any base between 2 and 10, inclusive, the resulting number is not prime.
 Not every string of 0s and 1s is a jamcoin. For example, 101 is not a jamcoin; 
 its interpretation in base 2 is 5, which is prime. But the string 1001 is a jamcoin: 
 in bases 2 through 10, its interpretation is 9, 28, 65, 126, 217, 344, 513, 730, 
 and 1001, respectively, and none of those is prime.

 We hear that there may be communities that use jamcoins as a form of currency. When sending someone a jamcoin, it is polite to prove that the jamcoin 
 is legitimate by including a nontrivial divisor of that jamcoin's interpretation in each base from 2 to 10. (A nontrivial divisor for a positive integer K is some positive integer other than 1 or K that evenly divides K.) For convenience, these divisors must be expressed in base 10.

 For example, for the jamcoin 1001 mentioned above, a possible set of nontrivial divisors for the base 2 through 10 interpretations of the jamcoin would be: 3, 7, 5, 6, 31, 8, 27, 5, and 77, respectively.

 Can you produce J different jamcoins of length N, along with proof that they are legitimate?

 Input

 The first line of the input gives the number of test cases, T. T test cases follow; each consists of one line with two integers N and J.
 */
public class CoinJam {
	static Set<Long> set = new TreeSet<Long>();

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt(), J = in.nextInt();
			List<String> list = solve(N, J);
			PrintWriter out = null;
			try {
				out = new PrintWriter(new FileWriter("output.txt", true),
						true);
				out.flush();
				out.write("Case #1:\n");
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				out.close();
			}
			for (String sb : list) {
				printResult(sb);
				System.out.println();
			}
		}

	}

	private static void printResult(String sb) {
		// TODO Auto-generated method stub
		List<Long> result = new ArrayList<Long>();
		for (int i = 2; i < 11; i++) {
			result.add(convertToSystem(sb, i));
		}
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("output.txt", true),
					true);
			out.flush();
			out.write(sb+" ");
			out.write(Arrays.toString(result.toArray())
					.replaceAll("[\\[\\]]", "").replaceAll(",", " "));
			out.write("\n");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
		
		System.out.print(sb + " ");
		System.out.print(Arrays.toString(result.toArray())
				.replaceAll("[\\[\\]]", "").replaceAll(",", " "));
	}

	private static long convertToSystem(String inp, int base) {
		// TODO Auto-generated method stub
		BigInteger num = new BigInteger(inp, base);
		Iterator<Long> iter = set.iterator();
		while (iter.hasNext()) {
			long div = iter.next();
			if (num.remainder(BigInteger.valueOf(div)).equals(BigInteger.ZERO)) {
				return div;
			}
		}
		return -1;
	}

	private static List<String> solve(int N, int J) {
		// TODO Auto-generated method stub
		long runTime = (long) Math.pow(2, N - 2);
		List<String> result = new ArrayList<String>();
		for (long i = 0; i <= runTime && J != result.size(); i++) {
			StringBuilder str = new StringBuilder();
			str.append("1");
			String binaryString = String
					.format("%" + Integer.toString(N - 2) + "s",
							Long.toBinaryString(i)).replace(" ", "0");
			str.append(binaryString);
			str.append("1");
			if (ifCoinJam(str)) {
				result.add(str.toString());
			}

		}
		return result;
	}

	private static boolean ifCoinJam(StringBuilder str) {
		// TODO Auto-generated method stub

		for (int i = 2; i < 11; i++) {
			if (checkIfPrime(str, i))
				return false;
		}
		return true;
	}

	private static boolean checkIfPrime(StringBuilder str, int base) {
		// TODO Auto-generated method stub
		int len = str.length();
		String inp = str.toString();
		BigInteger num = new BigInteger(inp, base);
		// System.out.println("Num is "+num +" in base:"+base);
		if (checkIfComposite(num)) {
			return false;
		}
		return true;
	}

	private static boolean checkIfComposite(BigInteger num) {
		// TODO Auto-generated method stub
		for (int i = 3; i < 1000; i++) {
			if (num.remainder(BigInteger.valueOf(i)) == BigInteger.ZERO) {
				set.add((long) i);
				return true;
			}
		}
		return false;
	}
}
