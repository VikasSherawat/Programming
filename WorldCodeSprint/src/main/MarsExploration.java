package main;

import java.util.*;

public class MarsExploration {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String inp = in.next();
	int len = inp.length();
	String base ="";
	for (int i = 0; i <len/3; i++) {
		base+="SOS";
	}
	int len1 = base.length();
	int count=0;
	for (int i = 0; i < len; i++) {
		if(inp.charAt(i)!=base.charAt(i))
			count++;
	}
	System.out.println(count);
}
}
