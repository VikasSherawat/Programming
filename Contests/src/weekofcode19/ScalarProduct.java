package weekofcode19;

import java.math.BigInteger;
import java.util.*;

public class ScalarProduct {

	static BigInteger zero = BigInteger.valueOf(0);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		BigInteger C = in.nextBigInteger(),M= in.nextBigInteger(),N= in.nextBigInteger();
		//List<Integer> list = new ArrayList<Integer>();
		BigInteger[] bigI = new BigInteger[2*N.intValue()+2];
		bigI[0] = zero;bigI[1]=C;
		int size = bigI.length;
		for(int i=2;i<size;i++){
			bigI[i]= (bigI[i-1].add(bigI[i-2])).remainder(M);
		}
		long list= findVectorProduct(bigI,M);
		System.out.println(list);
		
	}
		private static long findVectorProduct(BigInteger[] bigI,BigInteger M) {
			// TODO Auto-generated method stub
			List<BigInteger> list = new ArrayList<BigInteger>();
			BigInteger temp;
			long size = M.longValue();
			int len = bigI.length;
			for(int i=2;i<=len-4 && list.size()!=size;i=i+2){
				for(int j=i+2;j<=len-2 && list.size()!=size;j=j+2){
					temp = bigI[i].multiply(bigI[j]);
					temp = temp.add(bigI[i+1].multiply(bigI[j+1]));
					temp=temp.remainder(M);
					if(!list.contains(temp)){
						list.add(temp);
					}
				}
			}
			return list.size();
		}


}
