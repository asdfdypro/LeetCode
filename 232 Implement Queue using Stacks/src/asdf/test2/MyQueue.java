package asdf.test2;

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
	Stack<Integer> input = new Stack();
	Stack<Integer> output = new Stack();// 存储正序

	public void push(int x) {
		input.push(x);
	}

	public void pop() {
		peek();
		output.pop();
	}

	public int peek() {
		if (output.empty())
			while (!input.empty())
				output.push(input.pop());
		return output.peek();
	}

	public boolean empty() {
		return input.empty() && output.empty();
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
