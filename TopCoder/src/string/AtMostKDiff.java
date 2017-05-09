package string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AtMostKDiff {
	public static void main(String[] args) {
		String s = "vikasssuazmmmrrr";
		int k = 3;
		System.out.println(new AtMostKDiff().len(s, k));
	}
	
	public int len(String s, int k){
		int ans = 0;
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
		}
		return ans;
	}
}
