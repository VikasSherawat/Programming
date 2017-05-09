package fb;

import java.util.*;

public class Q1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] arr  = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]=in.nextInt();
		}
		
		int M = in.nextInt();
		int[] arr1  = new int[M];
		for (int i = 0; i < N; i++) {
			arr1[i]=in.nextInt();
		}
		int[] arr2 = mergeArrays(arr, arr1);
		for(int i : arr2){
			System.out.println(i);
		}
	}
	 static int[] mergeArrays(int[] a, int[] b) {
		  
		    int aLen = a.length;
		    int bLen = a.length;
		    int[] result = new int[aLen+bLen]; 
		    int len = result.length;
		    int aIndex=0, bIndex=0;
		    for (int i = 0; i < len; i++) {
		    	int c=Integer.MAX_VALUE,d=Integer.MAX_VALUE;
				if(aIndex<aLen){
					c = a[aIndex];
				}
				if(bIndex<bLen){
					d = b[bIndex];
				}
				if(c<=d){
					result[i]=c;
					aIndex++;
				}else{
					bIndex++;
					result[i]=d;
				}
			}
		    return result;
		    }

}
