package mathematics.numbertheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Mehta {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		//List<Integer> prime = getPrime(500);
		List<Integer> ls = getEvenPoweroftwo();
		List<Integer> ps = getSquare();
		SortedSet<Integer> pes  = new TreeSet<Integer>();
		boolean flag = true;
		for (int i = 0; i < ls.size() && flag; i++) {
			for (int j = 0; j < ps.size(); j++) {
				int lsn = ls.get(i);
				int psn = ps.get(j);
				if(lsn*psn<=1000000)
					pes.add(lsn*psn);
				else{
					break;
				}
			}
		}
		List<Integer> prime = getPrime(500);
		int T = in.nextInt();
		while (T-- > 0) {
			int cdiv = 1;
			int ans = 0;
			long n = in.nextLong();
			Iterator<Integer> iter = pes.iterator();
			while(iter.hasNext() ){
				int i = iter.next();
				if(i>=n)
					break;
				if(n%i==0){
					//System.out.println(i);
					ans++;
				}
				
				
			}
			Map<Integer, Integer> map = findDiv(n, prime);
			for (Map.Entry<Integer, Integer> m : map.entrySet()) {
				int base = m.getKey();
				int exp = m.getValue();
				cdiv *= (exp + 1);
			}
			//System.out.println(cdiv+","+ans);
			if(n==1){
				System.out.println(0);
				continue;
			}
			int gcd = findgcd(ans, --cdiv);
			System.out.println(ans==0?0:ans / gcd + "/" + cdiv / gcd);
		}

	}
	public static Map<Integer, Integer> findDiv(long n, List<Integer> prime) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < prime.size() && prime.get(i) <= n; i++) {
			while (n % prime.get(i) == 0) {
				n = n / prime.get(i);
				if (map.containsKey(prime.get(i))) {
					map.put(prime.get(i), map.get(prime.get(i)) + 1);
				} else {

					map.put(prime.get(i), 1);
				}

			}
		}
		if (n != 1) {
			BigInteger big = BigInteger.valueOf(n);
			if (big.isProbablePrime(10))
				map.put(big.intValue(), 1);
		}

		return map;
	}

	public static boolean isprime(long n) {
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
		for (int i = 2; list.size() != N; i++) {
			if (isprime(i))
				list.add(i);

		}

		return list;
	}

	private static List<Integer> getSquare() {
		// TODO Auto-generated method stub
		List<Integer> ls = new ArrayList<Integer>();
		for (int i = 1; i <=200 ; i++) {
			ls.add(i*i);
		}
		return ls;
	}

	private static List<Integer> getEvenPoweroftwo() {
		// TODO Auto-generated method stub
		List<Integer> ls = new ArrayList<Integer>();
		int power = 0;
		for (int i = 2;; i=i+2) {
			power = (int)Math.pow(2, i);
			if(power <=1000000)
				ls.add(power);
			else
				break;
		}
		return ls;
	}

	private static int findgcd(int a, int b) {
		// TODO Auto-generated method stub
		if (b == 0)
			return a;
		return findgcd(b, a % b);
	}
}
