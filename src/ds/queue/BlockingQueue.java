package ds.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implementation of blocking queue using ReentrantLock
 * 
 * @author dijadhav
 *
 */
public class BlockingQueue<E> {
	private Node<E> head;
	private Node<E> tail;
	private Lock lock = new ReentrantLock();
	private Condition notFull = lock.newCondition();
	private Condition notEmpty = lock.newCondition();
	private int max;
	private int count = 0;

	public BlockingQueue(int max) {
		this.max = max;
	}

	public void enqueue(Runnable task) {
		try {
			lock.lock();
			while (count >= max) {
				try {
					notEmpty.await();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
			if (null == head) {
				head = new Node<E>(task);
				tail = head;
			} else {
				tail.next = new Node<E>(task);
				tail = tail.next;
			}
			notFull.signalAll();
			count++;
		} finally {
			lock.unlock();
		}
	}

	public Runnable dequeue() {
		Runnable task = null;
		try {
			lock.lock();
			while (count == 0) {
				try {
					notFull.await();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
			if (null != head) {
				task = head.task;
				head = head.next;
				count--;
			}
			if (null == head) {
				tail = null;
			}
			notEmpty.signalAll();
		} finally {
			lock.unlock();
		}
		return task;
	}

	public boolean isEmpty() {
		return count == 0;
	}
}

class Node<E> {
	Runnable task;
	Node<E> next;

	public Node(Runnable task) {
		this.task = task;
	}
}
