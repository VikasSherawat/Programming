package greedy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class LargestPermutation {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int temp,index=0;
		int maxSwap = in.nextInt();
		TreeMap<Integer, Integer> map = new TreeMap<Integer,Integer>();
		TreeMap<Integer, Integer> map1 = new TreeMap<Integer,Integer>();
		for (int i = 0; i < num; i++) {
			map.put(i, in.nextInt());
			//map1.put(i, map.get(i));
			
		}
		map1.putAll(map);
		
		if(maxSwap>=num)
		{
			for (int i = 0; i <num; i++) {
				map.put(i, num-i);
			}
		}
		else{
		for (int i = 0; i < num && maxSwap>0; i++) {
				temp = map.get(i);
				index = findIndex(num-i,map);
				if(index!=i){
					maxSwap--;
				map.put(i, num-i);
				map.put(index, temp);
				}
		}
		}
		
		for(Map.Entry<Integer,Integer> et: map.entrySet()){
			System.out.print(et.getValue()+" ");
		}
	}
	private static int findIndex(int i, TreeMap<Integer, Integer> map) {
		for(Map.Entry<Integer,Integer> et: map.entrySet()){
			if(et.getValue().equals(i))
				return et.getKey();
		}
		return 0;
	}

}
