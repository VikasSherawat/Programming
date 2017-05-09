package search;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BeautifulQuadruples {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();
		int D = in.nextInt();

		Set<Integer> aset = new HashSet<Integer>();
		Map<Integer,String> map = new TreeMap<Integer, String>();
		for (int i = 1; i <= A; i++) {
			for (int j = i; j <= B; j++) {
				int temp = i ^ j;
				aset.add(temp);
				map.put(temp, i+","+j);
			}
		}

		Set<Integer> bset = new HashSet<Integer>();
		Map<Integer,String> bmap = new TreeMap<Integer, String>();
		for (int i = 1; i <= C; i++) {
			for (int j = i; j <= D; j++) {
				int temp = i ^ j;
				bset.add(temp);
				bmap.put(temp, i+","+j);
			}
		}

		Iterator<Integer> it = aset.iterator();
		int count = 0;
		while (it.hasNext()) {
			int a = it.next();
			Iterator<Integer> itb = bset.iterator();
			while (itb.hasNext()) {
				int b = itb.next();
				System.out.println(a+","+b);
				if ((a ^ b) != 0) {
					count++;
				}
			}
		}

		System.out.println(count);
	}
}
