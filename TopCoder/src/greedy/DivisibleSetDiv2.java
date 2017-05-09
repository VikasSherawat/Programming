package greedy;

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

public class DivisibleSetDiv2 {

	public static void main(String[] args) {
		int[] b = {3,4,5,6,7};
		System.out.println(new DivisibleSetDiv2().isPossible(b));
	}

	public String isPossible(int[] b) {
		final String poss = "Possible";
		final String impo = "Impossible";
		
		int ans = 1;
		for (int i = 0; i < b.length; i++) {
			ans = (ans*b[i])/gcd(ans,b[i]);
		}
		int fin = 0;
		for (int i = 0; i < b.length; i++) {
			fin+=(ans/b[i]) ;
		}
		

		return ans>=fin?
				poss
				:impo;
	}

	private int gcd(int a, int b) {
		// TODO Auto-generated method stub
		int p = Math.max(a, b);
		int q = Math.min(a, b);
		if(q==0)
			return p;
		else
			return gcd(q,p%q);
	}
	
	/*def isPossible(self, b): 
        ans = 1 
        for i in b: 
            ans = (ans*i)/(gcd(ans, i)) 
        fin = 0 
        for i in b: 
            fin+=(ans/i) 
        return "Possible" if(ans>=fin) else "Impossible"*/

}