package hackertrail;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Most1k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T-->0){
			int n = in.nextInt();
			int k = in.nextInt();
			String s = in.next();
			solve(n,k,s);
		}
	}

	private static void solve(int n, int k, String s) {
		// TODO Auto-generated method stub
		Deque<Integer> dq = new LinkedList<Integer>();
		int maxCount = 0,count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c=='1'){
				dq.offerLast(i);
				if(dq.size()<=k){
					count++;
				}else{
					maxCount = Math.max(maxCount, count);
					int index = dq.pollFirst();
					count = i-index;
				}
			}else{
				count++;
			}
		}
		
		maxCount = Math.max(maxCount, count);
		System.out.println(maxCount);
	}

}
