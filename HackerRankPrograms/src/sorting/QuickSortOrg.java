package sorting;

import java.util.Scanner;

public class QuickSortOrg {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		quickSortHelper(ar, 0, ar.length - 1);
		printArray(ar);
	}

	static void quickSortHelper(int[] ar, int start, int end) {
		if (start < end) {
			int splitpoint = partition(ar, start, end);
			quickSortHelper(ar, start, splitpoint - 1);
			quickSortHelper(ar, splitpoint + 1, end);
		}
	}

	static int partition(int[] ar, int start, int end) {
		int pivot = ar[start];
		int leftmark = start;
		int rightmark = end;
		int temp = 0;
		boolean done = false;
		while (!done) {
			while (leftmark <= rightmark && ar[leftmark] <= pivot) {
				leftmark++;
			}

			while (leftmark <= rightmark && ar[rightmark] >= pivot) {
				rightmark--;
			}
			if (rightmark < leftmark)
				done = true;
			else {
				// swap two elements
				temp = ar[leftmark];
				ar[leftmark] = ar[rightmark];
				ar[rightmark] = temp;
			}
		} // while loop ends here
		temp = ar[start];
		ar[start] = ar[rightmark];
		ar[rightmark] = temp;
		return rightmark;
	}

	static void prinIndextArray(int[] ar, int end) {
		for (int n = 0; n < end; n++) {
			System.out.print(ar[n] + " ");
		}
		System.out.println("");
	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

}
