package contest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class _5 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T-->0){
			int n = in.nextInt();
			long lcm = 1;
			for (int i = 2; i <=n; i++) {
				lcm = LCM(Math.max(lcm, i), Math.min(lcm, i));
			}
			System.out.println(lcm);
		}
	}
	
	public static long GCD(long l, long m)
	{
	   if (m==0) return l;
	   return GCD(m,l%m);
	}
	
	public static long LCM(long l, long m)
	{
	   return m*l/GCD(l,m);
	}
}
