package weekofcode19;

import java.util.*;

public class FindPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T =in.nextInt();
		List<String> list=null;
		List<String> result = new ArrayList<String>();
		while(T-->0){
			long N = in.nextLong();
			long K = in.nextLong();
			list = findPermutation(N);
			Collections.sort(list);
			result.add(findMinimalDis(list,K));
		}
		for(String str: result){
			if(str.equalsIgnoreCase("-1")){
				System.out.println("-1");
				continue;
			}
			else{
			for(int i=0;i<str.length();i++){
				System.out.print(str.charAt(i)+" ");
			}
			System.out.println();
			}
		}
	}

	private static String findMinimalDis(List<String> list, long k) {
		// TODO Auto-generated method stub
		int minDis=-1;
		List<String> out = new ArrayList<String>();
		List<Integer> count = new ArrayList<Integer>();
		for(String str: list){
			int lMin;
			count.clear();
			for(int i=0;i<str.length()-1;i++){
				int a = (int)str.charAt(i);
				int b = (int)str.charAt(i+1);
				int temp=Math.abs(a-b);
				count.add(temp);
			}
			Collections.sort(count);
			lMin = count.get(0);
			if(lMin<minDis)
				continue;
			if(lMin>minDis){
				minDis=lMin;
				out.clear();
				out.add(str);
			}else{
				out.add(str);
			}
		}
		if(k-1>=out.size()){
			return "-1";
		}else{
			return out.get((int)k-1);
		}
	}

	private static List<String> findPermutation(long N) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		Map<Long, ArrayList<String>> map = new TreeMap<Long, ArrayList<String>>();
		if(N<=1){
			list.add("1");
			return list;
		}else{
			list.add("1");
			map.put(1L, list);
			for (Long i = 2L; i <= N; i++) {
				ArrayList<String> list1 = findPermutations(map.get(i-1),i);
				map.put(i, list1);
			}
		}
		return map.get(N);
	}

	private static ArrayList<String> findPermutations(
			ArrayList<String> arrayList, Long i2) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		for(String str: arrayList){
			String temp="";
			for (int i = 0; i <= str.length(); i++) {
				String left = str.substring(0, i);
				String right = str.substring(i);
				temp=left+i2+right;
				list.add(temp);
			}
		}
		return list;
	}

}
