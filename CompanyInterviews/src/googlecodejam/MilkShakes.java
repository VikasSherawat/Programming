package googlecodejam;

import java.io.*;
import java.math.*;
import java.util.*;

public class MilkShakes {
	static String input = "C:\\Users\\Vikas Kumar\\Downloads\\A-small-practice.in";
	static String output = "C:\\Users\\Vikas Kumar\\Downloads\\A-small-practice.txt";

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int[] list = null;
		Map<Integer, List<int[]>> map = new TreeMap<Integer, List<int[]>>();
		int C = in.nextInt();
		int count=1;
		while (C-- > 0) {
			int N = in.nextInt();
			int M = in.nextInt();
			int[][] cust = new int[M][];
			for (int i = 0; i < M; i++) {
				int T = in.nextInt();
				int[] temp = new int[2 * T];
				for (int j = 0; j < 2 * T; j++) {
					temp[j] = in.nextInt();
				}
				if (map.containsKey(T)) {
					List<int[]> ls = map.get(T);
					ls.add(temp);
				} else {
					List<int[]> ls = new ArrayList<int[]>();
					ls.add(temp);
					map.put(T, ls);
				}
				cust[i] = temp;
			}
			list = solve(cust, N, M, map);
			print(list,count++);
		}

	}

	private static int[] solve(int[][] cust, int N, int M,
			Map<Integer, List<int[]>> map) {
		// TODO Auto-generated method stub
		int[] packs = new int[N];
		Arrays.fill(packs, -1);

		for (Map.Entry<Integer, List<int[]>> m : map.entrySet()) {
			int len = m.getKey();
			List<int[]> list = m.getValue();
			for (int i = 0; i < list.size(); i++) {
				int[] temp = list.get(i);
				for (int j = 0; j < 2*len; j = j + 2) {
					int x = temp[j], y = temp[j + 1];
					if(len ==1){
						if (packs[x-1] == -1) {
							packs[x-1] = y;
						} else if (packs[x-1] == y) {
							continue;
						} else {
							return null;
						}
					}else{
						if (packs[x-1] == -1) {
							packs[x-1] = y;
						}else{
							if(j==len-1 && packs[x-1]!=-1){
								return null;
							}else{
								continue;
							}
						}
					}
				}
			}
		}
		return packs;
	}

	private static void print(int[] arr, int count) {
		// TODO Auto-generated method stub
			System.out.print("Case #"+count+": "+Arrays.toString(arr)
							.replaceAll("[\\[\\]]", "").replaceAll("-1", "0"));
			System.out.println();
	}

}
