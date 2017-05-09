package bruteforce;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BearPasswordAny {
	public static void main(String[] args) {
		int[] x = {5,0,0,0,0};
		System.out.println(new BearPasswordAny().findPassword(x));
	}

	public String findPassword(int[] x) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < x.length; i++) {
			sb.append(1);
		}
		if (!possible(x)) {
			return "";
		}

		if (anyElement(x)) {
			for (int i = 0; i < x.length; i++) {
				if (!(x[i] == x.length - i)) {
					return "";
				}
			}
			return sb.toString().replaceAll("0", "b").replaceAll("1", "a");
		}
		int start = 0;
		for (int i = x.length - 1; i >0; i--) {
			if (x[i] == 0) {
				continue;
			}
			for (int j = 0; j < i+1; j++) {
				sb.replace(start, start+i+1, "0");
			}
			start += i+1;
			if(isFine(sb.toString(),x)){
				return sb.toString().replaceAll("0", "b").replaceAll("1", "a");
			}
		}

		return sb.toString().replaceAll("0", "b").replaceAll("1", "a");
	}

	private boolean isFine(String s, int[] x) {
		// TODO Auto-generated method stub
		for (int i = 1; i < x.length; i++) {
			int n = x[i];
			int times = 0;
			for (int j = 0; j < s.length()-i; j++) {
				if(constant(s.substring(j, i+1))){
					times++;
				}
			}
			if(times!=n){
				return false;
			}
			
		}
		return true;
	}

	private boolean constant(String s) {
		// TODO Auto-generated method stub
		for (int i = 0; i < s.length()-1; i++) {
			if(s.charAt(i)!=s.charAt(i+1))
				return false;
		}
		return true;
	}

	private boolean anyElement(int[] x) {
		// TODO Auto-generated method stub
		for (int i = 1; i < x.length; i++) {
			if (x[i] == x.length - i) {
				return true;
			}
		}
		return false;
	}

	private boolean possible(int[] x) {
		// TODO Auto-generated method stub
		if(x.length==1 && x[0]==0)
			return false;
		for (int i = 0; i < x.length; i++) {
			if (x[i] > x.length - i ) {
				return false;
			}
			if(i!=x.length-1 && x[i]<x[i+1])
				return false;
		}
		return true;
	}
}
