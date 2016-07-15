package asdf.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * (用队列实现堆) Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue. pop() -- Removes the element
 * from in front of queue. peek() -- Get the front element. empty() -- Return
 * whether the queue is empty.
 * 
 * Notes:
 * 
 * You must use only standard operations of a stack -- which means only push to
 * top, peek/pop from top, size, and is empty operations are valid. Depending on
 * your language, stack may not be supported natively. You may simulate a stack
 * by using a list or deque (double-ended queue), as long as you use only
 * standard operations of a stack. You may assume that all operations are valid
 * (for example, no pop or peek operations will be called on an empty queue).
 */
class MyQueue {
	private Stack<Integer> stack;
	private Stack<Integer> temp;

	public MyQueue() {
		stack = new Stack<Integer>();
		temp = new Stack<Integer>();
	}

	// Push element x to the back of queue.
	public void push(int x) {
		while (!stack.empty()) {
			temp.push(stack.pop());
		}
		stack.push(x);
		while (!temp.empty()) {
			stack.push(temp.pop());
		}
	}

	// Removes the element from in front of queue.
	public void pop() {
		stack.pop();
	}

	// Get the front element.
	public int peek() {
		return stack.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return stack.empty();
	}

	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		myQueue.push(1);
		myQueue.push(2);
		myQueue.push(3);
		myQueue.push(4);
		System.out.println(myQueue.peek());
		myQueue.pop();
		System.out.println(myQueue.peek());
		myQueue.pop();
		myQueue.push(5);
		while (!myQueue.empty()) {
			System.out.println(myQueue.peek());
			myQueue.pop();
		}
	}
}
