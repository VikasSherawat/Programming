package dataStructures.Array;

import java.util.*;;
public class RotateArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6};
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		System.out.println("Original Arrays:"+Arrays.toString(arr));
		rotate(arr,k);
		System.out.println("Array After rotation:"+Arrays.toString(arr));

	}

	private static void rotate(int[] arr, int k) {
		// TODO Auto-generated method stub
		reverse(arr,0,k-1);
		reverse(arr,k,arr.length-1);
		reverse(arr,0,arr.length-1);
	}

	private static void reverse(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		for (int i = start; i <= (start+end)/2; i++) {
			swap(arr,i,(start+end)-i);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]= temp;
		
	}
	

}
