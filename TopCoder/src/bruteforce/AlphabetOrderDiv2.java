package bruteforce;

public class AlphabetOrderDiv2 {

	public static void main(String[] args) {
		String[] words = { "topcoder", "topcoder" };
		System.out.println(new AlphabetOrderDiv2().isOrdered(words));
	}

	public String isOrdered(String[] words) {
		int pre[][] = new int[26][26];
		for (String s : words) {
			for (int i = 0; i < s.length(); i++)
				for (int j = i + 1; j < s.length(); j++)
					pre[s.charAt(i) - 'a'][s.charAt(j) - 'a'] = 1;
		}

		for (int i = 0; i < 26; i++)
			pre[i][i] = 1;

		for (int i = 0; i < 26; i++)
			for (int j = 0; j < 26; j++)
				for (int k = 0; k < 26; k++)
					if (pre[i][j] == 1 && pre[j][k] == 1)
						pre[i][k] = 1;

		for (int i = 0; i < 26; i++)
			for (int j = 0; j < 26; j++)
				if (i != j)
					if (pre[i][j] == 1 && pre[j][i] == 1)
						return "Impossible";

		return "Possible";
	}

}