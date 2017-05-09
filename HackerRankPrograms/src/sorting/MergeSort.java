package sorting;

import java.util.Scanner;

public class MergeSort {
	static int result = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		divideArray(arr, 0, arr.length - 1);
	//	System.out.println(result);
		printArray(arr);
	}

	private static void divideArray(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if (start < end) {
			int split = (start + end) / 2;
			divideArray(arr, start, split);
			divideArray(arr, split + 1, end);
			mergeArray(arr, start, split, end);
		}
	}

	private static void mergeArray(int[] arr, int start, int split, int end) {
		// TODO Auto-generated method stub
		int[] cArr = new int[arr.length];
		int i = start, j = split + 1, k = 0;
		/*
		 * runs through two arrays first one scans from start to split index
		 * second array scans from split+1 to end index
		 */
		while (i <= split && j <= end) {
			if (arr[i] < arr[j]) {// if element from 1st array is smaller
				cArr[k++] = arr[i++]; // that element goes to the backup array
			} else {
//				result += split - i + 1;
				cArr[k++] = arr[j++]; // else element from second half goes to
										// the backup array
			}
		} // while ends here

		while (i <= split) {
			cArr[k++] = arr[i++];
		}

		while (j <= end) {
			cArr[k++] = arr[j++];
		}

		for (i = end; i >= start; i--) {
			arr[i] = cArr[--k]; // copying back the sorted list to a[]
		}
		// printArray(arr);
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
}
