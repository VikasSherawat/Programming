package contest;

import java.math.BigInteger;
import java.util.*;

public class Euler1 {

	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int T = in.nextInt();
	BigInteger result[] = new BigInteger[T];
	int index=0;
	while(T-->0){
		int N = in.nextInt();
		result[index++]=findSum(N);
	}
	for (BigInteger i : result) {
	System.out.println(i);	
	}
}

	private static BigInteger findSum(int N) {
		// TODO Auto-generated method stub
		if(N<3)
			return BigInteger.valueOf(0);
		BigInteger sum=BigInteger.valueOf(0);
		BigInteger threeDiv = BigInteger.valueOf((N-1)/3);
		BigInteger threeSum;
		threeSum=BigInteger.valueOf(3).multiply(threeDiv).multiply(threeDiv.add(BigInteger.valueOf(1))).divide(BigInteger.valueOf(2));
		BigInteger fiveDiv = BigInteger.valueOf((N-1)/5);
		BigInteger fiveSum;
		fiveSum = BigInteger.valueOf(5).multiply(fiveDiv).multiply(fiveDiv.add(BigInteger.valueOf(1))).divide(BigInteger.valueOf(2));
		BigInteger fifteenDiv = BigInteger.valueOf((N-1)/15);
		BigInteger fifteenDiff = BigInteger.valueOf(15).multiply(fifteenDiv).multiply(fifteenDiv.add(BigInteger.valueOf(1))).divide(BigInteger.valueOf(2));
		sum=threeSum.add(fiveSum).subtract(fifteenDiff);
		return sum;
	}
}
