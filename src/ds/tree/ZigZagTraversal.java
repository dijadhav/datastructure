package ds.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}

	}

	int[] zigzagLevelOrderTraversal(Node root) {
		int level = 0;
		if (root == null)
			return new int[0];
		List<Integer> list = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				if (null != node.left) {
					queue.offer(node.left);
				}
				if (null != node.right) {
					queue.offer(node.right);
				}

				if (level % 2 != 0) {
					temp.add(0, node.data);
				} else {
					temp.add(node.data);
				}
			}
			if (level % 2 == 0) {
				Collections.reverse(temp);
			}
			level++;
			list.addAll(temp);
		}
		int[] ans = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}
		return ans;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		Node n1l1 = new Node(2);
		Node n2l1 = new Node(3);
		root.left = n1l1;
		root.right = n2l1;

		Node n1l2 = new Node(4);
		Node n2l2 = new Node(5);
		n1l1.left = n1l2;
		n1l1.right = n2l2;

		Node n3l2 = new Node(6);
		Node n4l2 = new Node(7);
		n2l1.left = n3l2;
		n2l1.right = n4l2;

	}

}
