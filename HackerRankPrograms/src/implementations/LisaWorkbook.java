package implementations;

import java.util.Scanner;

public class LisaWorkbook {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(), K = in.nextInt();
		int[] probArray = new int[N];
		int index = 0;
		while (N-- > 0) {
			probArray[index++] = in.nextInt();
		}

		N = index;

		int result = countSpecialProblem(K, probArray);
		System.out.println(result);
	}

	private static int countSpecialProblem(int K, int[] probArray) {
		// TODO Auto-generated method stub
		/*5 3  
		4 2 6 1 1 0*/

		int size = probArray.length;
		int temp = 0;
		int result = 0, page = 1;
		int probLeft;
		for (int i = 0; i < size; i++) {
			
			probLeft = probArray[i];
			temp = 0;
			if (probLeft <= K) {
				if (probLeft >= page) {
					result++;
				}
				page++;
				continue;
			}
			int pageInChapter=0;
			while (temp < probArray[i]) {
				pageInChapter++;
				if (probLeft >= K) {
					temp += K;
					probLeft -= K;
				} else {
					temp += probLeft;
					probLeft =0;
				}
				if (temp < page) { 
					page++;
					continue;
				} else {
					if (page >= ((pageInChapter-1)*K+1) && page <= pageInChapter*K) {
						result++;
					}
					// page++;
				}
				page++;
			} // while loop
		}//for loop
		return result;
	}

}
