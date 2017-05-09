package implementations;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BeautifulTriplet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int D = in.nextInt();
		int[] arr = new int[N];
		
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
			set.add(arr[i]);
		}
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			
			if(set.contains(arr[i]+D) && set.contains(arr[i]+2*D)){
				count++;
			}
		}
		
		System.out.println(count);
		

	}
}
