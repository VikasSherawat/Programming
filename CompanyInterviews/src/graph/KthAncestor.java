package graph;

import java.util.*;

public class KthAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		Scanner in = new Scanner(System.in);
		List<Integer> result = new ArrayList<Integer>();
		int T = in.nextInt();
		while (T-- > 0) {
			int P = in.nextInt();
			Map<Integer, List<Integer>> parentMap = new TreeMap<Integer, List<Integer>>();

			int root = -1;
			while (P-- > 0) {
				int X = in.nextInt();
				int Y = in.nextInt();

				int Q = in.nextInt();
				while (Q-- > 0) {

				}

			}
		}
		// for(int i: list)
		System.out.println(Arrays.toString(result.toArray())
				.replaceAll("[\\[\\]]", "").replaceAll(" ", "")
				.replaceAll(",", "\n"));
		long end = System.currentTimeMillis();
		System.out.println("Time used: " + (end - start));
	}

}
