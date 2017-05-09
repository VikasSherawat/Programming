package linkedlist;

public class SingleList<E> {
	@SuppressWarnings("hiding")
	private class SNode<E> {
		SNode<E> next;
		E data;
	}
	
	SNode<E> head;


	public void insert(E item) {
		if (head == null) {
			SNode<E> node = new SNode<E>();
			node.data = item;
			head = node;
		} else {
			SNode<E> curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			SNode<E> node = new SNode<E>();
			node.data = item;
			curr.next = node;
		}
	}

	public boolean remove(E item) {

		if (head == null)
			return false;

		if (head.data == item) {
			head = head.next;
			return true;
		}
		SNode<E> curr = head, prev = null;
		while (curr != null) {
			if (curr.data == item) {
				prev.next = curr.next;
				return true;
			}
			prev = curr;
			curr = curr.next;
		}
		return false;
	}
	
	public boolean removeAll(E item) {

		if (head == null)
			return false;
		
		boolean found = false;
		while(head!=null && head.data == item) {
			head = head.next;
			found = true;
		}
		SNode<E> curr = head, prev = null;
		while (curr!= null) {
			if (curr.data == item) {
				found = true;
				prev.next = curr.next;
			}
			prev = curr;
			curr = curr.next;
		}
		if(found)
			return true;
		else
			return false;
	}

	public boolean search(E item) {
		if(head==null)
			return false;
		SNode<E> curr = head;
		while (curr != null) {
			if (curr.data == item)
				return true;
			curr = curr.next;
		}
		return false;
	}
	public int size(){
		int count = 0;
		SNode<E> curr = head;
		while(curr!=null){
			count++;
			curr = curr.next;
		}
		return count;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public void printList(){
		SNode<E> curr = head;
		while(curr!=null){
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
		System.out.println();
	}

}
