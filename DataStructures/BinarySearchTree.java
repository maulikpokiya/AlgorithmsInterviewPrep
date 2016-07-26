import java.lang.Integer;

public class BinarySearchTree {

	BSTNode root;

	public BinarySearchTree() {
		root = null;
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
			temp = val < temp.data ? temp.left : temp.right;
		}

		if (val < prev.data) {
			prev.left = new BSTNode(val);
			System.out.println("prev " + prev.data + " left inserted " + val);
		} else {
			prev.right = new BSTNode(val);
			System.out.println("prev " + prev.data + " right inserted " + val);
		}
	}

	public int search(int val) {
		BSTNode temp = root;

		while (temp != null && temp.data != val) {
			temp = val < temp.data ? temp.left : temp.right;
		}

		if (temp != null)
			return temp.data;
		else
			return 0;
	}

	private BSTNode delete(BSTNode node, int val) {

		BSTNode temp = null;
		if (val < node.data) {
			if(node.left != null)
				node.left = delete(node.left, val);
			else
				System.out.println( "Value does not exist" );
		} else if (val > node.data) {
			if(node.right != null)
				node.right = delete(node.right, val);
			else
				System.out.println( "Value does not exist" );
		} else if (node.data == val) { 
			
			// Special case where root needs to be removed will also be handeled by this part.
			if (node.right == null) {
				temp = node;
				node = node.left;
				temp = null;
			} else if (node.left == null)
				node = node.right;
			else {
				node = node.right;
				while (node.left != null)
					node = node.left;
			}
		}
		return node;
	}

	public void delete(int val) {
		/**
		 * if deleted node do not have right child, replace deleted node with left child of it.
		 * if deleted node do not have left child, replace deleted node with right child of it.
		 * else, replace deleted node with left most child of right sub-tree.
		 */

		root = delete(root, val);
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
		 * @Override 
		 * public int compare(BSTNode<E> o1, BSTNode<E> o2) { 
		 * return 0; 
		 * }
		 */
	}
}
