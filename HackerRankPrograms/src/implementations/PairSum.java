package implementations;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PairSum {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int[] a = {6,6,3,9,3,5,1};
		int k = 12;
		int count = numberOfPairs(a, k);
		System.out.println(count);

	}

	static int numberOfPairs(int[] a, long k) {
		int count = 0;
		Arrays.sort(a);
		int len = a.length;
		long search = 0l;
		//Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < len; i++) {
			int item = a[i];
			if(i!=0 && a[i]==a[i-1]){
				continue;
			}
				
			search = k-item;
			if(Arrays.binarySearch(a, i+1, len, (int)search)>=0){
				System.out.println("("+item+","+search+")");
				count++;
			}
		}

		return count;
	}

}
