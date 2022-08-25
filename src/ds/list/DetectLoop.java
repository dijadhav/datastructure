package ds.list;

public class DetectLoop {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(4);
		ListNode l2 = new ListNode(5);
		ListNode l3 = new ListNode(6);
		ListNode l4 = new ListNode(10);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l2;
		ListNode node = getStartingNodeOfLoop(l1);
		if (null != node) {
			System.out.println(node.val);
		}
	}

	static ListNode getStartingNodeOfLoop(ListNode list) {
		if (null == list || list.next == null)
			return null;
		ListNode fast = list;
		ListNode slow = list;
		while (null != slow && null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
				break;
		}
		if (slow != fast)
			return null;
		slow = list;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

}
