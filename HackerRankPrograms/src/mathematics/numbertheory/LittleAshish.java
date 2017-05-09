package mathematics.numbertheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LittleAshish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			long X = in.nextLong() * 6;
			long ans = findAns(X);
			System.out.println(ans);
		}
	}

	private static long findAns(long x) {
		// TODO Auto-generated method stub
		long lo=1l, hi = 1000000l;
		long ans = 0l;
		while(lo<hi){
			long m = (lo+hi)/2;
			long sq = m*(m+1)*(2*m+1);
			if(sq<=x){
				ans = m;
				lo ++;
			}else{
				hi = m;
			}
			
			
		}
		return ans;
	}

}
