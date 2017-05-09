package greedy;

import java.util.*;
import java.util.TreeMap;

public class Arrfix {
	public static void main(String[] args) {

		int[] A = { 2, 2, 1 ,5,6};
		int[] B = { 2, 2, 3,5,6 };
		int[] F = { 2, 2,5,6 };
		System.out.println(new Arrfix().mindiff(A, B, F));
	}

	public int mindiff(int[] A, int[] B, int[] F) {
		int sticker = F.length;
		boolean[] ch = new boolean[A.length];
		TreeMap<Integer, Integer> sr = new TreeMap<Integer, Integer>();
		for (int i = 0; i < F.length; i++) {
			if (sr.containsKey(F[i])) {
				sr.put(F[i], sr.get(F[i]) + 1);
			} else {
				sr.put(F[i], 1);
			}
		}
		int diff = 0;
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] != B[i]) {
				if (sr.size() > 0 && sr.containsKey(B[i])) {
					A[i] = B[i];
					ch[i] = true;
					sticker--;
					if (sr.get(B[i]) > 1) {
						sr.put(B[i], sr.get(B[i]) - 1);
					} else {
						sr.remove(B[i]);
					}
				} else {
					map.put(i, B[i]);
					diff++;
				}
			}
		}

		for (int i = 0; i < A.length; i++) {
			if (sticker == 0)
				break;
			if (ch[i])
				continue;

			if (sr.size() > 0 && sr.containsKey(B[i])) {
				if (sr.get(B[i]) > 1) {
					sr.put(B[i], sr.get(B[i]) - 1);
				} else {
					sr.remove(B[i]);
				}
				sticker--;
				ch[i] = true;
			}
		}

		diff = Math.max(map.size(), sticker);
		/*
		 * for (Map.Entry<Integer, Integer> m : map.entrySet()) { int i =
		 * m.getKey(); int val = m.getValue();
		 * 
		 * }
		 * 
		 * for (int i = 0; i < A.length; i++) { if (sticker == 0) { break; } if
		 * (ch[i]) { continue; } if (A[i] == B[i]) { if (!sr.containsKey(A[i]))
		 * { diff++; } else { if (sr.get(A[i]) > 1) { sr.put(A[i], sr.get(A[i])
		 * - 1); } else { sr.remove(A[i]); } } } else { // diff++; }
		 * 
		 * sticker--; }
		 */

		return diff;
	}
}
