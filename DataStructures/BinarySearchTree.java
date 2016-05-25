import java.lang.Integer;

public class BinarySearchTree {

	BSTNode root;

	public BinarySearchTree() {
		root = null;
	}

	public BinarySearchTree(Integer data) {
		root = new BSTNode(data);
	}

	public void insert(Integer val) {

		BSTNode temp = root;
		BSTNode prev = null;

		if (temp == null) {
			root = new BSTNode(val);
			System.out.println("root inserted " + val);
			return;
		}

		while (temp != null) {
			prev = temp;
			if (val < temp.data)
				temp = temp.left;
			else
				temp = temp.right;
		}

		if (val > prev.data) {
			prev.right = new BSTNode(val);
			System.out.println("prev " + prev.data + " right inserted " + val);
		} else {
			prev.left = new BSTNode(val);
			System.out.println("prev " + prev.data + " left inserted " + val);
		}
	}

	public int search(int val) {
		BSTNode temp = root;

		while (temp != null && temp.data != val) {

			if (val < temp.data)
				temp = temp.left;
			else
				temp = temp.right;
		}

		if (temp != null)
			return temp.data;
		else
			return 0;
	}

	public void traverse(String order) {

		switch (order) {

		case "preorder":
			preorder(root);
			break;

		case "inorder":
			inorder(root);
			break;

		case "postorder":
			postorder(root);
			break;

		default:
			System.out.println("Invalid order entered");
			break;
		}
	}

	private void preorder(BSTNode node) {

		if (node != null) {
			System.out.println(node.data);

			preorder(node.left);

			preorder(node.right);
		}
	}

	private void inorder(BSTNode node) {

		if (node != null) {
			inorder(node.left);

			System.out.println(node.data);

			inorder(node.right);
		}
	}

	private void postorder(BSTNode node) {

		if (node != null) {
			postorder(node.left);

			postorder(node.right);

			System.out.println(node.data);
		}
	}

	private class BSTNode { // implements Comparator<BSTNode<E>> {
		int data;
		BSTNode left;
		BSTNode right;

		public BSTNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		/*
		 * @Override public int compare(BSTNode<E> o1, BSTNode<E> o2) { 
		 * return 0; 
		 * }
		 */
	}
}
