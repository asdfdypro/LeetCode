package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

	/**
	 * (分割链表) Given a linked list and a value x, partition it such that all
	 * nodes less than x come before nodes greater than or equal to x.
	 * 
	 * You should preserve the original relative order of the nodes in each of
	 * the two partitions.
	 * 
	 * For example,
	 * 
	 * Given 1->4->3->2->5->2 and x = 3,
	 * 
	 * return 1->2->2->4->3->5.
	 */

	public ListNode partition(ListNode head, int x) {
		ListNode lessHold = null, less = null;
		ListNode greaterHold = null, greater = null;
		ListNode p = head;
		while (p != null) {
			if (p.val < x) {
				if (lessHold == null) {
					lessHold = p;
					less = p;
				} else {
					less.next = p;
					less = less.next;
				}
			} else {
				if (greaterHold == null) {
					greaterHold = p;
					greater = p;
				} else {
					greater.next = p;
					greater = greater.next;
				}
			}
			p = p.next;
		}

		
		if (lessHold != null) {
			less.next = greaterHold;
			head = lessHold;
		} else {
			head = greaterHold;
		}
		if(greater!=null){
			greater.next=null;
		}
		
		return head;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head;
		head = new ListNode(1);
//		head.setNext(4).setNext(3).setNext(2).setNext(5).setNext(2);

		print(head);
		head = solution.partition(head, 0);
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