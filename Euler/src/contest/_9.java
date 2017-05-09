package contest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class _9 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		for (int i = 2; i < 3000; i++) {
			for (int j = 1; j < 3000; j++) {
				if (i + j > 3000)
					break;

				long ii = i * i;
				long jj = j * j;
				long sum = ii + jj;
				long sq = (long) Math.sqrt(sum);
				if (sq * sq == sum) {
					long ss = i + j + sq;
					if (map.containsKey(ss)) {
						long prod = i * j * sq;
						if (prod > map.get(ss))
							map.put(ss, prod);
					} else
						map.put(ss, (long) (i * j * sq));
				}
			}
		}

		while (T-- > 0) {
			long n = in.nextLong();
			if (map.containsKey(n))
				System.out.println(map.get(n));
			else
				System.out.println(-1);
		}
	}
}
