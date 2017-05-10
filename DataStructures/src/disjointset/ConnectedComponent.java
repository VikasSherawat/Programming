package disjointset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class ConnectedComponent {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		DisjointSet<Integer> set = new DisjointSet<Integer>(T);
		for (int i = 1; i <= 2 * T; i++) {
			set.makeSet(i);
		}
		while (T-- > 0) {
			int G = in.nextInt();
			int B = in.nextInt();
			set.union(G, B);
		}
		
		set.findMinMax();

	}
}
