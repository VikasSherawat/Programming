package main;

import java.math.BigInteger;
import java.util.*;

public class BearEndCryptography {
	static BigInteger zero= BigInteger.valueOf(0);
	static BigInteger one = BigInteger.valueOf(1);
	static BigInteger two = BigInteger.valueOf(2);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
	        int T = in.nextInt();
	        BigInteger result[] = new BigInteger[T];
	        for(int a0 = 0; a0 < T; a0++){
	            BigInteger N = in.nextBigInteger();
	            BigInteger K = in.nextBigInteger();
	            result[a0]=findMaxNumWithKFactor(N,K);
	        }
	        for(BigInteger long1: result){
	        	System.out.println(long1);
	        }
	}

	private static BigInteger findMaxNumWithKFactor(BigInteger N, BigInteger K) {
		// TODO Auto-generated method stub
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		BigInteger count=N;			
		while(list.size()!=1){
			if(findFactor(count,K)){
				list.add(count);
			}
			count=count.subtract(one);
		}
		if(list.size()>0)
		return list.get(0);
		else
			return BigInteger.valueOf(-1);
	}

	private static boolean findFactor(BigInteger count, BigInteger k) {
		// TODO Auto-generated method stub
		BigInteger factor =zero;
		HashMap<BigInteger,BigInteger> map = new HashMap<BigInteger, BigInteger>();
		while(count.remainder(two).equals(zero)){
				factor=factor.add(one);
				count=count.divide(two);
				map.put(two, factor);
		}
		BigInteger three = BigInteger.valueOf(3);
		for (BigInteger i = three; i.compareTo(count)<=0; i=i.add(two)) {
			factor =zero;
			while(count.remainder(i).equals(zero)){
				factor=factor.add(one);
				count=count.divide(i);
				map.put(i, factor);
			}
		}
		BigInteger finalFactor=one;
		for(Map.Entry<BigInteger, BigInteger> m1: map.entrySet()){
			finalFactor=finalFactor.multiply(m1.getValue().add(one));
		}
		if(finalFactor.compareTo(k)!=0)
		return false;
		else
			return true;
	}
}
