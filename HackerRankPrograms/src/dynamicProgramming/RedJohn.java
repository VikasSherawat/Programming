package dynamicProgramming;

import java.math.BigInteger;
import java.util.Scanner;

public class RedJohn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] result = new int[T];
		for (int i = 0; i < T; i++) {
			int num = in.nextInt();
			result[i] = findNumPrime(num);
		}
		for (int i : result) {
			System.out.print(i+" ");
		}
	}

	private static int findNumPrime(int num) {
		// TODO Auto-generated method stub
		int four = num/4;
		BigInteger sum = BigInteger.valueOf(0);
		for (int i = four; i >= 0; i--) {
			int one = num-4*i;
			int numer = i+one;
			BigInteger numFact = findFact(numer);
			BigInteger oneFact = findFact(one);
			BigInteger fourFact = findFact(i);
			sum = sum.add(numFact.divide(oneFact.multiply(fourFact)));
		}
		System.out.println("Finding primer number less than--"+sum);
		int result = findNumPrime1(sum);
		return result;
	}

	private static int findNumPrime1(BigInteger sum) {
		// TODO Auto-generated method stub
		int num = sum.intValue();
		int count=0;
		boolean flag ;
		for (int i = 2; i <= num; i++) {
			flag = true;
			int sqrt = (int)Math.sqrt(i);
			for (int j = 2; j <=sqrt ; j++) {
				if(i%j==0)
					flag = false;
			}//inner for loop
			if(flag){
				count++;
			}
		}
		return count;
	}

	private static BigInteger findFact(int numer) {
		// TODO Auto-generated method stub
		BigInteger fact = BigInteger.valueOf(1);
		if(numer<=1)
			return BigInteger.valueOf(1);
		else
		{
			for (int i = numer; i >0; i--) {
				fact = fact.multiply(BigInteger.valueOf(i));
			}
		}
		return fact;
	}

}
