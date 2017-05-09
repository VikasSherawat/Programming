package contest;

import java.math.BigInteger;
import java.util.*;

public class _20 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T-->0){
			int n = in.nextInt();
			sumFact(n);
		}
	}

	private static void sumFact(int n) {
		// TODO Auto-generated method stub
		BigInteger s = BigInteger.ONE;
		for (int i = 2; i <=n ; i++) {
			s  = s.multiply(BigInteger.valueOf(i));
		}
		
		int sum = findSum(s.toString());
		System.out.println(sum);
	}

	private static int findSum(String s) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += Character.getNumericValue(s.charAt(i));
		}
		return sum;
	}
}
