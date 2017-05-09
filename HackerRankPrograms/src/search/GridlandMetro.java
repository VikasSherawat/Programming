package search;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GridlandMetro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();
		Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		for (int i = 0; i < K; i++) {
			int row = in.nextInt();
			int start = in.nextInt();
			int end = in.nextInt();
			List<Integer> list = null;
			if (map.containsKey(row)) {
				list = map.get(row);
				list.add(start);
				list.add(end);
			} else {
				list = new ArrayList<Integer>();
				list.add(start);
				list.add(end);
				map.put(row, list);
			}
		}
		long count =0l;
		
		for (Map.Entry<Integer, List<Integer>> m : map.entrySet()) {
			int row = m.getKey();
			List<Integer> list = m.getValue();
			GridlandMetro gm = new GridlandMetro();
			for (int i = 0; i < list.size(); i+=2) {
				long start = list.get(i);
				long end = list.get(i+1);
				count += gm.insert(start, end);
			}
		}
		System.out.println(count);
	}

	private class Node {
		Node next;
		long start;
		long end;

		public Node(Node next, long start, long end) {
			this.next = next;
			this.start = start;
			this.end = end;
		}
	}

	private Node head;
	private Node tail;

	public long insert(long start, long end) {
		if (head == null) {
			head = tail = new Node(null, start, end);
			return end - start;
		} else {

			long count = 0l;
			if (end < head.start) {
				Node child = new Node(head, start, end);
				head = child;
				return end - start;
			}

			if (start > tail.end) {
				Node child = new Node(null, start, end);
				tail.next = child;
				tail = child;
				return end-start;
			}
			Node node = head;
			while (node != null) {
				if (start >= node.start && start <= node.end) {
					if (end <= node.end)
						return 0;
					else {
						Node nextNode = node.next;
						if (nextNode == null || end <= nextNode.start) {
							count = end - node.end;
							node.end = end;
							return count;
						}else{
							
							if(end>tail.end){ // if ends is greater than the tail
								count = end-tail.end;
								node.end = end;
								node.next = null;
								tail = node;
								return count;
							}
							
							Node nodeStart = node;
							Node prev = null;
							while(!(end>=node.start && end <=node.end)){
								nodeStart.next = node.next;
								
								node = node.next;
							}
							nodeStart.next = node.next;
							count = node.start-nodeStart.end;
							nodeStart.end = node.end;
							return count;
						}
					}
				} else if (start > node.end && node.next != null
						&& end < node.next.start) { // lies in between two nodes
					Node child = new Node(node.next,start,end);
					node.next = child;
					return end-start;	

				} else {
					node = node.next;
				}
			}

			return count;
		}
	}
}
