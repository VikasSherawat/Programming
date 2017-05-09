package dp;

import java.util.Arrays;
import java.util.TreeSet;

public class FibonacciDiv2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 11;
		System.out.println(new FibonacciDiv2().find(N));
	}

	public int find(int N) {
		int ans = 0;
		long[] fib = new long[42];
		fib[0] = 0;
		fib[1] = 1;
		
		for (int i = 2; i < fib.length; i++) {
			fib[i] = fib[i - 2] + fib[i - 1];
		}

		if(Arrays.binarySearch(fib, N)>=0){
			return 0;
		}
		int i =0;
		for (i = 0; i < fib.length; i++) {
			if(fib[i]>N){
				break;
			}
		}
		ans = (int)Math.min(N-fib[i-1], fib[i]-N);
		return ans;
	}

}
