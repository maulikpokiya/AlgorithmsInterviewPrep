import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

	LinkedListNode<T> head;

	public LinkedList() {
		head = null;
	}

	public LinkedList(LinkedListNode<T> head) {
		this.head = head;
	}

	public LinkedListNode<T> searchNode(T val) {

		LinkedListNode<T> temp = head;
		while (temp != null && temp.data != val) {
			temp = temp.next;
		}
		return temp;
	}

	public LinkedListNode<T> addFirst(T val) {

		head = new LinkedListNode<T>(val, head);
		return head;
	}

	public void traverse() {
		LinkedListNode<T> temp = head;
		while (temp != null)
			temp = temp.next;
	}

	public LinkedListNode<T> addLast(T val) {
		LinkedListNode<T> temp = head;

		if (temp == null)
			addFirst(val);
		else {
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new LinkedListNode<T>(val);
		}
		return temp;
	}

	public LinkedListNode<T> insertAfter(T key, T val) {
		LinkedListNode<T> temp = head;
		if (temp == null)
			System.out.println("Key not found");
		else {
			while (temp != null && temp.data != key)
				temp = temp.next;
			if (temp == null)
				System.out.println("Key not found");
			else
				temp.next = new LinkedListNode<T>(val, temp.next);
		}
		return temp.next;
	}

	public LinkedListNode<T> insertBefore(T key, T val) {
		LinkedListNode<T> temp = head;
		LinkedListNode<T> prev = null;

		if (temp == null) {
			throw new IndexOutOfBoundsException();
		} else {
			while (temp != null && temp.data != key) {
				prev = temp;
				temp = temp.next;
			}
			if (temp == null)
				throw new IndexOutOfBoundsException();
			else if (prev == null)
				prev = addFirst(val);
			else
				prev.next = new LinkedListNode<T>(val, temp);
		}
		return prev.next;
	}

	public LinkedListNode<T> remove(T val) {

		LinkedListNode<T> temp = head;
		LinkedListNode<T> del = null;

		if (temp != null && temp.data == val) {
			head = temp.next;
			temp.next = null;
			return temp;
		}

		while (temp.next != null && temp.next.data != val) {
			temp = temp.next;
		}

		if (temp.next.data == val) {
			del = temp.next;
			temp.next = del.next;
			del.next = null;
		}

		return del;
	}

	public void printList() {

		LinkedListNode<T> temp = head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.print("\n");
	}
	
	public void reverseList() {
  		LinkedListNode<T> temp = head;
    		LinkedListNode<T> prev = null;
    
    		prev = reverse(temp);
    		prev.next = null;
  	}
  
  	// In-Place reverse Linked List
  	public LinkedListNode<T> reverse(LinkedListNode<T> node) {
	
		if(node.next != null) {
			reverse(node.next).next = node;
		} else {
			head = node;
		}
		return node;
	}

	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<T> {

		private LinkedListNode<T> nextNode;

		public LinkedListIterator() {
			nextNode = head;
		}

		@Override
		public boolean hasNext() {
			if (nextNode != null)
				return true;
			return false;
		}

		@Override
		public T next() {
			if (hasNext()) {
				T res = nextNode.data;
				nextNode = nextNode.next;
				return res;
			}
			return null;
		}

		@Override
		public void remove() {

		}
	}

	private class LinkedListNode<E> {
		E data;
		LinkedListNode<E> next;

		public LinkedListNode(E val) {
			this(val, null);
		}

		public LinkedListNode(E val, LinkedListNode<E> nextNode) {
			this.data = val;
			this.next = nextNode;
		}
	}
}
