package dynamicProgramming;

import java.math.BigInteger;
import java.util.*;

public class SamSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String inp = in.next();
		subString(inp);
	}

	private static void subString(String inp) {
		// TODO Auto-generated method stub
		int l = inp.length();
		BigInteger res=BigInteger.ZERO;
		BigInteger f = BigInteger.ONE;
		BigInteger MOD = BigInteger.valueOf(1000000007);
			for(int i = l-1; i >= 0; i--) {
			 //   res = (res + (s[i]-'0')*f*(i+1)) % MOD;
			    res = res.add(new BigInteger(inp.substring(i, i+1)).multiply(BigInteger.valueOf(i+1)).multiply(f)).remainder(MOD);
			    f= (f.multiply(BigInteger.TEN).add(BigInteger.ONE)).remainder(MOD);
			}
		System.out.println(res);
	}

}
