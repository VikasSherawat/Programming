package dp;

public class ThePalindrome {
	public static void main(String[] args) {
		String s = "abab"; // namcncman
		System.out.println(new ThePalindrome().find(s));
	}

	boolean isPalin(String s) {

		for (int i = 0; i < s.length(); i++)

			if (s.charAt(i) != s.charAt(s.length() - i - 1))

				return false;

		return true;

	}

	public int find(String s) {

		for (int i = 0;; i++) {

			String tmp = s;

			for (int j = i - 1; j >= 0; j--)

				tmp += s.charAt(j);

			if (isPalin(tmp))

				return i + s.length();

		}
	}
}
