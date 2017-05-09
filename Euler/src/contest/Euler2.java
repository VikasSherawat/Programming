package contest;

import java.math.BigInteger;
import java.util.Scanner;

public class Euler2 {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int T = in.nextInt();
	BigInteger result[] = new BigInteger[T];
	int index=0;
	while(T-->0){
		BigInteger N = in.nextBigInteger();
		result[index++]=findSum(N);
	}
	for (BigInteger i : result) {
	System.out.println(i);	
	}
}

private static BigInteger findSum(BigInteger n) {
	// TODO Auto-generated method stub
	BigInteger a=BigInteger.valueOf(1);
	BigInteger b=BigInteger.valueOf(2);
	BigInteger temp=BigInteger.valueOf(0);
	BigInteger sum=BigInteger.valueOf(0);
	while(!(b.compareTo(n)>0)) {
		if(b.remainder(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0)))
			sum=sum.add(b);
		temp=b;
		b=b.add(a);
		a=temp;
		
	}
	
	return sum;
}
}
