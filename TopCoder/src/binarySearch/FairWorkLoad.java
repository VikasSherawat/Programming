package binarySearch;

public class FairWorkLoad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		int ans = getMostWork(arr, 3);
		System.out.println(ans);

	}

	public static int getMostWork(int[] folders, int workers) {
		int n = folders.length;
		int lo = findMax(folders);
		int hi = sum(folders);
		while (lo < hi) {
			int x = lo + (hi - lo) / 2;

			int required = 1, current_load = 0;
			for (int i = 0; i < n; ++i) {
				if (current_load + folders[i] <= x) {
					// the current worker can handle it
					current_load += folders[i];
				} else {
					// assign next worker
					++required;
					current_load = folders[i];
				}
			}

			if (required <= workers)
				hi = x;
			else
				lo = x + 1;
		}
		return lo;
	}

	private static int sum(int[] folders) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < folders.length; i++) {
			sum += folders[i];
		}
		return sum;
	}

	private static int findMax(int[] arr) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		return max;
	}

}
