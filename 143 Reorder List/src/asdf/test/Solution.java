package asdf.test;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	/**
	 * (重组链表)Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
	 * L0→Ln→L1→Ln-1→L2→Ln-2→…
	 * 
	 * You must do this in-place without altering the nodes' values.
	 * 
	 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
	 * 
	 */

	// 两个指针，fast是slow的两倍，fast走到头的时候，slow正好走到中间。
	// slow继续走，将后面的元素翻转
	// 从头尾同时出发组合即可
	public void reorderList(ListNode head) {
		ListNode fast = head, slow = head, next;
		// 查找中点为slow
		while (fast != null) {
			fast = fast.next;
			if (fast != null)
				fast = fast.next;
			else
				break;
			slow = slow.next;
		}
		
		// 翻转后面的节点
		if (slow!=null&&slow.next != null) {
			fast = slow.next;
			slow.next = null;
			while (fast != null) {
				next = fast.next;
				fast.next = slow;
				slow = fast;
				fast = next;
			}
			fast = slow;
		}

		// 重组
		slow = head;
		while (fast != null&&fast.next!=null) {
			next = slow.next;
			slow.next = fast;
			slow = next;
			next = fast.next;
			fast.next = slow;
			fast = next;
		}

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(1);
//		ListNode cycle = 
//				head.newNode(2)
//				.newNode(3)
//				;
//		ListNode end = cycle.newNode(4)
//		 .newNode(5)
//		 .newNode(6)
//		;
		ListNode.print(head);
		solution.reorderList(head);
		ListNode.print(head);
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + "]";
	}

	public ListNode newNode(int val) {
		ListNode newNode = new ListNode(val);
		this.next = newNode;
		return newNode;
	}

	public static void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + ",");
			head = head.next;
		}
		System.out.println();
	}

}