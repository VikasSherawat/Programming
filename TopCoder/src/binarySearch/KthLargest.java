package binarySearch;

public class KthLargest {
	public static void main(String[] args) {
		int[] a = { 0,3,2,1,4,5 };
		new KthLargest().kthEle(a, 1, 0, a.length - 1);
	}

	public void kthEle(int[] a, int k, int s, int e) {
		if (s < e) {
			int p = partition(a, s, e);
			if (p == k) {
				System.out.println(a[p]);
				return;
			} else {
				if (p < k) {
					kthEle(a, k, p + 1, e);
				} else {
					kthEle(a, k, s, p - 1);
				}
			}
		}else if(s==e && s==k){
			System.out.println(a[s]);
		}
	}

	private int partition(int[] ar, int start, int end) {
		// TODO Auto-generated method stub
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
}
