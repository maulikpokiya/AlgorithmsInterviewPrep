import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Tree<T> {
	TreeNode<T> root;

	public Tree() {
		root = null;
	}

	public Tree(T val) {
		root = new TreeNode<T>(val);
	}

	public TreeNode<T> search(T val) {
		LinkedList<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
		TreeNode<T> temp = null;

		if (root != null)
			queue.add(root);

		while (queue.size() > 0) {
			temp = queue.poll();

			if (temp.data == val)
				break;

			queue.addAll(temp.children);
			queue.remove(0);
		}

		if (temp != null && temp.data == val)
			return temp;
		temp = null;
		return temp;
	}

	public TreeNode<T> insert(T parent, T val) {
		TreeNode<T> temp = null;
		TreeNode<T> newNode = null;

		temp = search(parent);
		if (temp != null) {
			newNode = new TreeNode<T>(val);
			temp.children.add(newNode);
		}
		return newNode;
	}
/*
	public void traverse() {
		TreeNode<T> temp = root;
		StringBuffer sb = new StringBuffer();
		
		if(temp!=null)
			sb.append(temp.data);
	}
*/
	private class TreeNode<E> {
		E data;
		Collection<TreeNode<E>> children;

		public TreeNode(E val) {
			data = val;
			children = new ArrayList<TreeNode<E>>();
		}
	}
}
