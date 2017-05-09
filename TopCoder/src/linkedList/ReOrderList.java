package linkedList;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//[1,2,3,4,5,6] to [1,6,2,5,3,4]
public class ReOrderList {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4};
		Node head = null;
		ReOrderList ls = new ReOrderList();
		for (int i = 0; i < a.length; i++) {
			head = ls.insert(head, a[i]);
		}

		Node mid = findMid(head);
		mid = reverseList(mid);

		while (mid != null) {
			System.out.print(head.data + "" + mid.data);
			head = head.next;
			mid = mid.next;
		}
	}

	private static Node reverseList(Node mid) {
		// TODO Auto-generated method stub
		Stack<Node> st = new Stack<>();
		while (mid.next != null) {
			st.push(mid);
			mid = mid.next;
		}

		Node temp = mid;
		while (!st.isEmpty()) {
			Node top = st.pop();
			temp.next = top;
			top.next = null;
			temp = top;
		}
		return mid;
	}

	private static Node findMid(Node head) {
		// TODO Auto-generated method stub
		Node node = head, mid = head;
		while (node != null) {
			mid = mid.next;
			node = node.next;
			if (node != null)
				node = node.next;
		}
		return mid;
	}

	private class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

	}

	public Node insert(Node head, int data) {
		if (head == null) {
			return new Node(data, null);
		} else {
			Node prev = head;
			while (prev != null && prev.next != null) {
				prev = prev.next;
			}
			Node node = new Node(data, null);
			prev.next = node;
			return head;
		}
	}
}
