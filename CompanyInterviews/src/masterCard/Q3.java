package masterCard;

import java.util.*;
public class Q3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]=in.nextInt();
		}
		
         int k = in.nextInt();
        int res = KDifference(arr, k);
        System.out.println(res);
        
        in.close();
	}
	 static int KDifference(int[] a, int k) {
		 Arrays.sort(a);

		 int count=0;
		 int len = a.length;
		 for (int i = 0; i < len; i++) {
			 count= count+ searchDiff(a,a[i]+k,0,len-1);
		}
		 return count;
	 }
	private static int searchDiff(int[] a, int item, int start, int end) {
		// TODO Auto-generated method stub
		
		if(start==end){
			if(a[start]!=item)
				return 0;
			else
				return 1;
		}
		int mid = (start+end)/2;
		if(item==a[mid])
			return 1;
		else if(item<a[mid]){
			return searchDiff(a,item,0,mid-1);
		}else{
			return searchDiff(a,item,mid+1,end);
		}
	}

}
