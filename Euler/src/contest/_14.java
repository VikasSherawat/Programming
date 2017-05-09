package contest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class _14 {
	static int[] a = new int[5000000];
	static int[] max = new int[5000000];
	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		fillData();
		fillMax();
		//System.out.println((System.currentTimeMillis()-s)/100);
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T-->0){
			int n = in.nextInt();
			System.out.println(max[n]);
		}
		in.close();
		
	}
	
	private static void fillMax() {
		// TODO Auto-generated method stub
		int m = -1, idx=-1;
		for (int i = 2; i < a.length; i++) {
			if(a[i]>=m){
				m = a[i];
				idx = i;
			}
				max[i] = idx;
		}
	}

	private static void fillData() {
		// TODO Auto-generated method stub
		for (long i = 2l; i <= 5000000; i++) {
		    long sequence = i;
		    int k = 0;
		    while (sequence != 1 && sequence >= i) {
		        
		    	if((sequence & (sequence-1))==0){
		    		k += Math.getExponent(sequence);
		    		break;
		    	}
		    	k++;
		        if ((sequence % 2) == 0) {
		            sequence = sequence / 2;
		        } else {
		            sequence = sequence * 3 + 1;
		        }
		    }
		    //Store result in a
		    a[(int)i] = k + a[(int)sequence];
		 
		    //Check if sequence is the best solution 
		}
		
	}

	public static int getColletz(int n){
		if(a[n]!=0){
			return a[n];
		}
		
		if((n&(n-1))==0){
			return Math.getExponent(n);
		}
		
		if(n%2==0){
			return 1+getColletz(n/2);
		}else{
			return 1+getColletz(3*n+1);
		}
	}
}
