package string;

import java.util.*;
public class GameOfThrones {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String inp = in.next();
	Map<Character,Integer> map = new TreeMap<Character, Integer>();
	for (int i = 0; i < inp.length(); i++) {
		char key = inp.charAt(i);
		if(map.containsKey(key)){
			map.put(key, map.get(key)+1);
		}else{
			map.put(key, 1);
		}
	}
	int count=0;
	boolean flag = false;
	for(Map.Entry<Character, Integer> m1: map.entrySet()){
		if(m1.getValue()%2==1)
			count++;
		if(count>1){
		flag = true;
			break;
		}
	}
	if(!flag)
		System.out.println("YES");
	else
		System.out.println("NO");
	in.close();
}
}
