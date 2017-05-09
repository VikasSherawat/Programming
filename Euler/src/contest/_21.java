package contest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class _21 {
	static List<Integer> list;
	static TreeSet<Integer> set = new TreeSet<Integer>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		list = getPrime(400);
		getAmicableNumbers();
		int T = in.nextInt();
		while (T-- > 0) {
			int n = in.nextInt();
			int sum = getSum(n);
			System.out.println(sum);
		}
		
		in.close();
	}

	private static int getSum(int n) {
		// TODO Auto-generated method stub
		Iterator<Integer> iter = set.iterator();
		int sum = 0;
		while(iter.hasNext()){
			int next = iter.next();
			if(next>=n){
				break;
			}
			sum+=next;
		}
		return sum;
	}

	private static void getAmicableNumbers() {
		// TODO Auto-generated method stub
		for (int i = 220; i <=100000 ; i++) {
			int d = divSum(i);
			if(set.contains(d) || d<=i){
				continue;
			}
			
			if(divSum(d)==i){
				set.add(d);
				set.add(i);
			}
		}
		
	}

	private static int divSum(int n) {
		// TODO Auto-generated method stub
		// sum of divisors = [2^(7+1) –1]/(2–1) × [3^(2+1) –1]/(3–1) × [7^(1+1)
		// –1]/(7–1)
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		int m1 = n;
		for (int i = 0; i < list.size(); i++) {
			int y = list.get(i);
			if (y > n) {
				break;
			}

			if (n % y == 0) {
				int count = 0;
				while (n % y == 0) {
					n /= y;
					count++;
				}
				map.put(y, count);
			}
		}

		long sum = 1l;
		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			int key = m.getKey();
			int val = m.getValue();
			long prod = (long) Math.pow(key, val+1)-1;
			--key;
			prod /=(key);
			sum *= prod;
		}
		
		return (int) (sum-m1);

	}

	private static List<Integer> getPrime(int n) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		int i = 5, w = 2;
		while (i < n) {
			if (isPrime(i)) {
				list.add(i);
			}
			i+=w;
			w = 6 - w;
		}
		return list;
	}

	private static boolean isPrime(int n) {
		// TODO Auto-generated method stubif(
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
