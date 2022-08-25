package ds.list;

public class RemoveLoop {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(4);
		ListNode l2 = new ListNode(5);
		ListNode l3 = new ListNode(6);
		ListNode l4 = new ListNode(10);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l2;
		removeLoop(l1);
		while (null != l1) {
			System.out.print(l1.val + " ");
			l1 = l1.next;
		}
	}

	static void removeLoop(ListNode list) {
		ListNode fast = list;
		ListNode slow = list;
		while (null != slow && null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				slow = list;
				if (slow.next != fast) {
					while (slow.next != fast.next) {
						slow = slow.next;
						fast = fast.next;
					}
					fast.next = null;
				} else {
					while (fast.next != slow) {
						fast = fast.next;
					}
					fast.next = null;
				}
			}
		}
	}

}
