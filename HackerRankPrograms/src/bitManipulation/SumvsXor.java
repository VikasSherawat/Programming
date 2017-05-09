package bitManipulation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SumvsXor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		long N = in.nextLong();
		String binary = Long.toBinaryString(N);
		long zeros = 0l;
		if(N==0){
			System.out.println(1);
			return;
		}
		for (int i = 0; i < binary.length(); i++) {
			if(binary.charAt(i)=='0')
				zeros++;	
		}
		
		System.out.println((long)Math.pow(2, zeros));
	}

}
