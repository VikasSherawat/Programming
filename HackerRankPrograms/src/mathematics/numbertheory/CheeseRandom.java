package mathematics.numbertheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CheeseRandom {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			int R = in.nextInt();
			int M = in.nextInt();
			System.out.println(nCrModpLucas(N, R, M));
		}
	}
	
	public static long nCrModpDP(int n, int r, int p)
	{
	    // The array C is going to store last row of
	    // pascal triangle at the end. And last entry
	    // of last row is nCr
	    long C[] = new long[r+1];
	 
	    C[0] = 1; // Top row of Pascal Triangle
	 
	    // One by constructs remaining rows of Pascal
	    // Triangle from top to bottom
	    for (int i = 1; i <= n; i++)
	    {
	        // Fill entries of current row using previous
	        // row values
	        for (int j = Math.min(i, r); j > 0; j--)
	 
	            // nCj = (n-1)Cj + (n-1)C(j-1);
	            C[j] = (C[j] + C[j-1])%p;
	    }
	    return C[r];
	}
	
	// Lucas Theorem based function that returns nCr % p
	// This function works like decimal to binary conversion
	// recursive function.  First we compute last digits of
	// n and r in base p, then recur for remaining digits
	public static long nCrModpLucas(int n, int r, int p)
	{
	   // Base case
	   if (r==0)
	      return 1l;
	 
	   // Compute last digits of n and r in base p
	   int ni = n%p, ri = r%p;
	 
	   // Compute result for last digits computed above, and
	   // for remaining digits.  Multiply the two results and
	   // compute the result of multiplication in modulo p.
	   return (nCrModpLucas(n/p, r/p, p) * // Last digits of n and r
	           nCrModpDP(ni, ri, p)) % p;  // Remaining digits
	}
}
