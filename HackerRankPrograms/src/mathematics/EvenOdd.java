package mathematics;

import java.util.Scanner;

public class EvenOdd {
	static int[] ar;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ar = new int[n];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = in.nextInt();
		}
		int query = in.nextInt();
		String[] result = new String[query];
		for (int i = 0; i < query; i++) {
			int x, y;
			long temp;
			x = in.nextInt();
			y = in.nextInt();
			long res = find(x, y);
			System.out.println(res % 2 == 0 ? "Even" : "Odd");
		}

	}

	private static long find(int x, int y) {
		// TODO Auto-generated method stub
		// System.out.println("X-1 element in the array is--"+ar[x-1]);
		if (ar[x - 1] == 0)
			return 0;
		
		if(x==y){
			if (ar[x - 1] % 2 == 0)
				return 0;
			else
				return 1;	
		}
		
		if (ar[x] == 0)
			return 1;

		if (ar[x - 1] % 2 == 0)
			return 0;
		else
			return 1;

	}

}
