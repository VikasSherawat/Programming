package main;

import java.util.Arrays;

public class SegmentTree {
	int orgArrayLength;

	public int[] createMinSegmentTree(int[] inpArr) {
		int n = inpArr.length;
		orgArrayLength = n;
		int[] segArr;
		if ((n & (n - 1)) == 0) {
			segArr = new int[2 * n - 1];
		} else {
			int pow = 1;
			while (pow < n) {
				pow <<= 1;
			}
			segArr = new int[2 * pow - 1];
		}

		Arrays.fill(segArr, Integer.MAX_VALUE);
		createSegmentTree(inpArr, segArr, 0, n - 1, 0);

		return segArr;
	}

	private void createSegmentTree(int[] inpArr, int[] segArray, int start,
			int end, int pos) {

		if (start == end) {
			segArray[pos] = inpArr[start];
		} else {
			int mid = (start + end) / 2;
			createSegmentTree(inpArr, segArray, start, mid, 2 * pos + 1);
			createSegmentTree(inpArr, segArray, mid + 1, end, 2 * pos + 2);
			segArray[pos] = Math.min(segArray[2 * pos + 1],
					segArray[2 * pos + 2]);
		}
	}

	public int findMinimum(int[] arr, int a, int b) {
		return minRange(arr, a, b, 0, orgArrayLength - 1, 0);
	}

	private int minRange(int[] arr, int qStart, int qEnd, int start, int end,
			int pos) {
		if (qStart <= start && qEnd >= end) { // complete overlap
			return arr[pos];
		} else if (qStart > end || qEnd < start) { // no overlap
			return Integer.MAX_VALUE;
		} else { // partial overlap
			int mid = (start + end) / 2;
			return Math.min(
					minRange(arr, qStart, qEnd, start, mid, 2 * pos + 1),
					minRange(arr, qStart, qEnd, mid + 1, end, 2 * pos + 2));
		}
	}

	private int findMaximum(int[] arr, int a, int b) {
		// for finding Maximum value used Math.max while creating segment Array
		return maxRange(arr, a, b, 0, orgArrayLength - 1, 0);
	}

	private int maxRange(int[] arr, int qStart, int qEnd, int start, int end,int pos) {
		// TODO Auto-generated method stub
		if (qStart <= start && qEnd >= end) { // complete overlap
			return arr[pos];
		} else if (qStart > end || qEnd < start) { // no overlap
			return Integer.MIN_VALUE;
		} else {
			int mid = (start + end) / 2;
			return Math.max(
					minRange(arr, qStart, qEnd, start, mid, 2 * pos + 1),
					minRange(arr, qStart, qEnd, mid + 1, end, 2 * pos + 2));
		}
	}

	public static void main(String[] args) {
		int[] arr = { -1, 3, 4, 0, 2, 1 };
		int[] segTree = new SegmentTree().createMinSegmentTree(arr);
		for(int i : segTree)
			System.out.print(i+" ");
	}
}
