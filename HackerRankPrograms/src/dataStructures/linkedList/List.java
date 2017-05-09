package dataStructures.linkedList;

public class List {

	private class Node {
		Node next;
		int val;

		Node(Node next, int val) {
			this.next = next;
			this.val = val;
		}

	}// class ends here

	private Node head;

	public Node insert(int val) {
		if (this.head == null) {
			this.head = new Node(null, val);
			return this.head; 
		}

		Node temp = this.head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node(null, val);
		return this.head;
	}

	public Node reverseList() {
		if (this.head == null)
			return null;

		Node temp = this.head, prev = null;
		while (temp.next != null) {
			Node nextNode = temp.next;
			if (prev == null) {
				temp.next = null;
				prev = temp;
			} else {
				temp.next = prev;
				prev = temp;
			}
			temp = nextNode;
		}
		temp.next = prev;
		return temp;
	}

	public static void main(String[] args) {
		int[] a = { 2, 4, 7, 5, 1, 9 };
		Node head = null;
		List ls = new List();
		for (int i = 0; i < a.length; i++) {
			head = ls.insert(a[i]);
		}
		printList(head);
		head = ls.reverseList();
		printList(head);
	}

	private static void printList(Node head) {
		// TODO Auto-generated method stub
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		System.out.println();
	}
}