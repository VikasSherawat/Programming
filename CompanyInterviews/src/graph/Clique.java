package graph;
import java.io.*;
import java.util.*;
public class Clique {
	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			int T = Integer.parseInt(in.readLine());
			while (T-- > 0) {
				String[] s = in.readLine().split("\\s");
				int N = Integer.parseInt(s[0]);
				int K = Integer.parseInt(s[1]);
				System.out.println(solve(N, K));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static int solve1(int n, int k) {
		int g1 = n % k;
		int g2 = k - g1;
		int sz1 = n / k + 1;
		int sz2 = n / k;
		int ret = g1 * sz1 * g2 * sz2 + g1 * (g1 - 1) * sz1 * sz1 / 2 + g2
				* (g2 - 1) * sz2 * sz2 / 2;
		return ret;
	}

	static int solve(int n, int e) {
		int k, low = 1, high = n + 1;
		while (low + 1 < high) {
			int mid = low + (high - low) / 2;
			k = solve1(n, mid);
			if (k < e)
				low = mid;
			else
				high = mid;
		}
		return high;
	}
}
