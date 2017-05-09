package string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BuildString {

   public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int N = in.nextInt();
			int A = in.nextInt();
			int B = in.nextInt();
			String s = in.next();
			doRun(N, A, B, s);
		}
	}

	private static void doRun(int N, int A, int B, String s) {
		if (s.length() == 1) {
			System.out.println(A);
			return;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(0));
		int[] num = new int[N];
		num[0] = A;
		boolean[] b = new boolean[N];
		Set<Character> set = new HashSet<Character>();
		set.add(s.charAt(0));
		int index = 1;
		while (index < N) {
			if (!set.contains(s.charAt(index))) {
				num[index] = num[index - 1] + A;
				set.add(s.charAt(index));
				sb.append(s.charAt(index));
				index++;
			} else {
				int tmp = index + 1;
           while(b[tmp-1])
					tmp++;
           String sub = s.substring(index, tmp);
				while (tmp <= N && sb.toString().contains(sub)) {
					if (!b[tmp-1]) {
						num[tmp-1] = Math.min(num[index - 1] + B, num[tmp - 2] + A);
						b[tmp-1] = true;
					}
					tmp++;
					if(tmp <= N)
						sub = s.substring(index, tmp);
					
				}
				tmp--;
				sb.append(s.charAt(index));
				index++;
				if (tmp == N)
					break;
			}
		}
		System.out.println(num[N - 1]);
	}
}