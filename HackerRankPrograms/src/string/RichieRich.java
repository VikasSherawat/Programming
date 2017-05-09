package string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class RichieRich {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		String inp = in.next();
		Set<Integer> indexes = new HashSet<Integer>();
		for (int i = 0; i < n / 2; i++) {
			char f = inp.charAt(i);
			char l = inp.charAt(n - 1 - i);

			if (f != l) {
				indexes.add(i);
			}
		}

		if (indexes.size() > k)
			System.out.println("-1");
		else {
			StringBuilder sb = new StringBuilder(inp);
			Iterator<Integer> iter = indexes.iterator();
			while(iter.hasNext()){
				int index = iter.next();
				int f = Character.getNumericValue(sb.charAt(index));
				int l = Character.getNumericValue(sb.charAt(n - 1 - index));
				if (f > l) {
					sb.replace(n - 1 - index, n - index, String.valueOf(f));
				} else {
					sb.replace(index, index + 1, String.valueOf(l));
				}
			}

			k -= indexes.size();

			for (int i = 0; k>0 && i < sb.length() / 2; i++) {
				int c = Character.getNumericValue(sb.charAt(i));
				if(c==9)
					continue;
				
				if(indexes.contains(i)){
					sb.replace(i, i + 1, "9");
					sb.replace(n-1-i, n-i, "9");
					k--;
				}else{
					if(k>=2){
						sb.replace(i, i + 1, "9");
						sb.replace(n-1-i, n-i, "9");
						k = k-2;
					}
				}
			}
			
			if(n%2==1 && k>=1){
				sb.replace(n/2, n/2+1, "9");
			}
			
			System.out.println(sb.toString());
		}
	}
}
