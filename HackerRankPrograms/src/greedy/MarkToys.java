package greedy;

import java.util.*;

public class MarkToys {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(),money=in.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<n;i++) 
        	list.add(in.nextInt());
        long sum = 0,count=0;
        Collections.sort(list);
        // Compute the final answer from n,k,prices
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			if(sum+integer<=money){
				sum+=integer;
				count++;
			//System.out.println("Integer,Sum,Count value is--"+integer+","+sum+","+count);
				}
			else
				break;
		}
        System.out.println(count);
	}

}
