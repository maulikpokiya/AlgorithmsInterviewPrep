public class Node<T> {

	T data;
	Node<T> next;
	
	public Node(T val) {
		this(val, null);
	}
	
	public Node(T val, Node<T> next) {
		this.data = val;
		this.next = next;
	}
}