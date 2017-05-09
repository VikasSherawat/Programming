package bruteforce;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Initials {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "";
		String ans = new Initials().getInitials(name);
		System.out.println(ans);
	}
	
	public String getInitials(String name){
		String[] a = name.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			sb.append(a[i].charAt(0));
		}
		return sb.toString();
	}
}
