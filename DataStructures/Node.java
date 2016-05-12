public class Node {

	int data;
	Node next;
	
	public Node(int val) {
		this.data = val;
		this.next = null;
	}
	
	public Node(int val, Node next) {
		this.data = val;
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
