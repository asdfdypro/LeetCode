package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (翻转链表 ) Reverse a singly linked list.
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode o = head, p = o.next, q = p.next;
		o.next=null;
		while (q != null) {
			p.next = o;
			o = p;
			p = q;
			q = q.next;
		}
		p.next = o;

		return p;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 5,4,2,1,5 };
		ListNode root = ListNode.createList(nums);
		ListNode.print(root);
		root = solution.reverseList(root);
		ListNode.print(root);
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public ListNode setNext(int x) {
		ListNode newNode = new ListNode(x);
		this.next = newNode;
		return newNode;
	}

	public static void print(ListNode root) {
		System.out.println();
		while (root != null) {
			System.out.print(root.val + ",");
			root = root.next;
		}
		System.out.println();
	}

	public static ListNode createList(int[] nums) {
		if (nums.length < 1)
			return null;

		ListNode root = new ListNode(nums[0]);
		ListNode node = root;
		for (int i = 1; i < nums.length; i++) {
			node = node.setNext(nums[i]);
		}
		return root;
	}
}
