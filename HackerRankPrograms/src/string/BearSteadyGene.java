package string;

import java.util.*;

public class BearSteadyGene {

	static char[] W = { 'A', 'C', 'T', 'G' };
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		char[] sl = in.next().toCharArray();
		int[] cnt = new int[4];
		for (int i = 0; i < n; ++i)
			++cnt[f(i, sl)];

		if (ok(cnt)) { // already steady
			System.out.println("0");
			return;
		}
		
		
		int ans = n;
		// two pointers i, j
		int j = 0;
		for (int i = 0; i < n; ++i) {
			while (j < n && !ok(cnt)) {
				--cnt[f(j++, sl)];
			}
			if (ok(cnt))
				ans = Math.min(ans, j - i);

			++cnt[f(i, sl)];
		}

		System.out.println(ans);
	}

	private static boolean ok(int[] cnt) {
		for (int i = 0; i < 4; ++i)
			if (cnt[i] > n / 4)
				return false;
		return true;
	}

	public static int f(int i, char[] sl) {
		for (int j = 0; j < 4; ++j) {
			if (sl[i] == W[j])
				return j;
		}
		return 0;
	}
}
