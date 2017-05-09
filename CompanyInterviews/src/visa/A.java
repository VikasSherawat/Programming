package visa;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		//int [] arr = {2,1,5,6,3,10,4};
		int[] arr = {1};
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}
		solve(pq);
		
	}

	private static void solve(PriorityQueue<Integer> pq) {
		// TODO Auto-generated method stub
		int ans = 0;
		while(!pq.isEmpty()){
			int min = pq.poll();
			if(pq.isEmpty()){
				break;
			}
			
			int sMin = pq.poll();
			ans += min + sMin;
			pq.add(min + sMin);
		}
		
		System.out.println(ans);
	}

	

}
