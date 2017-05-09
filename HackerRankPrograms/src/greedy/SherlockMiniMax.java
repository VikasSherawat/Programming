package greedy;

import java.util.*;
public class SherlockMiniMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner in = new Scanner(System.in);
	int N = in.nextInt();
	int[] arr = new int[N];
	for(int i=0;i<N;i++){
		arr[i]=in.nextInt();
	}
	int P = in.nextInt(), Q = in.nextInt();
	int result = findMinMax(arr,P,Q);
	System.out.println(result);
	}
	
	static int findMinMax(int[] arr, int P, int Q){
		int len = arr.length;
		List<Integer> list = new ArrayList<Integer>();
		int gMax = 0;
		int ans = P;
		for(int i=P;i<=Q;i++){
			int temp=0;
			int localMin = Integer.MAX_VALUE;
			for(int j=0;j<len;j++){
					temp = Math.abs(arr[j]-i);	
				if(localMin > temp )
					localMin = temp;	
			}//inner for loop
			
			if(gMax<localMin){
				gMax = localMin;
				ans = i;
				}
		}
		return ans;
	}
}
