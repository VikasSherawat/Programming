package greedy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Flowers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
	      
	      int N, K;
	      N = in.nextInt();
	      K = in.nextInt();
	      int result;
	      ArrayList<Integer> list = new ArrayList<Integer>();
	      for(int i=0; i<N; i++){
	    	  list.add(in.nextInt());
	      }
	      
	      Collections.sort(list);

	  result = findCost(list,N,K);
	  System.out.println(result);
	}

	private static int findCost(ArrayList<Integer> list, int N, int K) {
		// TODO Auto-generated method stub
		int sum=0,count=0;
		if(N==K)
		{
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Integer iter = (Integer) iterator.next();
				sum+=iter;
			}
			return sum;
		}else{
			for (int i = 0; i <N; i++) {
				count=i/K+1;
				sum+=count*list.get(N-1-i);
			}
			return sum;
		}
	}
}
