package dynamicProgramming;

import java.lang.reflect.Array;
import java.util.*;

//without recursion
public class Permutations {
	 
	public static void main(String[] args) {
		String s = "123";
		String s1 = "EBAY";
		String s2 = "Yahoo";
		ArrayList<String> list = doPermutations(s);
		Collections.sort(list);
		System.out.println("Number of elements are--"+list.size());
		for(String str: list){
			System.out.println(str);
		}
	}

	private static ArrayList<String> doPermutations(String s) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		Map<Integer, ArrayList<String>> map = new TreeMap<Integer, ArrayList<String>>();
		if(s==null){
			return null;
		}else{
			list.add(s.substring(0, 1));
			map.put(0, list);
			for (int i = 1; i < s.length(); i++) {
				ArrayList<String> list1 = findPermutations(map.get(i-1),s.substring(i, i+1));
				map.put(i, list1);
			}
		}
		return map.get(s.length()-1);
	}

	private static ArrayList<String> findPermutations(
			ArrayList<String> arrayList, String index) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		for(String str: arrayList){
			String temp="";
			for (int i = 0; i <= str.length(); i++) {
				String left = str.substring(0, i);
				String right = str.substring(i);
				temp=left+index+right;
				list.add(temp);
			}
		}
		return list;
	}
 
}