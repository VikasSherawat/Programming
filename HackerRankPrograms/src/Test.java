import java.util.Arrays;

public class Test {
	static long[] fib;

	public static void main(String[] args) {
		int n = 50;
		fib = new long[n+2];
		Arrays.fill(fib, -1);
		fib[0] = 0;
		fib[1] = 1;
		System.out.println("Answer:" + iterative(n));
		System.out.println("Answer:" + recursive(n-1));
	}

	private static long recursive(int n) {
		// TODO Auto-generated method stub
		if (fib[n] != -1)
			return fib[n];
		
		return fib[n]=recursive(n-1)+recursive(n-2);
	}

	// 0,1,1,2,3,5
	public static long iterative(int n) {
		long a = 0L, b = 1L, temp = 0L;
		if (n <= 1)
			return n;

		for (int i = 2; i < n; i++) {
			temp = a + b;
			a = b;
			b = temp;
		}

		return temp;
	}
}
