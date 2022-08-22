package ds.list;

public class SwapPairs {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode current = swapPairs(head);
		while (null != current) {
			System.out.print(current.val + " ");
			current = current.next;
		}
	}

	public static ListNode swapPairs(ListNode head) {
		if (null == head || null == head.next)
			return head;
		ListNode fast = head.next;
		ListNode slow = head;
		while (null != fast) {
			ListNode temp = fast.next;
			fast.next = slow;
			slow.next = temp;
			slow = temp;
			if (null != slow) {
				fast = slow.next;
			} else {
				fast = slow;
			}
		}
		return head;
	}
}
