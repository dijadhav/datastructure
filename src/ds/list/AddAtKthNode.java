package ds.list;

public class AddAtKthNode {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(4);
		ListNode l4 = new ListNode(7);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		ListNode head = addAtkthElement(l1, 2, l5);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	private static ListNode addAtkthElement(ListNode head, int k, ListNode newElement) {
		if (head == null || newElement == null)
			return head;
		int i = 1;
		ListNode current = head;
		ListNode prev = null;
		while (null != current.next && i < k) {
			prev = current;
			current = current.next;
			i++;
		}

		if (prev != null) {
			newElement.next = current;
			prev.next = newElement;
		} else {
			newElement.next = head;
			head = newElement;
		}

		return head;
	}
}
