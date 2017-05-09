package string;

public class FourString {
	public static void main(String[] args) {
		String a = "ab";
		String b = "bc";
		String c = "cd";
		String d = "efgcd";
		System.out.println(new FourString().shortestLength(a, b, c, d));
	}

	public int shortestLength(String a, String b, String c, String d) {
		int res = Integer.MAX_VALUE;

		res = Math.min(res, add(add(add(a, b), c), d).length());
		res = Math.min(res, add(add(add(a, b), d), c).length());
		res = Math.min(res, add(add(add(a, c), b), d).length());
		res = Math.min(res, add(add(add(a, c), d), b).length());
		res = Math.min(res, add(add(add(a, d), b), c).length());
		res = Math.min(res, add(add(add(a, d), c), b).length());
		res = Math.min(res, add(add(add(b, a), c), d).length());
		res = Math.min(res, add(add(add(b, a), d), c).length());
		res = Math.min(res, add(add(add(b, c), a), d).length());
		res = Math.min(res, add(add(add(b, c), d), a).length());
		res = Math.min(res, add(add(add(b, d), a), c).length());
		res = Math.min(res, add(add(add(b, d), c), a).length());
		res = Math.min(res, add(add(add(c, a), b), d).length());
		res = Math.min(res, add(add(add(c, a), d), b).length());
		res = Math.min(res, add(add(add(c, b), a), d).length());
		res = Math.min(res, add(add(add(c, b), d), a).length());
		res = Math.min(res, add(add(add(c, d), a), b).length());
		res = Math.min(res, add(add(add(c, d), b), a).length());
		res = Math.min(res, add(add(add(d, a), b), c).length());
		res = Math.min(res, add(add(add(d, a), c), b).length());
		res = Math.min(res, add(add(add(d, b), a), c).length());
		res = Math.min(res, add(add(add(d, b), c), a).length());
		res = Math.min(res, add(add(add(d, c), a), b).length());
		res = Math.min(res, add(add(add(d, c), b), a).length());

		return res;
	}

	static String add(String s1, String s2) {
		if (s1.contains(s2)) {
			return s1;
		} else if (s2.contains(s1)) {
			return s2;
		}

		for (int i = s2.length(); i > 0; i--) {
			if (s1.endsWith(s2.substring(0, i))) {
				return s1 + s2.substring(i, s2.length());
			}
		}
		return s1 + s2;
	}
}
