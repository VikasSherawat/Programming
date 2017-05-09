package string;

import java.util.*;


public class Anagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		while(T-->0){
			String inp = in.next();
			if(inp.length()%2==1){
				list.add(-1);
				continue;
			}
			String A = inp.substring(0,inp.length()/2);
			String B = inp.substring(inp.length()/2);
			Map<Character,Integer> mapA,mapB;
			mapA = noteChar(A);
			mapB = noteChar(B);
			int count=0;
			Set<Character> set = mapA.keySet();
			Iterator<Character> iter = set.iterator();
			while(iter.hasNext()){
				char key = iter.next();
				if(!mapB.containsKey(key)){
					count+=mapA.get(key);
				}else{
					if(mapA.get(key)>mapB.get(key)){
						count+=mapA.get(key)-mapB.get(key);
					}
				}
			}
			list.add(count);
				
		}
		
		for(Integer i: list){
			System.out.println(i);
		}
		
	}

	private static Map<Character, Integer> noteChar(String A) {
		// TODO Auto-generated method stub
		Map<Character,Integer> map = new TreeMap<Character, Integer>();
		for (int i = 0; i < A.length(); i++) {
			char key = A.charAt(i);
			if(map.containsKey(key)){
				map.put(key, map.get(key)+1);
			}else{
				map.put(key, 1);
			}
		}
		return map;
	}

}
