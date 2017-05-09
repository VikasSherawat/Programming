package mathematics.numbertheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AkhilGF {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T-->0){
			long N = in.nextLong();
			long M = in.nextLong();
			long ans = func(N,M);
			System.out.println(ans);
		}
	}

	private static long func(long n, long m) {
		// TODO Auto-generated method stub
		if(n< 6)
	    {
	        if(n==0)
	            return 0;
	        if(n==1)    
	            return 1;
	        if(n==2)
	            return 11%m;
	        if(n==3)
	            return 111%m;
	        if(n==4)
	            return 1111%m;
	        if(n==5)
	            return 11111%m;
	    }
	    if(n%2 == 0)
	    {
	        long temp = func(n/2 , m)%m;
	        long temp1 = (power(10,n/2,m)*temp + temp)%m;
	        return temp1;
	    }
	    else
	    {
	        long temp = func(n/2 , m)%m;
	        long temp1 = (power(10,n/2+1,m)*temp + temp*10 + 1)%m;
	        return temp1;
	    }
	}
	
	static long power(long a, long b, long mod) {
		long i,temp;
		long two = 2;
		if (b==1)
			return a%mod;
		if (b==0)
			return 1;
		
		if(b%2==0)
		{
		    temp=power(a,b/2,mod);
		    return (temp*temp)%mod;
		}

		else
		{
		    temp=power(a,b-1,mod);
		    return (temp*a)%mod;
		}

	}
}
