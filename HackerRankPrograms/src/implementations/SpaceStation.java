package implementations;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SpaceStation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int[] arr = new int[M];
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < M; i++) {
			arr[i] = in.nextInt();
			set.add(arr[i]);
		}
		int ans  = 0;
		for (int i = 0; i < N; i++) {
			int dist = Integer.MAX_VALUE;
			if(set.contains(i)){
				dist = 0;
			}else{
				for (int j = 0; j < M ; j++) {
					if(Math.abs(arr[j]-i)<dist)
						dist = Math.abs(arr[j]-i);
					else
						break;
				}
			}
			
			ans = Math.max(ans, dist);
		}
		
		System.out.println(ans);
	}

}
