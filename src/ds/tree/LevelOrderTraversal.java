package ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	List<Integer> getLevelOrderTraversal(Node root) {
		List<Integer> list = new ArrayList<>();
		if (root != null) {
			Queue<Node> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				list.add(node.data);
				if (null != node.left) {
					queue.offer(node.left);
				}
				if (null != node.right) {
					queue.offer(node.right);
				}
			}
		}
		return list;
	}
}
