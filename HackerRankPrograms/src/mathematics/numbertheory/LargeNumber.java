package mathematics.numbertheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LargeNumber {
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		BigInteger M = BigInteger.valueOf(1000000007);
		BigInteger N = BigInteger.valueOf(1000000006);
		BigInteger TEN = BigInteger.valueOf(10);
		int[] A = new int[100009];
		int[] B = new int[100009];
		while (T-- > 0) {
			String str1 = in.next();
			String str2 = in.next();
			BigInteger temp1, temp2;
			for (int i = 0; i < str1.length(); i++) {
				A[i] = str1.charAt(i) - '0';
			}
			for (int i = 0; i < str2.length(); i++) {
				B[i] = str2.charAt(i) - '0';
			}
			
			temp1 = BigInteger.valueOf(A[0]).remainder(M);
	        for(int i=1 ; i< str1.length() ; i++)
	        {
	            temp1 = (TEN.multiply(temp1).add(BigInteger.valueOf(A[i]))).remainder(M); 
	        }
	    
	        
	        temp2 = BigInteger.valueOf(B[0]).remainder(N);
	        for(int i=1 ; i< str2.length() ; i++)
	        {
	            temp2 = (TEN.multiply(temp2).add(BigInteger.valueOf(B[i]))).remainder(N);
	        }
	        
	        System.out.println(fastpow(temp1,temp2,M));

		}
	}
	
	static BigInteger fastpow(BigInteger a, BigInteger b, BigInteger mod) {
		BigInteger i,temp;
		BigInteger two = BigInteger.valueOf(2);
		if (b.intValue()==1)
			return a.remainder(mod);
		if (b.intValue()==0)
			return BigInteger.ONE;
		
		if(b.remainder(two).longValue()==0)
		{
		    temp=fastpow(a,b.divide(two),mod);
		    return (temp.multiply(temp)).remainder(mod);
		}

		else
		{
		    temp=fastpow(a,b.subtract(BigInteger.ONE),mod);
		    return (temp.multiply(a)).remainder(mod);
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
