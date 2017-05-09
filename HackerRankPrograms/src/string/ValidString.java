package string;

import java.util.*;

public class ValidString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String inp;
		inp=in.next();
		Map<Character,Integer> map = new TreeMap<Character, Integer>();
		for (int i = 0; i < inp.length(); i++) {
			char key = inp.charAt(i);
			if(map.containsKey(key)){
				map.put(key, map.get(key)+1);
			}else
				map.put(key, 1);
		}
		
/*		for (Map.Entry m1: map.entrySet()) {
			System.out.println("Key:"+m1.getKey()+" and  Value:"+m1.getValue());
		}
		*/
		Collection<Integer> col = map.values();
		int count=0,check=0,temp=0;
		for (Iterator iterator = col.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			if(temp++==0)
			{
				check=integer;
			}else
				if(check==integer)
					continue;
				else
					count++;
			if(count>=2)
			{
				break;
			}
			
		}
		
		if(count>=2)
		{
			System.out.println("NO");
		}
		else
			System.out.println("YES");

	}

}
