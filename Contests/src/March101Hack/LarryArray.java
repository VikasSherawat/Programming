package March101Hack;

import java.util.*;


public class LarryArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		    while (t-->0) {
		        int n = in.nextInt();
		        int[] v = new int[n];
		        for (int i = 0; i < n; ++i) {
		            v[i] = in.nextInt();
		        }
		        long num_inversions = 0l;
		        for (int i = 0; i < n-1; ++i) {
		            for (int j = i + 1; j < n; ++j) {
		                if (v[i] > v[j]) {
		                    ++num_inversions;
		                }
		            }
		        }
		        long one = 1l;
		        if (num_inversions%2==1 ) {
		           System.out.println("NO");
		        }
		        else {
		           System.out.println("YES");
		        }
		    }
		}
}
