package ds.bst;

/**
 * Convert the sorted array to bst. here we can use the binary search
 * 
 * @author dijadhav
 *
 */
public class SortedArrayToBST {
	static class BstNode {
		int data;
		BstNode left;
		BstNode right;

		BstNode(int data) {
			this.data = data;
		}
	}

	private static void inorder(BstNode node) {
		if (null != node) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 5, 7, 10, 23, 55, 100, 123 };
		BstNode root = constructBST(arr);
		inorder(root);
	}

	private static BstNode constructBST(int[] arr) {
		BstNode root = constructBST(arr, 0, arr.length - 1);
		return root;
	}

	private static BstNode constructBST(int[] arr, int l, int r) {
		if (l > r) {
			return null;
		}
		int mid = l + (r - l) / 2;
		BstNode root = new BstNode(arr[mid]);
		root.left = constructBST(arr, l, mid - 1);
		root.right = constructBST(arr, mid + 1, r);
		return root;
	}

}
