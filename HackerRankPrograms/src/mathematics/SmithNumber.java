package mathematics;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SmithNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int N = T;
		List<Integer> prime = getPrime(10000);
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; T>1 && i < prime.size(); i++) {
			int pnum = prime.get(i);
			while(T%pnum==0){
				T = T/pnum;
				if(map.containsKey(pnum)){
					map.put(pnum, map.get(pnum)+1);
				}else{
					map.put(pnum, 1);
				}
			}
			
			if(BigInteger.valueOf(T).isProbablePrime(10)){
				map.put(T, 1);
				break;
			}
		}
		int sum = 0;
		for(Map.Entry<Integer,Integer> m: map.entrySet()){
			int key = m.getKey();
			int value = m.getValue();
			if(key<10)
				sum += key*value;
			else
				sum += getSum(key)*value;
		}
		int nsum = getSum(N);
		
		System.out.println(nsum==sum?1:0);
		
	}
	
	static int getSum(int N){
		int nsum = 0;
		while(N>0){
			nsum += N%10;
			N /=10;
		}
		
		return nsum;
	}
	
	static boolean isprime(long n) {
		// """Returns true; if n is prime."""
		if (n == 2)
			return true;
		if (n == 3)
			return true;
		if (n % 2 == 0)
			return false;
		if (n % 3 == 0)
			return false;

		int i = 5;
		int w = 2;

		while (i * i <= n) {
			if (n % i == 0)
				return false;

			i += w;
			w = 6 - w;
		}

		return true;
	}

	public static List<Integer> getPrime(int N) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i <= N; i++) {
			if (isprime(i))
				list.add(i);

		}

		return list;
	}
}
