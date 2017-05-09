package bruteforce;

import java.util.*;

public class BearChairs {
	public static void main(String[] args) {
		int[] atLeast = { 1000000, 1000000, 1000000, 1 };
		int d = 999999;
		System.out.println(Arrays.toString(new BearChairs().findPositions(atLeast, d)));
	}

	public int[] findPositions(int[] atLeast, int d) {
		int[] a = new int[atLeast.length];
		a[0] = atLeast[0];
		int avail = a[0] + d;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(a[0], 1);
		for (int i = 1; i < a.length; i++) {
			if (atLeast[i] >= avail) {
				a[i] = atLeast[i];
				map.put(atLeast[i], 1);
				avail = atLeast[i] + d;
			} else {
				int val = search(map, atLeast[i], d);
				if (val == -1) {
					map.put(avail, 1);
					a[i] = avail;
					avail += d;
				} else {
					map.put(val, 1);
					a[i] = val;
				}
			}
		}
		return a;
	}

	private int search(TreeMap<Integer, Integer> map, int n, int d) {
		// TODO Auto-generated method stub
		int key = 0, prev = -1, next = -1;
		key = map.firstKey();
		if(n+d<=key){
			return n;
		}
		
		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			key = m.getKey();
			if (prev == -1) {
				prev = next = key;
			} else {
				prev = next;
				next = key;
			}

			if ((next - prev) >= 2 * d && prev + d >= n) {
				return prev + d;
			}

		}
		return -1;
	}
}
