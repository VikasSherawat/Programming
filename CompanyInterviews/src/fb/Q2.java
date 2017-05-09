package fb;

import java.util.*;
public class Q2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] arr  = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]=in.nextInt();
		}
		sort(arr);
	}

	private static void sort(int[] arr) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i])){
				map.put(arr[i], map.get(arr[i])+1);
			}else{
				map.put(arr[i], 1);
			}
		}
		Map<Integer,List<Integer>> frequency = new TreeMap<Integer, List<Integer>>();
		for(Map.Entry<Integer, Integer> m1: map.entrySet()){
			int key = m1.getKey();
			int val = m1.getValue();
			if(frequency.containsKey(val)){
				List<Integer> list = frequency.get(val);
				list.add(key);
			}else{
				List<Integer> list = new ArrayList<Integer>();
				list.add(key);
				frequency.put(val, list);
			}
		}
		for(Map.Entry<Integer, List<Integer>> m1: frequency.entrySet()){
			List<Integer> list = m1.getValue();
			Collections.sort(list);
			int key = m1.getKey();
			
			
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					Integer integer = (Integer) iterator.next();
					int count =1;
					while(count++<=key)
					{
					System.out.println(integer);
					}
				}
				
			
		}
		
	}

}
