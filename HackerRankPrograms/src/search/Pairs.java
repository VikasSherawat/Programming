package search;

import java.util.*;

public class Pairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		long K = in.nextLong();
		long[] arr = new long[N];
		List<String> list = new ArrayList<String>();
		Map<Long,Integer> map = new TreeMap<Long, Integer>();
		for (int i = 0; i < N; i++) {
			map.put(in.nextLong(), 1);
		}
		findPair(map,K);
	}

	private static void findPair(Map<Long, Integer> map,long K) {
		// TODO Auto-generated method stub
		int len= map.size();
		int count=0;
		for(Map.Entry<Long, Integer> m1: map.entrySet()){
			if(map.containsKey(K+m1.getKey()))
				count++;
		}
		System.out.println(count);
	}

}
