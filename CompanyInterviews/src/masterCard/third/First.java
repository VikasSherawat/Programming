package masterCard.third;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class First {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int[] a = {1,1,1,5,5,5,10,10,7,8,2,13,12,6,9,2,13,8,7,1,14,14,4,11,11};
		int k = 18;
		int count = numberOfPairs(a, k);
		System.out.println(count);
		
	}
	
	static int numberOfPairs(int[] a, long k){
		Map<Long,Long> map = new HashMap<Long, Long>();
		
		for (int i = 0; i < a.length; i++) {
			long item = a[i];
			if(map.containsKey(item)){
				map.put(item, map.get(item)+1);
			}else{
				map.put(item, 1l);
			}
		}
		int count = 0;
		for(Map.Entry<Long,Long> m: map.entrySet()){
			long key = m.getKey();
			long value = m.getValue();
			long search = k-key;
			if(search<key){
				continue;
			}else{
				if(key==search){
					if(map.get(key)>1){
						count++;
					}
				}else if(map.containsKey(search))
					count++;
			}
			
			
		}
		return count;
	}

}
