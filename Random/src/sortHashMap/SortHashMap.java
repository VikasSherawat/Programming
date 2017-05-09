package sortHashMap;

import java.util.*;
import java.util.Map.Entry;

public class SortHashMap {
	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 10);
		map.put(11, 1);
		map.put(71, 5);
		Set<Entry<Integer, Integer>> set = map.entrySet();
		Comparator<Entry<Integer, Integer>> com = new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
		};

		List<Entry<Integer, Integer>> list = new ArrayList<>(set);
		Collections.sort(list, com);
		TreeSet<Entry<Integer, Integer>> setss = new TreeSet<>(com);
		for (Entry<Integer, Integer> e : list) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}
	}

}
