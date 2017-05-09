package implementations;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NonDivisible {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		int[] rem = new int[k];
		for (int i = 0; i < n; i++) {
			int key = in.nextInt();
			int temp = key%k;
			arr[i] =  key;
			rem[temp]++;
		}
		if(k==1){
			System.out.println(1);
			return;
		}
		int count = 0;
		for (int i =1; i < k/2; i++) {
			count += Math.max(rem[i],rem[k-i]);
		}
		int c = 1000000000;
		count += rem[0]==0?0:1;
		if(k%2==0 && rem[k/2]!=0){
			System.out.println(++count);
		}else{
			if(k%2==1){
				count += Math.max(rem[k/2],rem[k/2+1]);
				System.out.println(count);
			}
		}
		
		
	}
}
