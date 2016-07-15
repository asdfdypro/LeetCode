package asdf.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {
	/**
	 * (设计一个栈)Design a stack that supports push, pop, top, and retrieving the
	 * minimum element in constant time.
	 * 
	 * push(x) -- Push element x onto stack. pop() -- Removes the element on top
	 * of the stack. top() -- Get the top element. getMin() -- Retrieve the
	 * minimum element in the stack.
	 * 
	 */

	int count = 0;
	List<Integer> storage = new ArrayList<Integer>();
	List<Integer> minStorage = new ArrayList<Integer>();
	int min = Integer.MAX_VALUE;

	public void push(int x) {
		count++;
		min = min < x ? min : x;
		storage.add(x);
		minStorage.add(min);
	}

	public void pop() {
		count--;
		storage.remove(count);
		minStorage.remove(count);
		min = getMin();
	}

	public int top() {
		return storage.get(count - 1);
	}

	public int getMin() {
		if (count == 0)
			return Integer.MAX_VALUE;
		else
			return minStorage.get(count - 1);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

	}

}
