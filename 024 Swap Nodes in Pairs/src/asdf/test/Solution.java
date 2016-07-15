package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	/**
	 * (交换元素)Given a linked list, swap every two adjacent nodes and return its
	 * head.
	 * 
	 * For example,
	 * 
	 * Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * 
	 * Your algorithm should use only constant space. You may not modify the
	 * values in the list, only nodes itself can be changed.
	 */

	public ListNode swapPairs(ListNode head) {
		// 特殊情况
		if (head == null || head.next == null)
			return head;
		ListNode p, q, t = null;
		// 头两个，head的
		q = head;
		head = head.next;
		p = head.next;
		head.next = q;
		q.next = p;

		if (p != null)
			t = p.next;
		while (p != null && t != null) {
			p.next = t.next;
			t.next = p;
			q.next = t;
			q = p;
			p = p.next;
			if (p != null)
				t = p.next;
		}
		return head;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = null;

		solution.swapPairs(head);

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}