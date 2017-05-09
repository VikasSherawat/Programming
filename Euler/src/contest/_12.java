package contest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class _12 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//HashSet<Long> set = getTriangularNumber(10000);
		//List<Integer> list = getPrimes(1000);
		TreeMap<Long,Long> map = getTriangularNumber(1000);
		
		int T = in.nextInt();
		int[] a = {0,3,6,6,28};
		while (T-- > 0) {
			int N = in.nextInt();
			if(N<5){
				System.out.println(a[N]);
				continue;
			}
			for (Map.Entry<Long, Long> m : map.entrySet())
			{
				long key = m.getKey();
				if(key>N){
					System.out.println(m.getValue());
					break;
				}
			}
		}

	}



	private static TreeMap<Long, Long> getTriangularNumber(int x) {
		// TODO Auto-generated method stub
		TreeMap<Long, Long> map = new TreeMap<Long, Long>();
		for (int i = 1; i<=x; i++) {
			long k = (i * (i + 1)) / 2;
			for (int j = 1; j*j <k ; j++) {
				
			}
		}
		return map;
	}
	
}
