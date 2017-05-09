import java.util.Iterator;

public class MyQueue {

	private class Node{
		Node next;
		int val;
		
		public Node(Node next, int val) {
			super();
			this.next = next;
			this.val = val;
		}
		
	}
	
	private Node head;
	private Node tail;
	
	public void enque(int val){
		if(this.head==null){
			this.tail = this.head = new Node(null, val);
			return;
		}
		
		Node node = new Node(null, val);
		tail.next = node;
		tail = node;
	}
	
	public int deque(){
		if(this.head==null)
			return -1;
		
		int ans = this.head.val;
		if(this.head==this.tail)
			this.head = this.tail = null;
		else
			this.head = this.head.next;
		return ans;
	}
	
	public boolean isPresent(int val){
		if(this.head==null)
			return false;
		
		Node temp = this.head;
		while(temp!=null){
			if(temp.val==val)
				return true;
			temp = temp.next;
		}
		
		return false;
	}
	
	public int size(){
		if(this.head==null)
			return 0;
		
		int ans = 0;
		Node temp = this.head;
		while(temp!=null){
			ans++;
			temp = temp.next;
		}
		
		return ans;
	}
	
	public void printQueue(){
		if(this.head==null)
			return;
		
		Node temp = this.head;
		while(temp!=null){
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		
		System.out.println();
	}
	
	public void getHead(){
		if(this.head!=null)
		System.out.println(this.head.val);
	}
	
	public void getTail(){
		if(this.tail!=null)
		System.out.println(this.tail.val);
	}

	
	
	
	
}
