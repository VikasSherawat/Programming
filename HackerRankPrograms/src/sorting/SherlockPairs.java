package sorting;

import java.math.BigInteger;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class SherlockPairs {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int T = in.nextInt();
	int[] ar;
	BigInteger[] result = new BigInteger[T];
	for (int i = 0; i < T; i++) {
		int N = in.nextInt();
		ar=new int[N];
		for (int j = 0; j < N; j++) {
			ar[j]=in.nextInt();
		}
		result[i]= findPairs(ar);
	}
	for (BigInteger i : result) {
		System.out.println(i);
	}
}

private static BigInteger findPairs(int[] ar) {
	// TODO Auto-generated method stub
	SortedMap<Integer, BigInteger> map = new TreeMap<Integer, BigInteger>();
	for (int i = 0; i < ar.length; i++) {
		if(map.containsKey(ar[i])){
			map.put(ar[i], map.get(ar[i]).add(BigInteger.valueOf(1)));
		}else
			map.put(ar[i], BigInteger.valueOf(1));
	}
	
	BigInteger sum=BigInteger.valueOf(0);
	for(Map.Entry m1: map.entrySet()){
		BigInteger value = (BigInteger)m1.getValue();
		if(value.intValue()>1)
		sum = sum.add(value.multiply(value.subtract(BigInteger.valueOf(1))));
	}
	return sum;
}
}
