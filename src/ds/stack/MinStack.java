package ds.stack;

import java.util.Stack;

public class MinStack {
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(19);
		minStack.push(10);
		minStack.push(9);
		System.out.println(minStack.getMin());
	}

	private Stack<Integer> stack = new Stack<>();
	private int min = 0;

	public void push(int x) {
		if (stack.isEmpty()) {
			min = x;
			stack.push(x);
		} else {
			if (x >= min) {
				stack.push(x);
			} else {
				int flag = 2 * x - min;
				stack.push(flag);
				min = x;
			}
		}
	}

	public void pop() {
		if (!stack.isEmpty()) {
			if (stack.peek() >= min) {
				stack.pop();
			} else {
				min = 2 * min - stack.peek();
				stack.pop();
			}
		}
	}

	public int top() {
		if (!stack.isEmpty()) {
			if (stack.peek() >= min) {
				return stack.peek();
			}else {
				return 2 * min - stack.peek();
			}
		}
		return -1;
	}

	public int getMin() {
		if (!stack.isEmpty()) {
			return min;
		}
		return -1;
	}
}
