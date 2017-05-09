package recursion;

import java.util.Arrays;

public class BearSlowlySorts {

	public int minMoves(int[] w) {
		int ans = 0;
		boolean flag = true;

		while (flag) {
			flag = false;
			for (int i = 0; i < w.length - 2; i++) {
				if (w[i] > w[i + 1]) {
					flag = true;
					ans++;
					break;
				}
			}
			if (flag) {
				Arrays.sort(w, 0, w.length - 1);
			}
			flag = false;

			if (w[w.length - 2] > w[w.length - 1]) {
				flag = true;
				ans++;
			}
			if (flag) {
				Arrays.sort(w, 1, w.length);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] w = { 50, 20, 30, 40, 10 };
		System.out.println(new BearSlowlySorts().minMoves(w));
	}
}
