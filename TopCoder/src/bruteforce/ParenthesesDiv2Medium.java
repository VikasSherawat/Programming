package bruteforce;

import java.util.*;

public class ParenthesesDiv2Medium {

	public static void main(String[] args) {
		String s = "(()()()()()()()()()()()())";
		int[] a = new ParenthesesDiv2Medium().correct(s);
		System.out.println(Arrays.toString(a));
	}
	
	public int[] correct(String s){
		HashSet<Integer> set = new HashSet<>();
		Stack<Integer> idx = new Stack<>();
		Stack<Character> st = new Stack<>();
		
		char l = '(', r = ')';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c==r){
				if(st.size()==0){
					set.add(i);
					st.push(l);
					idx.add(i);
				}else{
					st.pop();
					idx.pop();
				}
			}else{
				idx.add(i);
				st.push(l);
			}
		}
		while(idx.size()>=2){
			int last = idx.pop();
			set.add(last);
			idx.pop();
		}
		
		
		int[] arr = set2Array(set);
		return arr;
	}

	private int[] set2Array(HashSet<Integer> set) {
		// TODO Auto-generated method stub
		int[] a = new int[set.size()];
		Iterator<Integer> iter = set.iterator();
		int idx = 0;
		while(iter.hasNext()){
			a[idx++] = iter.next();
		}
		return a;
	}
}