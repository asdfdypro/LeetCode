package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (插入排序 ) Sort a linked list using insertion sort.
	 */
	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return null;

		ListNode root = head, p, q;
		head = head.next;
		root.next=null;
		while (head != null) {
			// 插入根
			if (head.val <= root.val) {
				p = head.next;
				head.next = root;
				root = head;
				head = p;
			} else { // 向后插入
				q = root;
				p = root.next;
				while (p != null) {
					if (head.val > p.val) {
						p = p.next;
						q = q.next;
					} else {
						q.next = head;
						q = head;
						head = head.next;
						q.next = p;
						break;
					}
				}
				// 插入末尾
				if (p == null) {
					q.next = head;
					head = head.next;
					q.next.next = null;
				}
			}
		}
		return root;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { };
		ListNode root = ListNode.createList(nums);
		ListNode.print(root);
		root=solution.insertionSortList(root);
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
