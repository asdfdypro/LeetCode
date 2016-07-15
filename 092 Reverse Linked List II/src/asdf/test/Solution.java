package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

	/**
	 * (一段链表翻转) Reverse a linked list from position m to n. Do it in-place and
	 * in one-pass.
	 * 
	 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	 * 
	 * return 1->4->3->2->5->NULL.
	 * 
	 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of
	 * list.
	 */

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null)
			return head;

		ListNode p = head.next, q = head, t;
		ListNode hold1, hold2;

		n = n - m;
		if (m > 1) {
			m -= 2;
			while (m-- > 0) {
				p = p.next;
				q = q.next;
			}
			hold1 = q;
			hold2 = p;
			p = p.next;
			q = q.next;
		} else {
			hold1 = null;
			hold2 = head;
		}

		while (n-- > 0) {
			t = p.next;
			p.next = q;
			q = p;
			p = t;
		}
		if (hold1 == null)// 头结点
			head = q;
		else
			hold1.next = q;
		hold2.next = p;

		return head;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head;
		head = new ListNode(1);
//		head.setNext(2).setNext(3).setNext(4).setNext(5).setNext(6);

		print(head);
		head = solution.reverseBetween(head, 1,1);
		print(head);

	}

	private static void print(ListNode head) {
		while (head != null) {
			System.out.print(head);
			head = head.next;
		}
		System.out.println();
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public ListNode setNext(int x) {
		ListNode n = new ListNode(x);
		this.next = n;
		return n;
	}

	@Override
	public String toString() {
		return val + " ,";
	}

}