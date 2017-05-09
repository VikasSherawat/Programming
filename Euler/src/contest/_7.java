package contest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class _7 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Long> list = getPrime(10000);
		int T = in.nextInt();
		while(T-->0){
			int n = in.nextInt();
			System.out.println(list.get(n-1));
		}
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
	
	public static List<Long>  getPrime(long N){
		List<Long> list = new ArrayList<Long>();
		for(long i =2; i<=N;i++){
			if(isprime(i))
				list.add(i);
				
		}
		
		return list;
	}
}
