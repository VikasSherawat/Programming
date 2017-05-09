package bruteforce;

import java.util.*;

public class Quacking {
	public static void main(String[] args) {
		String s = "quaquackckquack";
		System.out.println(new Quacking().quack(s));
	}

	public int quack(String s) {
		int valid = isValid(s);
		if (valid == -1) {
			return -1;
		}
		
		StringBuilder sb  = new StringBuilder();
		String quack = "quack";
		for (int i = 0; i < s.length(); i++) {
			sb.append(quack.indexOf(s.substring(i, i+1)));
		}
		
		ArrayList<StringBuilder> list = new ArrayList<>();
		list.add(new StringBuilder(""));
		for (int i = 0; i < sb.length(); i++) {
			int n = Integer.valueOf(sb.substring(i, i+1));
			if(!insert2List(list,n))
				return -1;
		}

		return list.size();
	}

	private boolean insert2List(ArrayList<StringBuilder> list,int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i <list.size(); i++) {
			if(list.get(i).length()==n){
				if(n==4){
					list.get(i).delete(0, 4);
					return true;
				}
				list.get(i).append(n);
				return true;
			}
		}
		if(n!=0){
			return false;
		}
		list.add(new StringBuilder("0"));
		return true;
	}

	private int isValid(String s) {
		// TODO Auto-generated method stub
		if(s.indexOf("q")!=0){
			return -1;
		}
		Map<Character, Integer> map = new TreeMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
			if(c!='q' && map.get(c)>map.get('q')){
				return -1;	
			}
		}
		int n = -1;
		for (Map.Entry<Character, Integer> m : map.entrySet()) {
			if(n==-1){
				n = m.getValue();
			}else{
				if(n!=m.getValue()){
					return -1;
				}
			}
		}
		
		return n;
	}
}
