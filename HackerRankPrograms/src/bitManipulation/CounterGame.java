package bitManipulation;

import java.math.BigInteger;
import java.util.*;

public class CounterGame {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			BigInteger n = in.nextBigInteger();
			solve(n);

		}
		in.close();

	}

	private static void solve(BigInteger n) {
		// TODO Auto-generated method stub
		if(n.compareTo(BigInteger.ONE)==0){
			System.out.println("Richard");
			return;
		}
		int turn = 1;
		BigInteger two = BigInteger.valueOf(2);
		while(n.compareTo(BigInteger.ONE)==1){
			if(n.and(n.subtract(BigInteger.ONE)).compareTo(BigInteger.ZERO)==0){
				n = n.divide(BigInteger.valueOf(2));
			}else{
				int len =n.toString(2).length();
				n = n.subtract(two.pow(len-1));
			}
			
			turn = 1-turn;
		}
		
		System.out.println(turn==1?"Richard":"Louise");
	}

}