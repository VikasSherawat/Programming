package string;

public class Pallindrome {
	public static void main(String[] args) {
		String s = "madam";
		Pallindrome pl = new Pallindrome();
		System.out.println(pl.recursion(s));
		System.out.println(pl.iterative(s));
		System.out.println(pl.stringBuilder(s));
	}

	public boolean recursion(String s) {
		if (s.length() <= 1)
			return true;
		if (s.charAt(0) != s.charAt(s.length() - 1))
			return false;
		else
			return recursion(s.substring(1, s.length() - 1));

	}

	public boolean iterative(String s) {
		int len = s.length() - 1;
		for (int i = 0; i <= len / 2; i++) {
			if (s.charAt(i) != s.charAt(len - i))
				return false;
		}
		return true;
	}

	public boolean stringBuilder(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		return sb.toString().equals(s);
	}
}
