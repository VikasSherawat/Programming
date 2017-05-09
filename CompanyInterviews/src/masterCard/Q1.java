package masterCard;

import java.util.*;

public class Q1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		List<String> list = new ArrayList<String>();
		String[] inp = new String[T];
		String[] out = new String[T];
		for (int i = 0; i < inp.length; i++) {
			inp[i] = in.next();
		}
		out = Braces(inp);
		for (String str : out)
			System.out.println(str);

	}

	static String[] Braces(String[] values) {

		String[] out = new String[values.length];
		List<Character> list = new ArrayList<Character>();
		boolean flag = true;
		for (int i = 0; i < values.length; i++) {
			flag = true;
			if (values[i].length() % 2 == 1) {
				out[i] = "NO";
				continue;
			}
			for (int j = 0; j < values[i].length(); j++) {
				String str = values[i];
				char curr = str.charAt(j);
				if (curr == '[' || curr == '{' || curr == '(') {
					list.add(str.charAt(j));
				} else {
					if (list.size() > 0) {
						char lastChar = list.remove(list.size() - 1);
						if (lastChar == '[' && curr != ']') {
							flag = false;
							break;
						} else if (lastChar == '(' && curr != ')') {
							flag = false;
							break;
						} else if (lastChar == '{' && curr != '}') {
							flag = false;
							break;
						} else {
							continue;
						}
					} else {
						flag = false;
						break;
					}
				}
			}
			if (flag)
				out[i] = "YES";
			else
				out[i] = "NO";
		}

		return out;
	}

}
