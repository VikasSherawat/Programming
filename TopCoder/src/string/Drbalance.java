package string;

public class Drbalance {
	public int lesscng(String s, int k) {
		int ans = 0;
		if (count(s) <= k)
			return ans;
		String p = "+", n = "-";
		StringBuilder sb = new StringBuilder(s);
		int idx = sb.indexOf(n);
		for (int i = idx; i < sb.length(); i++) {
			if (sb.charAt(i) == '+')
				continue;

			ans++;
			sb.replace(i, i + 1, p);
			if (count(sb.toString()) <= k)
				return ans;
		}
		return ans;
	}

	private int count(String s) {
		// TODO Auto-generated method stub
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			ans += balance(s.substring(0, i + 1));
		}
		return ans;
	}

	private int balance(String s) {
		// TODO Auto-generated method stub
		int n = 0, p = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '-')
				n++;
			else
				p++;
		}
		return n - p > 0 ? 1 : 0;
	}

	public static void main(String[] args) {
		String s = "-+--+--+--++++----+";
		int k = 3;
		System.out.println(new Drbalance().lesscng(s, k));
	}
}
