package string;

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

public class TopBiologist {
	public String findShortestNewSequence(String sequence) {
		List<String> list = new ArrayList<String>();
		list.add("");

		while (true) {
			list = getPerm(list);
			for (String s : list) {
				if (!sequence.contains(s))
					return s;
			}
		}
	}

	public List<String> getPerm(List<String> list) {
		List<String> list2 = new ArrayList<String>();
		for (String s : list) {
			list2.add(s + "A");
			list2.add(s + "T");
			list2.add(s + "C");
			list2.add(s + "G");
		}
		return list2;

	}
}
