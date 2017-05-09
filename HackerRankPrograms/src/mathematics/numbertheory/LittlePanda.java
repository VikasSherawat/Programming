package mathematics.numbertheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LittlePanda {

	static long x;
	static long y;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			BigInteger a = in.nextBigInteger();
			BigInteger b = in.nextBigInteger();
			BigInteger m = in.nextBigInteger();
			BigInteger modInverse;
			if(b.intValue()<0){
				 modInverse = a.modInverse(m);
			}else{
				modInverse = a;
			}
			long ans = modpow(modInverse.longValue(), Math.abs(b.longValue()), m.longValue());
			System.out.println(ans);
		}
	}
	
	
	static long modpow(long base_value, long exponent, long modulus) {
		base_value = base_value % modulus;
		long result = 1;
		while (exponent > 0) {
			if (exponent % 2 == 1)
				result = (result * base_value) % modulus;
			base_value = (base_value * base_value) % modulus;
			exponent = exponent / 2;
		}
		return result;
	}



}
