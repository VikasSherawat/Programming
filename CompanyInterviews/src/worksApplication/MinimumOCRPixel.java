package worksApplication;


import java.util.Scanner;
import java.util.ArrayList;

public class MinimumOCRPixel {
	/* 
	 * Returns simple Math Logarithm
	 */
	private static double logarithm(double num, double base) {
		return Math.log(num) / Math.log(base);
	}
	
	/* 
	 * Returns a base matrix with 
	 * all elements as a default Object
	 */
	private static Object[][] getBaseMatrix(int row, int column) {
		Object[][] baseMatrix = new Object[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				baseMatrix[i][j] = new int[] {0, 0};
			}
		}
		return baseMatrix;
	}
		
	/* 
	 * Checks the baseMatrix for judging 
	 * common pixels inside all characters
	 */
	private static int judgeCommonPixels(int row, int column, int numCharacters,
			Object[][] baseMatrix) {
		int totalMarkerPoints = row * column;
		
		for(int i=0; i < row; i++){
			for(int j=0; j < column; j++){
				int[] tempMark = (int[]) baseMatrix[i][j];
				if (tempMark[0] == numCharacters || tempMark[1] == numCharacters) {
					totalMarkerPoints--;
				}
			}
		}
		
		return totalMarkerPoints;
	}
	
	/* 
	 * Returns the minimum number of 
	 * pixels needed to identify characters
	 */
	private static int getMinimumPixelsToIdentify(int row, int column, 
			ArrayList<Object> characters) {
		int numCharacters = characters.size();		
		Object[][] baseMatrix = getBaseMatrix(row, column);

		for (Object character : characters) {
			int[][] thisCharacter = (int[][]) character;
			for(int i=0; i < row; i++){
				for(int j=0; j < column; j++){
					int[] pix = (int[]) baseMatrix[i][j];
					if (thisCharacter[i][j] == 1) {
						pix[0] = pix[0]++;
					}else{
						pix[1] = pix[1]++;
					}
					baseMatrix[i][j] = pix;
				}
			}
		}

		int totalMarkerPoints = judgeCommonPixels(row, column, numCharacters, baseMatrix);
		
		int threshold = (int) Math.ceil(logarithm(numCharacters, 2)); 	
		return (totalMarkerPoints > threshold) ? threshold: 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Object> characters = new ArrayList<>();
		
		String inputSize = sc.nextLine();
		int row = Integer.valueOf(inputSize.split(" ")[0]);
		int column = Integer.valueOf(inputSize.split(" ")[1]);
		int numCharacters = Integer.valueOf(inputSize.split(" ")[2]);

		for(int i=0; i < numCharacters; i++){
			sc.nextLine();
			int[][] character = new int[row][column];

			for(int j=0; j < row; j++){
				String rowString = sc.nextLine();
				char[] pixels = rowString.toCharArray();
				
				
				for(int m = 0; m < pixels.length; m++) {
					int pixel = Integer.parseInt(String.valueOf(pixels[m]));
					character[j][m] = pixel;
				}
			}
			characters.add(character);
		}
		
		System.out.println(getMinimumPixelsToIdentify(row, column, characters));
		sc.close();
	}
}