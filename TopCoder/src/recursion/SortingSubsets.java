package recursion;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SortingSubsets {
	int ans =0;
	public static void main(String[] args) {
		int[] a = {4,4,4,3,3,3};
		int ans = new SortingSubsets().getMinimalSize(a);
		System.out.println(ans);
	}
	
	public int getMinimalSize(int[] a){
		int[] b = new int[a.length];
	    for(int i=0;i<a.length;i++)
	      b[i]=a[i];
	    Arrays.sort(a);
	    int res=0;
	    for(int i=0;i<a.length;i++)
	       if(a[i]!=b[i])
	          res++;
	    return res;
	}
}
