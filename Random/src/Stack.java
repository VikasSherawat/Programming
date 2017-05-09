
public class Stack {
	private class Node {
		Node next;
		int val;

		public Node(Node next, int val) {
			super();
			this.next = next;
			this.val = val;
		}

	}

	private Node top;

	public void push(int val) {
		if (this.top == null) {
			this.top = new Node(null, val);
			return;
		}

		Node node = new Node(this.top, val);
		this.top = node;
	}
	
	public boolean isEmpty(){
		return this.top == null;
	}
	public boolean find(int val){
		boolean p = false;
		Node temp = this.top;
		while(temp!=null){
			if(temp.val == val)
				return true;
			temp = temp.next;
		}
		return p;
	}
	public Integer pop() {
		if (this.top == null)
			return null;

		int ans = this.top.val;
		if(this.top.next==null)
			this.top = null;
		else
			this.top = this.top.next;
		
		return ans;
	}
	
	public Integer peek() {
		if (this.top == null)
			return null;

		return this.top.val;
	}

	public void printStack() {
		if (this.top == null)
			return;

		Node temp = this.top;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}

		System.out.println();
	}

	public int size() {
		if (this.top == null)
			return 0;
		Node temp = this.top;
		int ans = 0;
		while (temp != null) {
			ans++;
			temp = temp.next;
		}

		return ans;
	}
}
