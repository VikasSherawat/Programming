package implementations;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StrangeCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		long T = in.nextLong();
		long num = 1,i=1;
		long terms = 0;
		for (i = 1; T > terms; i++) {
			num = 3 * (long)Math.pow(2, i-1);
			terms += num;
		}
		terms -= num;
		terms++;
		num = 3 * (long)Math.pow(2, i-2);
		System.out.println(num-(T-terms));
		
		
	}

}
