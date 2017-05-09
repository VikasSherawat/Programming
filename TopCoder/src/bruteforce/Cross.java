package bruteforce;

public class Cross {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = { ".#.#", "###.", ".###", "#.#." };

		String ans = new Cross().exist(str);
		System.out.println(ans);
	}

	public String exist(String[] board) {
		String exist = "Exists";
		String notexist = "Does not exist";
		boolean flag = false;
		char e = '#';
		char[][] arr = new char[board.length][board[0].length()];
		for (int i = 0; i < board.length; i++) {
			arr[i] = board[i].toCharArray();
		}
		for (int i = 1; i < arr.length - 1; i++) {
			for (int j = 1; j < arr[i].length - 1; j++) {
				char c = arr[i][j];
				if (c == '.') {
					continue;
				}

				if ((arr[i + 1][j] == e) && (arr[i - 1][j] == e) && (arr[i][j - 1] == e) && (arr[i][j + 1]) == e) {
					flag = true;
					break;
				}
			}
		}
		return flag ? exist : notexist;
	}
}
