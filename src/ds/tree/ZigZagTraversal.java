package ds.tree;

public class ZigZagTraversal {
	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}

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
