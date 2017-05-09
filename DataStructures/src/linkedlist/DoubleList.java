package linkedlist;
public class DoubleList<E> {
	
	
	@SuppressWarnings("hiding")
	private class Node<E> {
		Node<E> next;
		Node<E> prev;
		E data;
	}
	
	Node<E> head;
	Node<E> tail;
	
	public void insert(E item){
		if (head == null) {
			Node<E> node = new Node<E>();
			node.data = item;
			head = tail = node;
		} else{
			Node<E> node = new Node<E>();
			node.data = item;
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
	}
	
	public boolean remove(E item){
		if(head==null)
			return false;
		else{
			if(head.data == item){
				head = head.next;
				return true;
			}
			Node<E> curr = head, prev = null;
			while(curr!=null){
				if(curr.data == item){
					prev.next = curr.next;
					if(curr.next!=null)
						curr.next.prev = curr.prev;
					return true;
				}
				
				prev = curr;
				curr = curr.next;
			}
			return false;
		}
	}
	
	public boolean removeAll(E item){
		if(head==null)
			return false;
		else{
			boolean found = true;
			while(head!=null && head.data == item){
				head = head.next;
				found = true;
			}
			Node<E> curr = head, prev = null;
			while(curr!=null){
				if(curr.data == item){
					prev.next = curr.next;
					if(curr.next!=null)
						curr.next.prev = curr.prev;
					found = true;
				}
				
				prev = curr;
				curr = curr.next;
			}
			
			if(found)
				return true;
			else
				return false;
		}
	}
	
	public boolean search(E item){
		if(head==null)
			return false;
		else{
			Node<E> curr = head;
			while(curr!=null){
				if(curr.data==item)
					return true;
				curr = curr.next;
			}
		}
		return false;
	}
	
	public int size(){
		int count = 0;
		Node<E> curr = head;
		while(curr!=null){
			count++;
			curr = curr.next;
		}
		return count;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public void removeAll(){
		head = null;
		tail = null;
	}
	public void printList(){
		Node<E> curr = head;
		while(curr!=null){
			if(curr.next!=null)
				System.out.print(curr.data+"->");
			else
				System.out.println(curr.data);
			curr = curr.next;
		}
	}
}
