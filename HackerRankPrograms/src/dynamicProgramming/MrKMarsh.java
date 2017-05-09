package dynamicProgramming;

import java.util.Scanner;

public class MrKMarsh {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int M = in.nextInt(),N = in.nextInt();
		String[] str = new String[M];
		for (int i = 0; i < M; i++) {
				str[i]=in.next();	
		}
		char[][] ar = new char[M][N];
		for (int i = 0; i < M; i++) {
			ar[i]=str[i].toCharArray();	
		}
		
	}

}
