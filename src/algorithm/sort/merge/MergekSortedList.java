package algorithm.sort.merge;

public class MergekSortedList {
	public static void main(String[] args) {
		ListNode[] lists = new ListNode[3];

		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);

		lists[0] = l1;
		lists[1] = l2;
		lists[2] = l3;
		ListNode head = merge(lists);
		while (null != head) {
			System.out.print(head.val + " ");
			head = head.next;
		}

	}

	private static ListNode merge(ListNode[] lists) {
		ListNode head = lists[0];
		for (int i = 1; i < lists.length; i++) {
			head = merge(head, lists[i]);
		}
		return head;
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

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}
}