package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (归并排序 ) Sort a linked list in O(n log n) time using constant space
	 * complexity.
	 */
	public ListNode sortList(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		// 查找终点
		ListNode slow = head, fast = head.next;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
				slow = slow.next;
			}else{
				break;
			}
		}

		// 切断短链，排序子链
		fast = slow.next;
		slow.next = null;
		slow = sortList(head);
		fast = sortList(fast);

		// 归并
		if (slow.val < fast.val) {
			head = slow;
			slow = slow.next;
		} else {
			head = fast;
			fast = fast.next;
		}
		ListNode p=head;
		while (slow != null && fast != null) {
			if (slow.val < fast.val) {
				p.next = slow;
				slow = slow.next;
			} else {
				p.next = fast;
				fast = fast.next;
			}
			p=p.next;
		}
		if(slow!=null){
			p.next=slow;
		}else{
			p.next=fast;
		}

		return head;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 5,4 };
		ListNode root = ListNode.createList(nums);
		ListNode.print(root);
		root = solution.sortList(root);
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
