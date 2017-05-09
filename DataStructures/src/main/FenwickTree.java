package main;

import java.io.*;
import java.util.*;

public class FenwickTree {

	public long getSum(int[] array, int index){
		long sum = 0l;
		while(index>0){
			sum += array[index];
			index = findParent(index);
		}
		return sum;
	}
	
	public long getRangeSum(int[] array, int a, int b){
		return getSum(array, b)-getSum(array, a);
	}
	
	public int[] createFenwickTree(int[] arr){
		int[] array = new int[arr.length+1];
		for (int i = 0; i < arr.length; i++) {
			update(array, arr[i], i+1);
		}
		return array;	
	}
	
	public void update(int[] array, int value, int index){
		while(index<array.length){
			array[index] += value; 
			index = findNext(index);
		}
	}
	
	
	private int findParent(int x){
		return x - (x & -x);
	}
	
	private int findNext(int  x){
		return x + (x & -x);
	}
}
