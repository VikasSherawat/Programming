package mathematics;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ClosestNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T-->0){
			int a = in.nextInt();
			int b = in.nextInt();
			int x = in.nextInt();
			int res = findClosest(a,b,x);
			System.out.println(res);
		}
		
	}

	private static int findClosest(int a, int b, int x) {
		// TODO Auto-generated method stub
		int num = (int) Math.pow(a, b);
		int rem = num%x;
		if(rem <=x/2){
			return num-rem;
		}else
			return num+(x-rem);
	}
}
