package graph;

import  java.util.*;

public class JourneyMoon {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int L = in.nextInt();
		Map<Integer,List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		int a = in.nextInt(), b = in.nextInt();
		int root =a;
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(b);
		map.put(a, list1);
		List<Integer> list2= new ArrayList<Integer>();
		list2.add(a);
		map.put(b, list2);
		L--;
		while(L-->0){
			a = in.nextInt();
			b = in.nextInt();
			if(map.containsKey(a)){
				List<Integer> list = map.get(a);
				list.add(b);
			}else{
				List<Integer> list = new ArrayList<Integer>();
				list.add(b);
				map.put(a, list);
			}
			if(map.containsKey(b)){
				List<Integer> list = map.get(b);
				list.add(a);
			}else{
				List<Integer> list = new ArrayList<Integer>();
				list.add(a);
				map.put(b, list);
			}
		}
		solve(map,N,root);
		in.close();
		
	}

	private static void solve(Map<Integer, List<Integer>> map, int n,int root) {
		// TODO Auto-generated method stub
		List<Long> countrySize = new ArrayList<Long>();
		int[] check = new int[n];
		Arrays.fill(check, -1);
		long  count=1l;
		long sum=0l;
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(root);
		while(q.size()>0){
			root = q.remove();
			check[root]=1;
			List<Integer> list = map.get(root);
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Integer i = (Integer) iterator.next();
				if(check[i]==-1){
					check[i]=1;
					count++;
					q.add(i);
				}
			}
			map.remove(root);
			if(q.size()==0 && map.size()>0){
				sum+=count;
				countrySize.add(count);
				count=1;
				Set<Integer> set = map.keySet();
				Iterator<Integer> iter = set.iterator();
				q.add(iter.next());
			}
		}
		sum+=count;
		countrySize.add(count);
		
		long soleCountry = n-sum;
		long result = 0l;
		result = sum*soleCountry;
		if(soleCountry>2)
			result+=soleCountry*(soleCountry-1)/2;
		for(int i = 0;i<countrySize.size();i++){
			for(int j = i+1;j<countrySize.size();j++){
				result+=countrySize.get(i)*countrySize.get(j);
			}
		}
		
		System.out.println(result);
	}

}
