package mathematics.numbertheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PrimeSieve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = getPrimes(9999999);
		for(int i: list)
			System.out.print(i+" ");
	}

	public static List<Integer> getPrimes(int n) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] arr = new int[n+1];
		Arrays.fill(arr, 1);
		for (int i = 2; i <=n; i++) {
			if(arr[i]==1){
				list.add(i);
				for(int j = i*i;j>=0 && j<=n;j +=i){
					arr[j]=0;
				}
			}
		}
		return list;
	}

}
