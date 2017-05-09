package bruteforce;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class InfiniteString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababab", t= "abab";
		String ans = new InfiniteString().equal(s, t);
		System.out.println(ans);
			

	}
	
	public String equal(String s, String t){
		String eq = "Equal";
		String nq = "Not equal";
		boolean flag = true;
		StringBuilder a = new StringBuilder(s);
		StringBuilder b = new StringBuilder(t);
		for (int i = 0; i < 30; i++) {
			a.append(s);
		}
		
		for (int i = 0; i < 30; i++) {
			b.append(t);
		}
		
		for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
			if(a.charAt(i)!=b.charAt(i)){
				flag = false;
				break;
			}
		}
		
		
		return flag?eq:nq;
	}

}
