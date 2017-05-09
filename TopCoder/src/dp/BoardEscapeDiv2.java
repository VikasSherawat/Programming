package dp;



public class BoardEscapeDiv2 {

	final int FREE = 0, EXIT = 1, OBSTACLE = 2;
	int r, c;
	int[][] grid;
	Boolean[][][] memo;

	public static void main(String[] args) {
		String[] s = { "#E...", "#...E", "E.T#.", "..#.." };

		int k = 13;
		System.out.println(new BoardEscapeDiv2().findWinner(s, k));
	}

	public String findWinner(String[] s, int k) {
		r = s.length;
		c = s[0].length();
		memo = new Boolean[k + 1][r][c];
		grid = new int[r][c];
		int posX = -1, posY = -1;
		for (int y = 0; y < r; y++) {
			for (int x = 0; x < c; x++) {
				switch (s[y].charAt(x)) {
				case 'T':
					posX = x;
					posY = y;
					break;
				case 'E':
					grid[y][x] = EXIT;
					break;
				case '#':
					grid[y][x] = OBSTACLE;
					break;
				}
			}
		}

		if (canWin(k, posX, posY))
			return "Alice";
		else
			return "Bob";
	}

	boolean canWin(int k, int x, int y) {

		// Loses if token is off the board
		if (k == 0 || grid[y][x] == EXIT)
			return false;

		// dp
		if (memo[k][y][x] != null)
			return memo[k][y][x];

		/* recusrive case */

		if (x > 0 && grid[y][x - 1] != OBSTACLE && !canWin(k - 1, x - 1, y))
			return memo[k][y][x] = true;

		if (y > 0 && grid[y - 1][x] != OBSTACLE && !canWin(k - 1, x, y - 1))
			return memo[k][y][x] = true;

		if (x < c - 1 && grid[y][x + 1] != OBSTACLE && !canWin(k - 1, x + 1, y))
			return memo[k][y][x] = true;

		if (y < r - 1 && grid[y + 1][x] != OBSTACLE && !canWin(k - 1, x, y + 1))
			return memo[k][y][x] = true;

		return memo[k][y][x] = false;
	}

}