package mathematics.numbertheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EasyMath {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			solve(N);
		}
	}

	private static void solve(int n) {
		// TODO Auto-generated method stub
		int org = n;
		int prod = 4;

		if(prod%n==0){
			couunt4(BigInteger.valueOf(prod));
			return;
		}
		
		int[] a = new int[3];

		while (n % 5 == 0) {
			n /= 5;
			a[2]++;
		}

		if (n % 4 == 0) {
			n /= 4;
			a[1]++;
		}

		while (n % 2 == 0) {
			n /= 2;
			a[0]++;
		}
		

		int twoDef = Math.max(a[0], a[2]);
		prod *= (int) Math.pow(10, twoDef);

		StringBuilder sb = new StringBuilder("1");

		while (!(new BigInteger(sb.toString()).remainder(BigInteger.valueOf(n)).intValue() == 0)) {
			sb.append("1");
		}
		couunt4(new BigInteger(sb.toString()).multiply(BigInteger.valueOf(prod)));
		//System.out.println();

	}

	private static void couunt4(BigInteger prod) {
		// TODO Auto-generated method stub
		int b = 0,a=0;
		//System.out.print(prod+" ");
		BigInteger ten = BigInteger.valueOf(10);
		while(prod.remainder(ten).intValue()==0){
			prod = prod.divide(ten);
			b++;
		}
		
		while(prod.compareTo(BigInteger.ZERO)>0){
			prod = prod.divide(ten);
			a++;
		}
		
		
		System.out.println((2*a+b));
	}
}
