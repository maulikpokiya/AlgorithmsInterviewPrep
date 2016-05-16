import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Tree<T> {
	TreeNode<T> root;

	public Tree() {
		root = null;
	}

	public Tree(T val) {
		root = new TreeNode<T>(val);
	}

	public TreeNode<T> search(T val) {
		List<TreeNode<T>> list = new ArrayList<TreeNode<T>>();
		TreeNode<T> temp = null;

		if (root != null)
			list.add(root);

		while (list.size() > 0) {
			temp = list.get(0);

			if (temp.data == val)
				break;

			list.addAll(temp.children);
			list.remove(0);
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

	private class TreeNode<E> {
		E data;
		Collection<TreeNode<E>> children;

		public TreeNode(E val) {
			data = val;
			children = new ArrayList<TreeNode<E>>();
		}
	}
}
