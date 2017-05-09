package search;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ShortPallindrome {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String S = in.next();
		Map<Character,TreeSet<Integer>> map  = new TreeMap<Character, TreeSet<Integer>>();
		int[] arr = new int[26];
		for (int i = 0; i < S.length(); i++) {
			TreeSet<Integer> ts;
			char c = S.charAt(i);
			arr[c - 'a']++;
			if(map.containsKey(c)){
				ts = map.get(c);
				ts.add(i);
			}else{
				ts = new TreeSet<Integer>();
				ts.add(i);
				map.put(c, ts);
			}
		}
		
		
		
		new ShortPallindrome().solve(map,arr);
	}

	private void solve(Map<Character, TreeSet<Integer>> map, int[] arr) {
		// TODO Auto-generated method stub
		long ans = 0l;
		long CONS = 1000000007l;	
		for(Map.Entry<Character,TreeSet<Integer>> m: map.entrySet()){
			char key = m.getKey();
			TreeSet<Integer> list = m.getValue();
			for(Map.Entry<Character,TreeSet<Integer>> m1: map.entrySet()){
				char key2 = m.getKey();
				if(key==key2)
					continue;
				TreeSet<Integer> list2 = m.getValue();
				ans += countways(list, list2,arr);
			}
			ans %= CONS;
		}
		
		for(Map.Entry<Character,TreeSet<Integer>> m: map.entrySet()){
			char key = m.getKey();
			TreeSet<Integer> list = m.getValue();
			if(list.size()>=4){
				ans += fact(list.size());
			}
			ans %= CONS;
		}
		
		
		System.out.println();
		
		
	}


	private long countways(TreeSet<Integer> a, TreeSet<Integer> b, int[] arr) {
		// TODO Auto-generated method stub
		Iterator<Integer> ia = a.iterator();
		
		int sizea = a.size();
		int sizeb = b.size();
		int i = 0;
		long ans = 0l;
		while(ia.hasNext()){
			int y = 0;
			int elea = ia.next();
			int index = b.size() - b.headSet(b.ceiling(elea)).size();
		}
		return 0;
	}
	
	private long fact(int size) {
		// TODO Auto-generated method stub
		long CONS = 1000000007l;
		BigInteger num = BigInteger.valueOf(size);
		for (int i = size; i >size-4 ; i--) {
			num = num.multiply(BigInteger.valueOf(i));
		}
		num = num.divide(BigInteger.valueOf(24));
		num = num.remainder(BigInteger.valueOf(CONS));
		return num.longValue();
		
	}

}
