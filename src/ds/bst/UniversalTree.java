package ds.bst;

import java.util.LinkedList;
import java.util.Queue;

public class UniversalTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(2);
		TreeNode l2 = new TreeNode(5);
		TreeNode r2 = new TreeNode(2);
		root.left = l1;
		root.right = r1;
		l1.left = l2;
		l1.right = r2;
		System.out.println();
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
