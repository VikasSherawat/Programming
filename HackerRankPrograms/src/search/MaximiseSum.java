package search;

import java.math.BigInteger;
import java.util.*;

public class MaximiseSum {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
		 int T = in.nextInt();
		 List<Long> list = new ArrayList<Long>();
		 while(T-->0){
		 solve();
		 }
	}

	private static void solve() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		 int N = in.nextInt();
		 long prefix = 0l, max =0l;
		 long M = in.nextLong();
		 Set<Long> list = new HashSet<Long>();
		 list.add(0l);
		 for (int i = 1; i <= N; i++) {
			long num = in.nextLong();
			prefix = (prefix+num)%M;
			max = Math.max(prefix, max);
			Iterator<Long> iter = list.iterator();
			list.add(max);
		}
		
	}
}
