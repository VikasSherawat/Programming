package math;

public class GridSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 33, m = 6;
		int[] grid = {1,2,34  };
		String ans = new GridSort().sort(n, m, grid);
		System.out.println(ans);
	}

	public String sort(int n, int m, int[] grid) {
		String p = "Possible", im = "Impossible";
		if (n == 1 || m == 1)
			return p;

		int i = 1;
		for (i = 1; i < grid.length; i++) {
			if (grid[i] < grid[i - 1])
				break;
		}
		if (i == grid.length) {
			return p;
		}
		int[][] a = getArray(n, m, grid);
		int[] row = new int[m - 1];
		for (int j = 1; j < m; j++) {
			if (a[0][j] > a[0][j - 1]) {
				row[j - 1] = 1;
			} else {
				row[j - 1] = -1;
			}
		}

		for (int j = 1; j < n; j++) {
			for (int k = 1; k < m; k++) {
				if (a[j][k] > a[j][k - 1]) {
					if (row[k - 1] == -1) {
						return im;
					}
				} else {
					if (row[k - 1] == 1) {
						return im;
					}
				}
			}
		}

		int[] col = new int[n - 1];

		for (int j = 1; j < n; j++) {
			if (a[j][0] > a[j - 1][0]) {
				col[j - 1] = 1;
			} else {
				col[j - 1] = -1;
			}
		}

		for (int j = 1; j < m; j++) {
			for (int k = 1; k < n; k++) {
				if (a[k][j] > a[k - 1][j]) {
					if (col[k - 1] == -1)
						return im;
				} else {
					if (col[k - 1] == 1)
						return im;
				}
			}
		}

		return p;

	}

	private int[][] getArray(int n, int m, int[] grid) {
		// TODO Auto-generated method stub
		int[][] a = new int[n][m];
		int z = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = grid[z++];
			}
		}
		return a;
	}
}
