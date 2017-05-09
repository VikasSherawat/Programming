package graph;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SeparateConnections {
	public static void main(String[] args) {
		String[] arr = { "NNNNNNNNNYNNNNNYN", "NNNNNNNNNNNNNNNNN", "NNNNNNNYNNNNNNNNN", "NNNNNYNNNNNYNNYYY",
				"NNNNNNNNNNNNNNNYN", "NNNYNNNNNNNNNNYNN", "NNNNNNNNNYNNNNNNN", "NNYNNNNNNNNNNNNNN", "NNNNNNNNNYNNNNNNN",
				"YNNNNNYNYNNNNNNNY", "NNNNNNNNNNNNNNNNN", "NNNYNNNNNNNNNNNNN", "NNNNNNNNNNNNNNNNN", "NNNNNNNNNNNNNNNNN",
				"NNNYNYNNNNNNNNNNN", "YNNYYNNNNNNNNNNNN", "NNNYNNNNNYNNNNNNN" };
		int ans = new SeparateConnections().howMany(arr);
		System.out.println(ans);
	}

	public int howMany(String[] mat) {
		int ans = 0;
		List<ArrayList<Integer>> list = getArray(mat);
		int[] arr = new int[mat.length];

		int count = 0;
		while (count++ < mat.length) {
			int idx = getMin(list, arr);
			if (idx == -1) {
				continue;
			}
			if (arr[idx] == 1)
				continue;

			List<Integer> ls = list.get(idx);
			int item = ls.remove(0);
			while (arr[item] != 0 && ls.size() > 0) {
				item = ls.remove(0);
			}

			if (arr[item] == 0) {
				arr[item] = arr[idx] = 1;
				ans += 2;
			} else {
				arr[idx] = 1;
			}
			// if (ls.size() == 0) {
			// list.remove(idx);
			// }
		}
		return ans;
	}

	private int getMin(List<ArrayList<Integer>> list, int[] arr) {
		// TODO Auto-generated method stub
		int min = 20, index = -1;
		for (int i = 0; i < list.size(); i++) {
			int size = list.get(i).size();
			if (arr[i] == 0 && size!=0 && size < min) {
				min = list.get(i).size();
				index = i;
			}
		}
		return index;
	}

	private List<ArrayList<Integer>> getArray(String[] s) {
		// TODO Auto-generated method stub
		List<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < s.length; i++) {
			ArrayList<Integer> child = new ArrayList<>();
			String ss = s[i];
			for (int j = 0; j < ss.length(); j++) {
				if (ss.charAt(j) == 'Y') {
					child.add(j);
				}
			}
			list.add(child);
		}
		return list;
	}

}
