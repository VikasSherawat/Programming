package set3;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IndustrialSpy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			char[] c = in.next().toCharArray();
			int[] arr = new int[c.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Character.getNumericValue(c[i]);
			}
			solve(arr);
		}
		in.close();
		System.out.println((System.currentTimeMillis()-start)/1000);

	}

	private static void solve(int[] arr) {
		// TODO Auto-generated method stub
		int l = (int) Math.pow(2, arr.length) - 1;
		int ans = 0;
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i <= l; i++) {
			String s = String.format("%" + arr.length + "s", Integer.toBinaryString(i)).replace(' ', '0');
			StringBuilder ss = new StringBuilder();
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '1') {
					ss.append(arr[j]);
				}
			}
			list.add(ss.toString());
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if (i != 0 && list.get(i).equals(list.get(i - 1)))
				continue;
			
			HashSet<String> perm = permutation(list.get(i));
			for (Iterator<String> iterator = perm.iterator(); iterator.hasNext();) {
				String string = iterator.next();
				int num = Integer.valueOf(string);
				if (set.contains(num))
					continue;
				if (BigInteger.valueOf(num).isProbablePrime(10)) {
					ans++;
					set.add(num);
				}
			}
		}
		System.out.println(ans);
	}

	public static HashSet<String> permutation(String str) {
		HashSet<String> set = new HashSet<String>();
		permutation("", str, set);
		return set;
	}

	@SuppressWarnings("unchecked")
	private static void permutation(String prefix, String str, HashSet<String> list) {
		int n = str.length();
		if (n == 0) {
			list.add(prefix);
			// System.out.println(prefix);
		} else {
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), list);
		}
	}
}
