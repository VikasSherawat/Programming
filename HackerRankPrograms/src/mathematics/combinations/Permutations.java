package mathematics.combinations;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Permutations {
	static List list  = new ArrayList();

	public Permutations() {
		super();
		
	}

	public static List permutation(String str) {
		permutation("", str);
		return list;
	}

	@SuppressWarnings("unchecked")
	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0){
			list.add(prefix);
			//System.out.println(prefix);
		}
		else {
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1, n));
		}
	}

	public static void main(String[] args) {
		List ls = permutation("123");
		Collections.sort(ls);
		for (int i = 0; i < ls.size(); i++) {
			System.out.println(ls.get(i));
		}
	}

}
