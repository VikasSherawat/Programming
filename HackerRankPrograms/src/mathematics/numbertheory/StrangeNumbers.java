package mathematics.numbertheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StrangeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		Scanner in = new Scanner(System.in);
		Queue<Long> q = new LinkedList<Long>();
		for (long i = 5; i <=10 ; i++) {
			q.add(i);
		}
		SortedSet<Long> list = new TreeSet<Long>();
		for (long i = 1; i < 6; i++) {
			list.add(i);
		}
		long item = 0l;
		int count =0;
		while(!q.isEmpty()  && count++<=500000 ){
			item = q.poll();
			int len = len(item);
			if(len(item*len)==len){
				list.add(item*len);
				q.add(item*len);
			}
			++len;
			if(len(item*len)==len){
				list.add(item*len);
				q.add(item*len);
			}
			
			++len;
			if(len(item*len)==len){
				list.add(item*len);
				q.add(item*len);
			}
		}
		Long[] arr = list.toArray(new Long[list.size()]);
		int T = in.nextInt();
		while (T-- > 0) {
			long a =in.nextLong();
			long b = in.nextLong();
			int aindex = findIndex(arr,a,b);
			System.out.println(aindex);
		}
	}

	private static int findIndex(Long[] arr, long a, long b) {
		// TODO Auto-generated method stub
		int count=0;
		for (int i = 0; i < arr.length ; i++) {
			if(arr[i]>=a && arr[i]<=b){
				count++;
			}
			
			if(arr[i]>b)
				break;
		}
		return count;
	}


	private static int len(long l) {
		// TODO Auto-generated method stub
		int ans =0;
		while(l>0){
			ans++;
			l/=10;
		}
		return ans;
	}

	
}
