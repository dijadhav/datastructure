package ds.queue;

/**
 * Implementation of blocking queue.
 * 
 * @author dijadhav
 *
 */
public class BlockingQueue {
	private Node head;
	private Node tail;
	private Object lock = new Object();
	private int max;
	private int count = 0;
	public BlockingQueue(int max) {
		this.max = max;
	}

	public void enqueue(Runnable task) {
		synchronized (lock) {
			while (count >= max) {
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
			if (null == head) {
				head = new Node(task);
				tail = head;
			} else {
				tail.next = new Node(task);
				tail = tail.next;
			}
			count++;
		}
		notifyAll();
	}

	public Runnable dequeue() {
		Runnable task = null;
		synchronized (lock) {
			while (count == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
			notify();
			if (null != head) {
				task = head.task;
				head = head.next;
				count--;
			}
			if (null == head) {
				tail = null;
			}
		}
		notifyAll();
		return task;
	}

	public boolean isEmpty() {
		return count == 0;
	}
}

class Node {
	Runnable task;
	Node next;

	public Node(Runnable task) {
		this.task = task;
	}
}
