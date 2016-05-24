import java.util.LinkedList;

public class BinaryTree<T> {

	BinaryTreeNode<T> root;

	public BinaryTree() {
		root = null;
	}

	public void insert(T val) {

		LinkedList<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
		BinaryTreeNode<T> temp = null;

		if (root != null)
			queue.add(root);
		else
			root = new BinaryTreeNode<T>(val);

		while (!queue.isEmpty()) {
			temp = queue.poll();

			if (temp.left != null && temp.right != null) {
				queue.add(temp.left);
				queue.add(temp.right);
				continue;
			} else if (temp.left != null) {
				temp.right = new BinaryTreeNode<T>(val);
			} else {
				temp.left = new BinaryTreeNode<T>(val);
			}
			queue.clear();
		}
	}

	public T searchBFS(T val) {

		LinkedList<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
		BinaryTreeNode<T> temp = null;

		if (root != null)
			queue.add(root);

		while (!queue.isEmpty()) {
			temp = queue.poll();
			if (temp.data == val)
				break;
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}

		if (temp.data != val)
			return null;
		else
			return temp.data;
	}

	public void traverse(String order) {

		switch (order) {
		case "preorder":
			preOrder(root);
			break;

		case "postorder":
			postOrder(root);
			break;

		case "inorder":
			inOrder(root);
			break;

		default:
			System.out.println("Invalid entry");
			break;
		}
	}

	public void preOrder(BinaryTreeNode<T> node) {

		if (node != null) {

			System.out.println(node.data);

			if (node.left != null)
				preOrder(node.left);

			if (node.right != null)
				preOrder(node.right);
		}
	}

	/*
	 * public void preOrder() {
	 * 
	 * LinkedList<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>(); 
	 * BinaryTreeNode<T> temp = null;
	 * 
	 * if(root != null) 
	 * queue.add(root);
	 * 
	 * while(!queue.isEmpty()) {
	 * 
	 * temp=queue.poll();
	 * 
	 * System.out.println(temp.data);
	 * 
	 * if(temp.right!=null) 
	 * queue.addFirst(temp.right); 
	 * if(temp.left!=null)
	 * queue.addFirst(temp.left);
	 * 
	 * } }
	 */

	public void postOrder(BinaryTreeNode<T> node) {

		if (node != null) {
			if (node.left != null)
				postOrder(node.left);

			if (node.right != null)
				postOrder(node.right);

			System.out.println(node.data);
		}

	}

	public void inOrder(BinaryTreeNode<T> node) {

		if (node != null) {
			if (node.left != null)
				inOrder(node.left);

			System.out.println(node.data);

			if (node.right != null)
				inOrder(node.right);
		}
	}

	private class BinaryTreeNode<E> {

		E data;
		BinaryTreeNode<E> left;
		BinaryTreeNode<E> right;

		public BinaryTreeNode(E val) {
			this.data = val;
			left = null;
			right = null;
		}
	}
}
