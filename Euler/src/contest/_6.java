package contest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class _6 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int n = in.nextInt();
			long a =(n*(n+1))/2;
			a *=a;
			
			long b = (n*(n+1))/2;
			b = (b*(2*n+1))/3;
			System.out.println(Math.abs(a-b));
		}

	}
}
