package implementations;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LadyBugs {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			String s = in.next();
			checkHappy(s);
		}
	}

	private static void checkHappy(String s) {
		// TODO Auto-generated method stub
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		int _count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '_')
				_count++;

			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		if (_count == 0) {
			System.out.println(checkIfHappy(s)?"YES":"NO");
			return;
		} else {
			for (Map.Entry<Character, Integer> m : map.entrySet()) {
				char key = m.getKey();
				int value = m.getValue();
				if (key != '_' && value == 1) {
					System.out.println("NO");
					return;
				}
			}

			System.out.println("YES");
		}

	}

	private static boolean checkIfHappy(String s) {
		if(s.length()==1){
			return false;
		}
		
		for (int i = 0; i < s.length()-1; i++) {
			char c = s.charAt(i);
			if(i==0 && s.charAt(i+1)!=c){
				return false;
			}else{
				if(!(c==s.charAt(i+1)||c==s.charAt(i-1))){
					return false;
				}
			}
		}
		if(s.charAt(s.length()-1)==s.charAt(s.length()-2))
			return true;
		else
			return false;
	}
		
		
}
