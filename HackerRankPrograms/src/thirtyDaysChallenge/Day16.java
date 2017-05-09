package thirtyDaysChallenge;

import java.util.*;



public class Day16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		ArrayList<Long> list = new ArrayList<Long>();
		//long[] ar = new long[N];
		for (int i = 0; i < N; i++) {
			list.add(in.nextLong());
		}
		Collections.sort(list);
		findClosestDiff(list);
	//	quickSortHelper(ar,0,ar.length-1);
	}

	private static void findClosestDiff(ArrayList<Long> ar) {
		// TODO Auto-generated method stub
		long diff = 999999999;
		ArrayList<Long> list = new ArrayList<Long>();
		int len = ar.size();
		for (int i = 0; i < len-1; i++) {
				long temp = Math.abs(ar.get(i+1)-ar.get(i));
				if(temp<diff)
				{
					list.clear();
					list.add(ar.get(i));
					list.add(ar.get(i+1));
					diff = temp;
				}else if(temp == diff){
					list.add(ar.get(i));
					list.add(ar.get(i+1));
				}
		}
		//Object[] ar1 = new Object[list.size()];
		//ar1 =list.toArray();
		//quickSortHelper(ar1,0,ar1.length-1);
		printList(list);
	}
	
	 private static void printList(ArrayList<Long> ar1) {
		// TODO Auto-generated method stub
		 int len = ar1.size();
		for (int i = 0; i < len; i++) {
			System.out.print(ar1.get(i)+" ");
		}
	}

}
