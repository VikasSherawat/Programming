package implementations;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RepeatedString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s = in.next();
		long n = in.nextLong();
		long slen = s.length();
		long anum = 0L;
		for (int i = 0; i < slen; i++) {
			if(s.charAt(i)=='a')
				anum++;
		}
		
		long div = n/slen;
		long rem = n%slen;
		
		long ans = anum * div;
		for (int i = 0; i <rem; i++) {
			if(s.charAt(i)=='a')
				ans++;
		}
		
		System.out.println(ans);
		
	}

}
