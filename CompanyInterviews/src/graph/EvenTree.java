package graph;

import java.util.*;
public class EvenTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(), M = in.nextInt();
		Map<Integer,List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		int a = in.nextInt();
		int b = in.nextInt();
		int root = b;
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(a);
		map.put(b, list1);
		for (int i = 0; i < M-1; i++) {
			 a = in.nextInt();
			 b = in.nextInt();
			 if(map.containsKey(a)){
				 List<Integer> list = map.get(a);
				 list.add(b);
				 map.put(a, list);
			 }else{
				 if(map.containsKey(b)){
				 List<Integer> list = map.get(b);
				 list.add(a);
				 map.put(b, list);
				 }else{
					 List<Integer> list = new ArrayList<Integer>();
					 list.add(a);
					 map.put(b, list);
				 }
			 }
			
		}
		int[] arr = new int[N+1];
		Arrays.fill(arr, -1);
		arr[root]=getChildren(arr,map,root);
		List<Integer> list = map.get(root);
		int count=0;
		for(Integer i: arr){
			if(i%2!=0){
				count++;
			}
		}
		System.out.println(count-2);
	}

	private static int getChildren(int[] arr, Map<Integer, List<Integer>> map,
			int root) {
		// TODO Auto-generated method stub
		if(!map.containsKey(root))
			return  0;
		if(arr[root]!=-1)
			return arr[root];
		else{
			List<Integer> list = map.get(root);
			arr[root]=0;
			for(Integer i: list){
				arr[i]=getChildren(arr, map, i);
				arr[root]+=arr[i];
			}
			arr[root]+=list.size();
		} 
		return arr[root];
	}


	

}
