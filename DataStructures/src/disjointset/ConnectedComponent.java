package disjointset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class DisjointSet<T> {

	private Map<T, Node<T>> map = new HashMap<T, Node<T>>();
	int max = -1;
	int min = Integer.MAX_VALUE;

	public DisjointSet(int n) {
		super();
	}

	private class Node<T> {
		Node<T> parent;
		int rank;
		T data;
		int size;

	}

	public boolean union(T x, T y) {
		Node<T> xNode = findSet(map.get(x));
		Node<T> yNode = findSet(map.get(y));

		if (xNode.parent == yNode.parent) {
			return false;
		}

		if (xNode.rank >= yNode.rank) {
			yNode.parent = xNode;
			xNode.size += yNode.size;
			if (xNode.rank == yNode.rank)
				xNode.rank = xNode.rank + 1;
		} else {
			xNode.parent = yNode;
			//arr[(Integer) xNode.data] = (Integer) findSet(yNode).data;
			yNode.size += xNode.size;
		}

		return true;
	}

	public void makeSet(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		node.parent = node;
		node.rank = 0;
		node.size = 1;
		map.put(data, node);
	}

	public T findSet(T data) {
		Node<T> node = map.get(data);
		if (node.parent == node)
			return node.data;
		else
			return findSet(node).data;
	}

	@SuppressWarnings("unchecked")
	private Node<T> findSet(Node<T> node) {
		if (node.parent == node)
			return node;
		else
			return findSet(node.parent);
	}

	public int findSize(T data) {
		Node<T> node = map.get(data);
		while (node.parent != node) {
			node = node.parent;
		}
		return node.size;
	}

	@Override
	public String toString() {
		return "DisjointSet []";
	}

	public void findMinMax() {
		// TODO Auto-generated method stub
		
		for(Map.Entry<T, Node<T>> m: map.entrySet()){
			T key = m.getKey();
			int size = findSize(key);
			if(size==1)
				continue;
			max = Math.max(max, size);
			min = Math.min(min, size);
		}
		if(min==1)
			min = max;
		System.out.println(min+" "+max);
		
	}

}

public class ConnectedComponent {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		DisjointSet<Integer> set = new DisjointSet<Integer>(T);
		for (int i = 1; i <= 2 * T; i++) {
			set.makeSet(i);
		}
		while (T-- > 0) {
			int G = in.nextInt();
			int B = in.nextInt();
			set.union(G, B);
		}
		
		set.findMinMax();

	}
}
