package ds.list;

public class MyLinkedList {
	class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}

		Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public MyLinkedList() {

	}

	public int get(int index) {
		if (index < 0 || index >= size)
			return -1;
		Node current = head;
		int cnt = 0;
		while (cnt < index) {
			current = current.next;
			cnt++;
		}
		return current.val;
	}

	public void addAtHead(int val) {
		if (null == head) {
			head = new Node(val, null);
			tail = head;
		} else {
			Node node = new Node(val);
			node.next = head;
			head = node;
		}
		size++;
	}

	public void addAtTail(int val) {
		if (size==0) {
			addAtHead(val);
			return;
		} else {
			Node node = new Node(val);
			tail.next = node;
			tail = node;
		}
		size++;
	}

	public void addAtIndex(int index, int val) {
		if (index < 0 || index > size)
			return;
		if (index == 0) {
			addAtHead(val);
			return;
		}
		if (index == size) {
			addAtTail(val);
			return;
		}

		Node current = head;
		int cnt = 0;
		Node prev=null;
		while (cnt <= index - 1) {
			prev=current;
			current = current.next;
			cnt++;
		}
		size++;
		Node node = new Node(val);
		node.next = current;
		prev.next=node;
	}

	public void deleteAtIndex(int index) {
		if (size == 0 || index < 0 || index >= size)
			return;
		if (index == 0) {
			head = head.next;
			size--;
			return;
		}

		if (index == size) {
			tail = tail.next;
			size--;
			return;
		}

		Node current = head;
		int cnt = 0;
		Node prev = null;
		while (cnt <= index - 1) {
			prev = current;
			current = current.next;
			cnt++;
		}
		if (prev != null) {
			size--;
			prev.next = current.next;
			current.next = null;
		}
	}

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addAtHead(1);
		list.addAtTail(3);
		list.addAtIndex(1, 2);
		System.out.println(list.get(1));
		list.deleteAtIndex(1);
		System.out.println(list.get(1));

	}
}
