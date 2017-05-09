package greedy;

import java.util.*;

public class MaxMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        int N=in.nextInt(),K=in.nextInt();
        //long[] ar = new long[N];
        ArrayList<Long> list = new ArrayList<Long>();
        for (int i = 0; i < N; i++) {
		list.add(in.nextLong());
		}
        Collections.sort(list);
  /*    10 
        20 
        30 
        100 
        200 
        300 
        1000 
*/
        long diff=list.get(list.size()-1);
        for (int i = 0; i+K-1 < list.size(); i++) {
        	long range = list.get(i+K-1)-list.get(i);
			if(range<diff){
				diff = range;
			}
		}
        
        System.out.println(diff);
	}

}
