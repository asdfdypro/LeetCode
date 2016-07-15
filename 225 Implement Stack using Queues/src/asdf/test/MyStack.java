package asdf.test;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

	/**
	 * (用队列实现堆) Implement the following operations of a stack using queues.
	 * 
	 * push(x) -- Push element x onto stack. pop() -- Removes the element on top
	 * of the stack. top() -- Get the top element. empty() -- Return whether the
	 * stack is empty.
	 * 
	 * Notes:
	 * 
	 * You must use only standard operations of a queue -- which means only push
	 * to back, peek/pop from front, size, and is empty operations are valid.
	 * Depending on your language, queue may not be supported natively. You may
	 * simulate a queue by using a list or deque (double-ended queue), as long
	 * as you use only standard operations of a queue. You may assume that all
	 * operations are valid (for example, no pop or top operations will be
	 * called on an empty stack).
	 */

	//pop调整
	Queue<Integer> queue;
	int size;
	Integer last;

	public MyStack() {
		queue = new LinkedList<>();
		size = 0;
		last = null;
	}

	// Push element x onto stack.
	public void push(int x) {
		queue.offer(x);
		size++;
		last = x;
	}

	// Removes the element on top of the stack.
	public void pop() {
		size--;
		if (size == 0) {
			queue.poll();
			last = null;
		} else {
			for (int i = 0; i < size - 1; i++) {
				this.queue.offer(this.queue.poll());
			}
			last = this.queue.poll();
			this.queue.offer(last);
			this.queue.poll();
		}

	}

	// Get the top element.
	public int top() {
		return last;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return size == 0;
	}

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.top());
		stack.push(4);
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.empty());
	}
}
