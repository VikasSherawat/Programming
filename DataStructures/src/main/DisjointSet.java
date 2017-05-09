package main;


import java.io.*;
import java.util.*;

public class DisjointSet<T> {
	
	private Map<T, Node<T>> map = new HashMap<T, Node<T>>();
	
	private class Node<T>{
		Node<T> parent;
		int rank;
		T data;		
		int size;
		
	}
	
	public boolean union(T x, T y){
		Node<T> xNode = findSet(map.get(x));
		Node<T> yNode = findSet(map.get(y));
		
		if(xNode.parent == yNode.parent){
			return false;
		}
		
		if(xNode.rank >= yNode.rank){
			yNode.parent = xNode;
			xNode.size+=yNode.size;
			if(xNode.rank == yNode.rank)
				xNode.rank = xNode.rank + 1;
		}else{
			xNode.parent = yNode;
			yNode.size += xNode.size;
		}
		
		return true;
	} 
	
	public void makeSet(T data){
		Node<T> node = new Node<T>();
		node.data = data;
		node.parent = node;
		node.rank = 0;
		node.size =1;
		map.put(data, node);
	}
	
	public T findSet(T data){
		Node<T> node = map.get(data);
		if(node.parent == node)
			return node.data;
		else
		return findSet(node).data;
	}
	
	public int findSize(T data){
		Node<T> node = map.get(data);
		while(node.parent!=node){
			node = node.parent;
		}
		return node.size;
	}
	
	@SuppressWarnings("unchecked")
	private Node<T> findSet(Node<T> node){
		if(node.parent == node)
			return node;
		else
			return findSet(node.parent);
	}

	@Override
	public String toString() {
		return "DisjointSet []";
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		DisjointSet<Integer> set = new DisjointSet<Integer>();
		int N = in.nextInt();
		for (int i = 1; i <=N; i++) {
			set.makeSet(i);
		}
		int T = in.nextInt();
		while (T-- > 0) {
			String type = in.next();
			if(type.equalsIgnoreCase("Q")){
				int A = in.nextInt();
				System.out.println(set.findSize(A));
			}else{
				int A = in.nextInt();
				int B = in.nextInt();
				set.union(A, B);
			}
		}
	}
	
	
}
