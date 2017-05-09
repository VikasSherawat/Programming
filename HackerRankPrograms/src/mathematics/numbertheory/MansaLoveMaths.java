package mathematics.numbertheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MansaLoveMaths {
	static List<Integer> list = new ArrayList();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		_8multiple(1000);

		while (T-- > 0) {
			String s = in.next();
			if (s.length() <= 5) {
				List<String> list = permutation(s);
				check(list);
				continue;
			}
			long[] arr = new long[10];
			for (int i = 0; i < s.length(); i++) {
				int n = s.charAt(i) - '0';
				arr[n]++;
			}
			if (arr[0]!=0||arr[2]!=0||arr[4]!=0||arr[6]!=0||arr[8]!=0) {
				solve(arr);
				continue;
			} else {
				System.out.println("NO");
			}
		}
	}

	private static void solve(long[] arr) {
		// TODO Auto-generated method stub
		int i = -1;
		while(++i < list.size()){
			int num = list.get(i);
			
			int one = num%10;
			num/=10;
			int ten = num%10;
			num/=10;
			int hun = num%10;
			long ah = -1;
			long at = -1;
			long ao = -1;
			
			if(ten==hun && hun==one){
				ah = at = ao = arr[hun]-3;
			}else if(ten==hun){
				ah = at = arr[ten]-2;
				ao = arr[one]-1;
			}else if(one==hun){
				ah = ao = arr[hun]-2;
				at = arr[ten]-1;
			}else if(ten==one){
				at = ao = arr[ten]-2;
				ah = arr[hun]-1;
			}else{
				 ah = arr[hun]-1;
				 at = arr[ten]-1;
				 ao = arr[one]-1;
			}
			
			
			if(ah>=0 && at>=0&&ao>=0){
				System.out.println("YES");
				return;
			}
			
		}
		System.out.println("NO");
		
	}

	private static void check(List<String> list) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {
			if (Integer.valueOf(list.get(i)) % 8 == 0) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}

	private static void _8multiple(int i) {
		// TODO Auto-generated method stub
		
		for (int j = 104; j <= 1000; j = j + 8) {
			list.add(j);
		}

	}

	public static List<String> permutation(String str) {
		List<String> list = new ArrayList<String>();
		permutation("", str, list);
		return list;
	}

	@SuppressWarnings("unchecked")
	private static void permutation(String prefix, String str, List<String> list) {
		int n = str.length();
		if (n == 0) {
			list.add(prefix);
			// System.out.println(prefix);
		} else {
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1, n), list);
		}
	}
}
