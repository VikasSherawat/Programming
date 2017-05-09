package contest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class _10 {
	public static void main(String[] args) {
		ArrayList<Long> list = getPrime(1000000);
		ArrayList<Long> ls = new ArrayList<Long>();
		long sum =0l;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
			ls.add(sum);
		}
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T-->0){
			int t = in.nextInt();
			int idx = findIndex(list,t);
			System.out.println(ls.get(idx));
		}
		//System.out.println(0);
	}
	
	private static int findIndex(ArrayList<Long> list, int t) {
		// TODO Auto-generated method stub
		int lo = 0, hi = list.size();
		int ans = 0;
		if(list.get(list.size()-1)<=t){
			return list.size()-1;
		}
		while(lo<hi){
			if(list.get(lo)>t)
				break;
			int m = (lo+hi)/2;
			if(list.get(m)>t){
				hi = m;
			}else{
				ans = m;
				lo = m+1;
			}
		}
		return ans;
	}

	static boolean  isprime(long n){
	    //"""Returns true; if n is prime."""
	    if(n == 2)
	        return true;
	    if(n == 3)
	        return true;
	    if(n % 2 == 0)
	        return false;
	    if (n % 3 == 0)
	        return false;

	    long i = 5l;
	    long w = 2l;

	    while(i * i <= n){
	        if(n % i == 0)
	            return false;

	        i += w;
	        w = 6 - w;
	    }

	    return true;
	}
	
	public static ArrayList<Long>  getPrime(long N){
		ArrayList<Long> list = new ArrayList<Long>();
		for(long i =2; i<=N;i++){
			if(isprime(i))
				list.add(i);
				
		}
		
		return list;
	}
}
