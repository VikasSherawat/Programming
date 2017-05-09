package greedy;

import java.util.*;

public class Crush {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        long  N,K,x=0l;
        int p,q,sum,i;
        long  max=0l;
        N = in.nextLong();
        K = in.nextLong();
        long[] a= new long[(int)N+1];

        for(i=0;i<K;i++)
        {
        	p = in.nextInt();
        	q = in.nextInt();
        	sum = in.nextInt();
            a[p]+=sum;
            if((q+1)<=N) 
            	a[q+1]-=sum;
        }
        
        for(i=1;i<=N;i++)
        {
           x=x+a[i];
           if(max<x) 
        	   max=x;

        }
        System.out.println(max);
        
	}

	private static long findMax(Map<Long, Long> map) {
		// TODO Auto-generated method stub
		long max = -1;
		for(Map.Entry<Long, Long> m1: map.entrySet()){
			if(max<m1.getValue())
				max = m1.getValue();
		}
		return max;
	}

}
