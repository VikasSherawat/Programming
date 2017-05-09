package queue;

import java.util.Iterator;

public class Queue<E>  implements Iterable<E>{

	private class Node {
		E item;
		Node next;
	}

	private Node first = null;
	private Node last = null;

	public void enqueue(E item) {
		
		Node secondLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()){
			first = last;
		}else{
			secondLast.next = last;
		}

	}

	public boolean isEmpty() {
		return first == null;
	}

	public E dequeue() {
		E val = first.item;
		first = first.next;
		if(isEmpty())
			last = null;
		return val;
	}
	
	public int size(){
		int size = 0;
		Node curr = first;
		while(curr!=null){
			size++;
			curr = curr.next;
		}
		return size;
	}
	public Iterator<E> iterator(){
		return new QueueIterator<E>();
	}
	
	private class QueueIterator<E> implements Iterator<E>{
		
		private Node current = first;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=null;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			E val = (E) current.item;
			current = current.next;
			return val;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	

}
