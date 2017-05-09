package heap;

import java.util.*;

public class MaxHeap {
	
	public static void main(String[] args) {
		List<Integer> list  = new ArrayList<Integer>();
		int[] arr = {31,15,21,5,10,12,18,3,2,9,35};
		for(int i=0;i<arr.length;i++){
			insertEle(arr[i],list);
			//heapify(list);
			if(i!=0)
				percolateUp(list, (i-1)/2);
		}
		System.out.println("Heap After Insertion:");
		for(Integer i: list){
			System.out.print(i+" ");
		}
		System.out.println();
		printElementGreaterThan(9,list,0);
	}

private static void printElementGreaterThan(int i, List<Integer> list,int index) {
		// TODO Auto-generated method stub
	int ele = list.get(index);
	if(ele>i){
		System.out.print(ele+" ");
	int child1 = 2*index+1;
	int child2 = 2*index+2;
	if(child1<list.size()&& list.get(child1)>i)
		printElementGreaterThan(i, list, child1);
	if(child2<list.size()&& list.get(child2)>i)
		printElementGreaterThan(i, list, child2);
	}
}

private static void heapSort(List<Integer> list) {
		// TODO Auto-generated method stub
	List<Integer> sList = new ArrayList<Integer>();
	while(list.size()>0){
		sList.add(deleteMaxFromHeap(list));
		percolateDown(list);
	}
	System.out.println("\nSorted List is: ");
	for(int i=sList.size()-1;i>=0;i--){
		System.out.print(sList.get(i)+" ");
	}
	}

private static Integer deleteMaxFromHeap(List<Integer> list) {
		// TODO Auto-generated method stub
		//int max = list.get(0);
		return list.remove(0);
	}

static void percolateUp(List<Integer> list, int parent){
	if(parent>(list.size()-1)/2)
		return;
	int lChild = 2*parent+1;
	int rChild = 2*parent+2;
	int max = lChild;
	if(rChild<list.size() && list.get(rChild)>list.get(lChild))
		max=rChild;
	if(list.get(parent)<list.get(max)){
		Collections.swap(list, parent, max);
		percolateUp(list, (parent-1)/2);
	}
		
}

	private static void percolateDown(List<Integer> list) {
		// TODO Auto-generated method stub
		int size=list.size();
		for(int parent=0;2*parent+1<size;parent++){
			int child1 = 2*parent+1,child2= 2*parent+2;
			int max=child1;
			if(child2<list.size() && list.get(child2)>list.get(child1))
				max = child2;
			if(list.get(parent)<list.get(max)){
				Collections.swap(list, parent, max);
				parent=(parent-1)/2-1;
				continue;
			}
		}
		
	}

	private static List<Integer> insertEle(int ele, List<Integer> list) {
		// TODO Auto-generated method stub
		if(list.size()==0)
			list.add(ele);
		else{
			list.add(ele);
		/*	int index = list.size()-1;
			int parent = (index-1)/2;
			if(list.get(parent)<list.get(index)){
				Collections.swap(list, parent, index);}*/
		}
		return list;
	}
}
