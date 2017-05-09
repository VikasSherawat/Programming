package linkedList;

public class AddTwoNumbers {

	public static void main(String[] args) {
		Node a = null, b = null;
		String num = "101"; // 1111 + 229
		a = createList(num);
		num = "993";
		b = createList(num);
		Node ans = addList(a, b);
		printList(ans);
	}

	private static void printList(Node head) {
		// TODO Auto-generated method stub
		Node node = head;
		StringBuilder sb = new StringBuilder();
		while (node != null) {
			sb.append(node.data);
			node = node.next;
		}
		System.out.println(sb.reverse().toString());
	}

	private static Node addList(Node a, Node b) {
		// TODO Auto-generated method stub
		Node res = null;
		AddTwoNumbers add = new AddTwoNumbers();
		int carry = 0;
		while (true) {
			int sum = 0;
			if (a != null && b != null) {
				sum = a.data + b.data;
			} else if (a == null && b != null) {
				sum = carry + b.data;
			} else if (a != null && b == null) {
				sum = carry + a.data;
			} else {
				break;
			}
			sum += carry;
			int rem = sum % 10;
			carry = sum / 10;
			res = add.insert(res, rem);
			if (a != null)
				a = a.next;
			if (b != null)
				b = b.next;
		}
		if (carry != 0)
			res = add.insert(res, carry);

		return res;
	}

	private static Node createList(String num) {
		// TODO Auto-generated method stub
		String s = num;
		AddTwoNumbers add = new AddTwoNumbers();
		Node head = null;
		for (int i = 0; i < s.length(); i++) {
			head = add.insert(head, s.charAt(i) - '0');
		}
		return head;
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
