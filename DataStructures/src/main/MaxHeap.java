package main;

import java.io.*;
import java.util.*;

public class MaxHeap {
	
	List<Integer> list;
	
	public MaxHeap(){
		list = new ArrayList<Integer>();
	}
	
	public void insert(int i){
		list.add(i);
		max_heapify(list.size()-1);
	}
	
	public int[] sort(){ 
		int[] sortedArray = new int[list.size()];
		int lastIndex = sortedArray.length-1;
		for (int i = 0; i < sortedArray.length; i++) {
			sortedArray[lastIndex--] = removeMax();
		}
		return sortedArray;
	}
	
	public int removeMax(){
		if(list.size()<1)
			return -1;
		
		int max = list.remove(0);
		/*list.set(0, list.get(list.size()-1));
		list.remove(list.size()-1);*/
		maintainMaxHeapProperty();
		return max;
	}
	
	public int findMax(){
		return list.get(0);
	}

	private void maintainMaxHeapProperty() {
		// TODO Auto-generated method stub
		for (int i = 0; 2*i+1 < list.size() ; i++) {
			int left = list.get(2*i+1);
			int rIndex = 2*i+2;
			int maxIndex = 2*i+1;
			if(rIndex<list.size() && left < list.get(rIndex)){
				maxIndex = rIndex;
			}
			if(list.get(i)< list.get(maxIndex)){
				Collections.swap(list, i, maxIndex);
			}
		}
	}

	private void max_heapify(int index) {
		// TODO Auto-generated method stub
		if(index==0)
			return;
		
		int pIndex = (index-1)/2;
		while(index>0 && list.get(pIndex)<list.get(index)){
			Collections.swap(list, pIndex, index);
			index = pIndex;
			pIndex = (pIndex-1)/2;
		}
	}
	
	public List<Integer> getHeap(){
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {31,15,21,5,10,12,18,3,2,9,35};
		MaxHeap heap = new MaxHeap();
		for (int i = 0; i < arr.length; i++) {
			heap.insert(arr[i]);
		}
		
		List<Integer> list = heap.getHeap();
		for(int i : list){
			System.out.print(i+" ");
		}
		System.out.println();
		
		int[] sArr = heap.sort();
		for(int i : sArr){
			System.out.print(i+" ");
		}
		System.out.println();
		
	}
	
}
