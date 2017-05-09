package week27;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DrawingBook {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int p = in.nextInt();
		
		int front = p==1?0:(p-2)/2+1;
		int end = 0;
		if(n%2==1){
			end = (n-p)/2;
		}else{
			end = n==p?0:(n-1-p)/2 + 1;
		}
		
		System.out.println(Math.min(front, end));
		
	}

}
