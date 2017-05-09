package main;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinHeap {
	List<Long> list;

	public MinHeap() {
		list = new ArrayList<Long>();
	}

	public void add(long ele) {
		list.add(ele);
		min_heapify(list.size() - 1);
	}

	private void min_heapify(int size) {
		// TODO Auto-generated method stub
		if (size == 0)
			return;
		int parent = (size - 1) / 2;
		while (parent >= 0 && list.get(parent) > list.get(size)) {
			Collections.swap(list, parent, size);
			size = parent;
			parent = (parent - 1) / 2;
		}
	}

	public static void main(String[] args) {


		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int K = in.nextInt();
		//MinHeap heap = new MinHeap();
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		while (T-- > 0) {
			long ele = in.nextInt();
			pq.add(ele);
		}
		long ans = 0l;
		boolean flag = false;
		int size = pq.size();

		while(pq.size()>0){
			Long min = pq.poll();
			Long smin = pq.poll();
			if(min==null || smin ==null)
				break;
			long sum = min + 2*smin;
			if(min>=K){
				flag = true;
				break;
			}else{
				pq.add(sum);
			}
			ans++;
				
		}
		System.out.println(flag?ans:-1);

	}

	private void printHeap() {
		// TODO Auto-generated method stub
		for (Long l : list)
			System.out.print(l + " ");
		System.out.println();
	}

	public boolean deleteKey(long key) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == key) {
				list.remove(i);
				maintainMinHeap(list, i);
				return true;
			}
		}
		return false;
	}

	private Long[] heapSort() {
		// TODO Auto-generated method stub
		Long[] arr = new Long[list.size()];
		List<Long> dup = new ArrayList<Long>(list);
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			arr[index++] = removeMin(dup);
			maintainMinHeap(dup, 0);
		}
		return arr;
	}

	private void maintainMinHeap(List<Long> list, int start) {
		// TODO Auto-generated method stub
		for (int i = start; 2 * i + 1 < list.size(); i++) {
			long left = list.get(2 * i + 1);
			int rIndex = 2 * i + 2;
			int minIndex = 2 * i + 1;
			if (rIndex < list.size() && left > list.get(rIndex)) {
				minIndex = rIndex;
			}
			if (list.get(i) > list.get(minIndex)) {
				Collections.swap(list, i, minIndex);
			}
		}
	}
	
	public long removeMin(){
		long ans = list.size() > 0 ? list.remove(0) : -1l;
		if(ans!=-1)
			maintainMinHeap(list, 0);
		return ans;
	}
	
	private Long removeMin(List<Long> dup) {
		// TODO Auto-generated method stub
		return dup.size() > 0 ? dup.remove(0) : -1l;
	}

	private List<Long> getHeap() {
		// TODO Auto-generated method stub
		return list;
	}
}
