package mathematics.combinations;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NcRTable {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			calculateCombination(N);
		}
	}

	private static void calculateCombination(int n) {
		// TODO Auto-generated method stub
		
		if (n==1){
			System.out.println("1 1");
			return;
		}
		BigInteger N = factorial(n);
		List<Integer> list = new ArrayList<Integer>();
		BigInteger CONS = BigInteger.valueOf(1000000000);
		for (int i = 0; i <=n/2; i++) {
			BigInteger r = factorial(i);
			BigInteger n_r = calc(n,i);
			BigInteger res = i==0?BigInteger.ONE:n_r.divide(r).remainder(CONS);
			list.add(res.intValue());
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		
		if(n%2==1)
			System.out.print(list.get(list.size()-1)+" ");
		
		for (int i = list.size()-2; i >=0; i--) {
			System.out.print(i==0?list.get(i)+"\n":list.get(i)+" ");
		}
		
		
	}
	
	private static BigInteger calc(int n, int r) {
		// TODO Auto-generated method stub
		BigInteger res = BigInteger.ONE;
		for (int i = n; i >n-r ; i--) {
			res = res.multiply(BigInteger.valueOf(i));
		}
		return res;
	}

	public static BigInteger factorial(int n){
		
		
		BigInteger fact = BigInteger.ONE;
		
		for (int i = 1; i <=n; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		
		return fact;
	} 
}
