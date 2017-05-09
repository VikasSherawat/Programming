package stack;

import java.util.Iterator;

public class Stack<E extends Comparable<E>> implements Iterable<E> {

	private class Node {
		E item;
		Node next;
	}

	private Node top = null;

	public Iterator<E> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<E> {

		private Node current = top;

		public boolean hasNext() {
			return current != null;
		}

		public E next() {
			E value = current.item;
			current = current.next;
			return value;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}

	public boolean isEmpty() {
		return top == null;
	}

	public void push(E item) {
		if (isEmpty()) {
			top = new Node();
			top.item = item;
		} else {
			Node secondLast = top;
			top = new Node();
			top.item = item;
			top.next = secondLast;
		}
	}

	public E pop() {
		E value = null;
		if (!isEmpty()) {
			value = top.item;
			top = top.next;
		}
		return value;
	}

	public int size() {
		int size = 0;
		Node curr = top;
		while (curr != null) {
			size++;
			curr = curr.next;
		}
		return size;
	}

	public E getMax() {
		E max = null;
		if (!isEmpty()) {
			Iterator<E> iterator = iterator();
			while (iterator.hasNext()) {
				E val = iterator.next();
				if (max == null) {
					max = val;
				} else {
					if (max.compareTo(val) < 0)
						max = val;
				}
			}
		}
		return max;
	}
}
