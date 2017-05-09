package contest;

import java.math.BigInteger;
import java.util.Scanner;

public class _15 {
	static  int C = 1000000000+7;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T-->0){
			int n = in.nextInt();
			int m = in.nextInt();
			BigInteger ans = comb(n+m,m);
			System.out.println(ans);
		}
	}

	private static BigInteger comb(int n, int m) {
		// TODO Auto-generated method stub
		BigInteger ans = BigInteger.ZERO;
		if(m>n/2){
			m = n-m;
		}
		int ss = n-m;
		
		
		BigInteger p1 = BigInteger.ONE;
		BigInteger M = BigInteger.valueOf(C);
		for (int i = n; i >ss ; i--) {
			p1 = p1.multiply(BigInteger.valueOf(i));
		}
		
		BigInteger d1 = BigInteger.ONE;
		for (int i = 2; i <=m ; i++) {
			d1 = d1.multiply(BigInteger.valueOf(i));
		}
		ans = p1.divide(d1);
		return ans.remainder(M);
	}
}
