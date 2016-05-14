import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

	Node<T> head;

	public LinkedList() {
		head = null;
	}

	public LinkedList(Node<T> head) {
		this.head = head;
	}

	public Node<T> searchNode(T val) {

		Node<T> temp = head;
		while (temp != null && temp.data != val) {
			temp = temp.next;
		}
		return temp;
	}

	public Node<T> addFirst(T val) {

		head = new Node<T>(val, head);
		return head;
	}

	public void traverse() {
		Node<T> temp = head;
		while (temp != null)
			temp = temp.next;
	}

	public Node<T> addLast(T val) {
		Node<T> temp = head;

		if (temp == null)
			addFirst(val);
		else {
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node<T>(val);
		}
		return temp;
	}

	public Node<T> insertAfter(T key, T val) {
		Node<T> temp = head;
		if (temp == null)
			System.out.println("Key not found");
		else {
			while (temp != null && temp.data != key)
				temp = temp.next;
			if (temp == null)
				System.out.println("Key not found");
			else
				temp.next = new Node<T>(val, temp.next);
		}
		return temp.next;
	}

	public Node<T> insertBefore(T key, T val) {
		Node<T> temp = head;
		Node<T> prev = null;

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
				prev.next = new Node<T>(val, temp);
		}
		return prev.next;
	}

	public Node<T> remove(T val) {

		Node<T> temp = head;
		Node<T> del = null;

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

		Node<T> temp = head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.print("\n");
	}

	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<T> {

		private Node<T> nextNode;

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
}