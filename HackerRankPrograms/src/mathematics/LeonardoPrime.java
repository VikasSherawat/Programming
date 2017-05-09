package mathematics;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LeonardoPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		List<Long> prime =getPrime(10000);
		int T = in.nextInt();
		while(T-->0){
			long N = in.nextLong();
			long res = UniqueFactor(N,prime);
			System.out.println(res);
		}
	}

	private static int UniqueFactor(long N, List<Long> prime) {
		// TODO Auto-generated method stub
		if(N==1)
			return 0;
		else if(N==2 || N==3)
			return 1;
		else{
			long res = 1l;
			int count = 0;
			for (int i = 0; i < prime.size(); i++) {
				long temp = res * prime.get(i);
				if(temp <0 || temp >N)
					break;
				if(temp == N){
					count++;
					break;
				}
				res *= prime.get(i);
				count++;
			}
			
			return count;
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
		for(long i =2; list.size()!=N;i++){
			if(isprime(i))
				list.add(i);
				
		}
		
		return list;
	}

}
