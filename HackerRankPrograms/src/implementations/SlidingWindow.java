package implementations;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class SlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		maxInWindowK(arr, 4);
	}

	public static void maxInWindowK(int[] arr, int k) {
		// TODO Auto-generated method stub

		Deque<Integer> dq = new LinkedList<Integer>();
		int max = Integer.MIN_VALUE, index = 0;
		int[] a = getMax(0,k,arr);
		max = a[0];
		index = a[1];
		
		dq.offerFirst(max);
		System.out.print(dq.peekFirst() + " ");

		for (int i = k; i < arr.length; i++) {
			if(index+k-1<i){
				a = getMax(i+1-k,k,arr);
				max = a[0];
				index = a[1];
				dq.pollFirst();
				dq.offerFirst(max);
				
			}
			else if (arr[i] >= dq.peekFirst())  {
				dq.pollFirst();
				dq.offerFirst(arr[i]);
				index = i;
			}
			System.out.print(dq.peekFirst() + " ");
		}
	}

	private static int[] getMax(int j, int k, int[] arr) {
		// TODO Auto-generated method stub
		int max = -1, index = j;
		for (int i = j; i < j+k; i++) {
			if(arr[i]>=max){
				max = arr[i];
				index = i;
			}
		}
		return new int[]{max,index};
	}

}
