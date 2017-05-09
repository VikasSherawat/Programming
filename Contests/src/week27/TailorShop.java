package week27;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TailorShop {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int p = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		// your code goes here
		Arrays.sort(a);
		int ans = 0;
		Set<Integer> set = new HashSet<Integer>();
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			int btn = 0;
			if(a[i]%p==0){
				btn = a[i]/p;
			}else{
				btn = a[i]/p + 1;
			}
			int div = btn;
			if(map.containsKey(div)){
				ans += map.get(div);
				set.add(map.get(div));
				map.put(btn, map.get(div)+1);
			}else{
				while(set.contains(btn)){
					++btn;
				}
				ans += btn;
				set.add(btn);
				map.put(div, btn+1);
			}
			
		}
		
		System.out.println(ans);
	}
}
