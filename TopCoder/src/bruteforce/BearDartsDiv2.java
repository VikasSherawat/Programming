package bruteforce;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BearDartsDiv2 {

	public long count(int[] w) {

		// Set<Long> set = new HashSet<Long>();
		Set<Integer> set = new HashSet<Integer>();
		int tw[] = new int[1000000 + 1], mx = 1000000;
		int tr[] = new int[1000000 + 1];
		long r = 0;

		for (int i = 0; i < w.length; i++) {
			r += tr[w[i]];

			Iterator<Integer> it = set.iterator();
			while (it.hasNext()) {
				long k = it.next();
				if (k * w[i] <= mx)
					tr[(int) k * w[i]] += tw[(int) k];
			}

			for (int j = i - 1; -1 < j; j--) {
				if ((long) w[i] * w[j] > mx)
					continue;
				tw[w[i] * w[j]]++;
				set.add(w[i] * w[j]);
			}
		}

		return r;
	}
	
	public static void main(String[] args) {
		int[] w = {10, 2, 2, 7, 40, 160};
		System.out.println(new BearDartsDiv2().count(w));
	}

}