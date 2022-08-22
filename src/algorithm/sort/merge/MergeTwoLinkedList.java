package algorithm.sort.merge;

public class MergeTwoLinkedList {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
	}

	private static ListNode merge(ListNode head1, ListNode head2) {
		if (null == head1)
			return head2;
		if (null == head2)
			return head1;
		ListNode current1 = head1;
		ListNode current2 = head2;
		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;
		while (current1 != null && current2 != null) {
			if (current1.val < current2.val) {
				prev.next = current1;
				current1 = current1.next;
			} else {
				prev.next = current2;
				current2 = current2.next;
			}
			prev = prev.next;
		}
		prev.next = current1 == null ? current2 : current1;
		return dummy.next;
	}

}
