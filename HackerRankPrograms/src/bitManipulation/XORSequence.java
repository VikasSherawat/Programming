package bitManipulation;

import java.math.BigInteger;
import java.util.Scanner;

public class XORSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		long a = 1000000000000000l;
		int T = in.nextInt();
		while (T-- > 0) {
			BigInteger L = in.nextBigInteger(), R = in.nextBigInteger();
			//int L = in.nextInt();
			//int R = in.nextInt();
			printXor(L.longValue(),R.longValue());
		}

	}

	private static void printXor(long l, long r) {
		// TODO Auto-generated method stub
		long sum = 0;
		for(long i = l;i<=r;i++){
			long rem = i%4;
			if(rem==0){
				sum ^= i;
			}else if(rem ==1){
				sum ^= 1;
			}else if(rem ==2){
				sum ^= (i+1);
			}else{
				continue;
			}	
		}
		
		System.out.println(sum);
		
	}


	

}
