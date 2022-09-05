package ds.tree;

import ds.tree.LevelOrderTraversal.Node;

public class Diameter {
	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	int getDiameter(Node root) {
		if (null == root)
			return 0;

		int ld = getDiameter(root.left);
		int rd = getDiameter(root.right);

		int lh = height(root.left);
		int rh = height(root.right);
		int diameter = lh + rh;

		diameter = Math.max(diameter, Math.max(ld, rd));
		return diameter;
	}

	int height(Node root) {
		if (null == root)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
}
