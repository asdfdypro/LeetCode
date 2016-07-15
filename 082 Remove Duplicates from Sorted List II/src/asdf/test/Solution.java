package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

	/**
	 * (删除重复元素，只保留出现一次的元素) Given a sorted linked list, delete all nodes that
	 * have duplicate numbers, leaving only distinct numbers from the original
	 * list.
	 * 
	 * For example, Given 1->2->3->3->4->4->5, return 1->2->5.
	 * 
	 * Given 1->1->1->2->3, return 2->3.
	 */

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;

		int m = head.val;
		ListNode q = head, p = head.next;
		boolean isOk = true;
		head=null;

		while (p != null) {
			if (p.val == m) {
				isOk = false;
			} else {
				if (isOk) {
					if (head == null) {
						q.val = m;
						head=q;
					} else {
						q.next.val = m;
						q = q.next;
					}
				}
				isOk = true;
				m = p.val;
			}
			p = p.next;
		}
		if (isOk) {
			if (head == null) {				
				q.val = m;
				q.next=null;			
				head=q;
			} else {
				q.next.val = m;
				q.next.next=null;
			}
		}else{//收尾
			if (head != null) {
				q.next=null;
			}
		}

		return head;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head;
		head = new ListNode(1);
		head
//		.setNext(1)
		.setNext(2).setNext(2)
//		.setNext(3).setNext(4)
		;

		print(head);
		head = solution.deleteDuplicates(head);
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