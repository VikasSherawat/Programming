package string;

import java.util.ArrayList;
import java.util.Collections;

public class Ropestring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "...";
		System.out.println(new Ropestring().makerope(s));
	}

	public String makerope(String s) {
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		ArrayList<Integer> odd = new ArrayList<>();
		ArrayList<Integer> even = new ArrayList<>();
		boolean oddn = true;
		int l = 1;
		int p = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '-') {
				if (i + 1 != s.length() && c == s.charAt(i + 1)) {
					oddn = !oddn;
					l++;
				} else {
					if (oddn) {
						odd.add(l);
					} else {
						even.add(l);
					}
					l = 1;
					oddn = true;
				}
			} else {
				p++;
			}
		}

		Collections.sort(odd, Collections.reverseOrder());
		Collections.sort(even, Collections.reverseOrder());
		for (int i = 0; i < even.size(); i++) {
			for (int j = 0; j < even.get(i); j++) {
				sb.append('-');
			}
			if (p > 0) {
				sb.append('.');
				--p;
			}
		}

		for (int i = 0; i < odd.size(); i++) {
			for (int j = 0; j < odd.get(i); j++) {
				sb.append('-');
			}
			if (p > 0) {
				sb.append('.');
				--p;
			}
		}

		for (int i = 0; i < p; i++) {
			sb.append('.');
		}
		return sb.toString();
	}

}
