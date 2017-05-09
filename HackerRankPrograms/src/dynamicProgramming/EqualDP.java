package dynamicProgramming;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EqualDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < N; i++) {
				list.add(in.nextInt());

			}

			Collections.sort(list);
			new EqualDP().solve(list);
		}
	}

	private void solve(List<Integer> list) {
		// TODO Auto-generated method stub
		int min = list.get(0);
		int count = 0;
		for (int i = list.size() - 1; i > 0; i--) {
			int ele = list.get(i);
			if (ele != min)
				count += calchoc(ele, min);
		}

		System.out.println(count);
	}

	private int calchoc(int ele, int min) {
		// TODO Auto-generated method stub
		int choc = 0;
		int diff = Math.abs(ele - min);

		if (diff >= 5) {
			int q = diff/5;
			choc += q;
			
			diff -= 5 * q;
			
		}

		if (diff >= 2) {
			int q = diff/2;
			choc += q;
			
			diff -= 2 * q;
		}
		if (diff != 0)
			choc++;

		return choc;
	}

}
