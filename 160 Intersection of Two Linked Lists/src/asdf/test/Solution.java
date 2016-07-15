package asdf.test;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	/**
	 * (发现两个链表合并点)Write a program to find the node at which the intersection of
	 * two singly linked lists begins.
	 * 
	 * 
	 * 
	 * Notes:
	 * 
	 * If the two linked lists have no intersection at all, return null.
	 * 
	 * The linked lists must retain their original structure after the function
	 * returns.
	 * 
	 * You may assume there are no cycles anywhere in the entire linked
	 * structure.
	 * 
	 * Your code should preferably run in O(n) time and use only O(1) memory.
	 * 
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = 0, lenB = 0;
		ListNode a = headA, b = headB;
		//计算长度
		while (a != null) {
			lenA++;
			a = a.next;
		}
		while (b != null) {
			lenB++;
			b = b.next;
		}
		
		//先走前面的
		 a = headA; b = headB;
		while(lenA<lenB){
			lenB--;
			b = b.next;
		}
		while(lenA>lenB){
			lenA--;
			a = a.next;
		}
		//一起走
		while(a!=b&&a!=null&&b!=null){
			b = b.next;
			a = a.next;
		}
		return a;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode headA = new ListNode(1);
		ListNode a = headA.newNode(2);
		ListNode headB = new ListNode(3);
		ListNode b = headB.newNode(4);
		ListNode head = new ListNode(5);
		head.newNode(6).newNode(7);
		a.next = head;
		b.next = head;

		ListNode.print(headA);
		ListNode.print(headB);

		System.out.println(solution.getIntersectionNode(headA, headB));

		System.out.println(solution.getIntersectionNode(null, null));
		
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	public ListNode newNode(int val) {
		ListNode newNode = new ListNode(val);
		this.next = newNode;
		return newNode;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + "]";
	}

	public static void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + ",");
			head = head.next;
		}
		System.out.println();
	}
}