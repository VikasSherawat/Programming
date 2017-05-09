package worksApplication;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	static int N;
	static int M;
	static int K;
	
	public static void main(String[] args) {
		Main obj = new Main();
		ArrayList<Object> characters = obj.getInput();
		int ans = new Main().getMinimumPixels(N, M, characters);
		System.out.println(ans);

	}
	
	/*Function to take input data
	 * 
	 * */
	private ArrayList<Object> getInput() {
		Scanner in = new Scanner(System.in);
		ArrayList<Object> characters = new ArrayList<Object>();

		String[] input = in.nextLine().split("\\s+");
		// String[] inputArray = in
		N = Integer.valueOf(input[0]);
		M = Integer.valueOf(input[1]);
		K = Integer.valueOf(input[2]);

		for (int i = 0; i < K; i++) {
			in.nextLine();
			int[][] matrix = new int[N][M];

			for (int j = 0; j < N; j++) {
				String matrixRow = in.nextLine();
				char[] pixels = matrixRow.toCharArray();

				for (int k = 0; k < pixels.length; k++) {
					int value = Character.getNumericValue(pixels[k]);
					matrix[j][k] = value;
				}
			}
			characters.add(matrix);
		}

		in.close();
		return characters;
	}
	
	
	
	/*
	 * Checks the matrix for common pixels
	 */
	private int findCharacterInPixels(int row, int column, int blocks, Object[][] matrix) {
		int total = row * column;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				int[] temp = (int[]) matrix[i][j];
				if (temp[0] == blocks || temp[1] == blocks) {
					total--;
				}
			}
		}

		return total;
	}

	/*
	 * Returns a base matrix with and initialized with default Object
	 */
	private Object[][] getDefaultMatrix(int r, int c) {
		Object[][] defaultMatrix = new Object[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				defaultMatrix[i][j] = new int[] { 0, 0 };
			}
		}
		return defaultMatrix;
	}

	

	/*
	 * Returns the min pixels needed to identify characters
	 */
	private int getMinimumPixels(int row, int column, ArrayList<Object> characters) {

		Object[][] dMatrix = getDefaultMatrix(row, column);

		int blocks = characters.size();

		for (int idx = 0; idx < blocks; idx++) {
			Object character = characters.get(idx);
			int[][] currentChar = (int[][]) character;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					int[] pArray = (int[]) dMatrix[i][j];
					if (currentChar[i][j] == 1) {
						pArray[0] = pArray[0]++;
					} else {
						pArray[1] = pArray[1]++;
					}
					dMatrix[i][j] = pArray;
				}
			}
		}

		int points = findCharacterInPixels(row, column, blocks, dMatrix);

		int ans = (int) Math.ceil(log(blocks, 2));

		if (points <= ans)
			ans = 0;

		return ans;
	}
	
	/*
	 * Returns simple logarithm with given base and number
	 */
	private double log(double number, double base) {
		return Math.log(number) / Math.log(base);
	}

	
}