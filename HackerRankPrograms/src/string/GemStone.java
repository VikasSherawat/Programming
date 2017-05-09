package string;
import java.util.*;
public class GemStone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		ArrayList<String> str = new ArrayList<String>();
		ArrayList<char[]> str1 = new ArrayList<char[]>();
		for (int i = 0; i < T; i++) {
			str.add(in.next());
			char[] ch = str.get(i).toCharArray();
			ch = removeDuplicates(ch);
			str1.add(ch);
		}
		
		SortedMap<Character, Integer> map = new TreeMap<Character, Integer>();
		int count =0;
		while(count<T){
			for (int i = 0; i < str1.get(count).length; i++) {
				Character inp = str1.get(count)[i];
				if(map.containsKey(inp))
					map.put(inp, map.get(inp)+1);
				else
					map.put(inp, 1);
			}
		count++;
		}
		
		count=0;
		for(Map.Entry m1: map.entrySet()){
			int val = (Integer)m1.getValue();
			if(val==T)
				count++;
		}
		
		
		
		
		System.out.println(count);
	}

	private static char[] removeDuplicates(char[] ch) {
		// TODO Auto-generated method stub
		SortedMap<Character, Integer> map = new TreeMap<Character, Integer>();
		for (int i = 0; i < ch.length; i++) {
			if(!map.containsKey(ch[i]))
				map.put(ch[i], 1);
		}
		char[] ar = new char[map.size()];
		int count=0;
		for(Map.Entry m1: map.entrySet()){
			ar[count++]=(Character)m1.getKey();
		}
		return ar;
	}

}
