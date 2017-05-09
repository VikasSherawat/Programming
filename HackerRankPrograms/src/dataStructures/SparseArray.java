package dataStructures;

import java.util.*;

public class SparseArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String[] ar = new String[N];
		for (int i = 0; i < ar.length; i++) {
			ar[i]= in.next();
		}
		int Q = in.nextInt();
		String[] inp = new String[Q];
		for (int i = 0; i < inp.length; i++) {
			inp[i]=in.next();
		}
		int count=0;
		int[] result = new int[Q];
		for (int i = 0; i < inp.length; i++) {
			count=0;
			for (int j = 0; j < ar.length; j++) {
				if(ar[j].equals(inp[i]))
					count++;
			}
			result[i]=count;
		}//outer loop closed here
		
		for (int i : result) {
			System.out.println(i);
		}
	}

}
