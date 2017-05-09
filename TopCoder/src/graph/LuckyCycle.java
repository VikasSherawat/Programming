package graph;

import java.time.temporal.WeekFields;
import java.util.*;

public class LuckyCycle {
	public int[] getEdge(int[] edge1, int[] edge2, int[] weight) {
		TreeMap<Integer, List<Integer>> f = new TreeMap<>();
		TreeMap<Integer, List<Integer>> s = new TreeMap<>();
		for (int i = 0; i < edge1.length; i++) {
			int x = edge1[i];
			int y = edge2[i];
			int w = weight[i];
			if (w == 4) {
				List<Integer> ls = null;
				if (f.containsKey(x)) {
					ls = f.get(x);
					ls.add(y);
				} else {
					ls = new ArrayList<>();
					ls.add(y);
					f.put(x, ls);
				}

				if (f.containsKey(y)) {
					ls = f.get(y);
					ls.add(x);
				} else {
					ls = new ArrayList<>();
					ls.add(x);
					f.put(y, ls);
				}
			} else {
				List<Integer> ls = null;
				if (s.containsKey(x)) {
					ls = s.get(x);
					ls.add(y);
				} else {
					ls = new ArrayList<>();
					ls.add(y);
					s.put(x, ls);
				}

				if (s.containsKey(y)) {
					ls = s.get(y);
					ls.add(x);
				} else {
					ls = new ArrayList<>();
					ls.add(x);
					s.put(y, ls);
				}
			}
		}
		TreeMap<Integer, List<Integer>> b = null, sm = null;

		for (Map.Entry<Integer, List<Integer>> m : f.entrySet()) {
			int k = m.getKey();
			List<Integer> ls = m.getValue();
			for(int i: ls){
				if(f.containsKey(i)){
					List<Integer> list = f.get(i);
					for(int j: list){
						if(j==k)
							continue;
						if(s.containsKey(j)){
							List<Integer> sLs = s.get(j);
							for(int xx: sLs){
								if(xx==k || xx==i)
									continue;
								return new int[]{k,xx,7};
							}
						}
					}
						
				}
			}
		}
		
		for (Map.Entry<Integer, List<Integer>> m : s.entrySet()) {
			int k = m.getKey();
			List<Integer> ls = m.getValue();
			for(int i: ls){
				if(s.containsKey(i)){
					List<Integer> list = s.get(i);
					for(int j: list){
						if(j==k)
							continue;
						if(f.containsKey(j)){
							List<Integer> sLs = f.get(j);
							for(int xx: sLs){
								if(xx==k || xx==i)
									continue;
								return new int[]{k,xx,4};
							}
						}
					}
						
				}
			}
		}
		return new int[]{};
	}

	public static void main(String[] args) {
		int[] edge1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int[] edge2 = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		int[] weight = {4, 4, 4, 4, 4, 4, 7, 7, 7, 7, 7, 7};
		System.out.println(Arrays.toString(new LuckyCycle().getEdge(edge1, edge2, weight)));
	}
}
