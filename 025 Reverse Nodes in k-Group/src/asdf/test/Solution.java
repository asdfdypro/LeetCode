package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	/**
	 * (每K个翻转) Given a linked list, reverse the nodes of a linked list k at a
	 * time and return its modified list.
	 * 
	 * If the number of nodes is not a multiple of k then left-out nodes in the
	 * end should remain as it is.
	 * 
	 * You may not alter the values in the nodes, only nodes itself may be
	 * changed.
	 * 
	 * Only constant memory is allowed.
	 * 
	 * For example, Given this linked list: 1->2->3->4->5
	 * 
	 * For k = 2, you should return: 2->1->4->3->5
	 * 
	 * For k = 3, you should return: 3->2->1->4->5
	 */

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null||head.next == null  || k == 1)
			return head;

		ListNode hold = null, prehold = null, p, q, t;
		int n = 1;
		p = head;
		q = head.next;

		while (q != null) {
			if (n == k) {
				if (hold == null) {
					hold = head;
					head = p;
					prehold = q;
				} else {
					hold.next = p;
					hold = prehold;
					prehold = q;
				}
				p = q;
				q = q.next;
				n = 1;
			} else {
				t = q.next;
				q.next = p;
				p = q;
				q = t;
				n++;
			}
		}
		// 收尾
		if (n == k) {
			if (hold == null) {
				head.next = null;
				head = p;
			} else {
				hold.next = p;
				prehold.next = null;
			}
		} else {// 恢复
			if (hold == null) {
				prehold = head;
			} else {
				hold.next = prehold;
			}
			q = p.next;
			p.next = null;
			while (q != prehold&&q!=null) {
				t = q.next;
				q.next = p;
				p = q;
				q = t;
			}

		}
		return head;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(0);
		 head.next=new ListNode(1);

		ListNode h = solution.reverseKGroup(head, 3);
		while (h != null) {
			System.out.println(h.val);
			h = h.next;
		}

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}