package mathematics.numbertheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HelpMike {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			int K = in.nextInt();
			long ans = 0l;
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 1; i <= K; i++) {
				int rem = i % K;
				/*if (map.containsKey(rem)) {
					map.put(rem, map.get(rem) - 1);
					ans += map.get(rem);
				} else {*/
					int first = findNext(i, K, N);
					int last = findLast(first, i, K, N);
					if (last < first)
						continue;
					long count = (last - first) / K + 1;
				//	map.put(rem, count);
					ans += count*(count+1)/2;
				
			}
			System.out.println(ans);
		}
	}

	private static int findLast(int first, int i, int k, int n) {
		// TODO Auto-generated method stub
		int rem = n % k;
		int frem = first % k;
		int div = n - rem;
		if (div + frem <= n)
			return div + frem;
		else {
			return div - i % k;
		}

	}

	private static int findNext(int i, int k, int n) {
		// TODO Auto-generated method stub
		int rem = i % k;
		int next = k - rem;
		int div = i / k;
		int start = div * k + next;
		if (start <= i)
			start += k;
		return start;
	}
}
