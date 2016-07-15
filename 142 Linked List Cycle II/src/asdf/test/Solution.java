package asdf.test;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	/**
	 * (链表中的环起始点)Given a linked list, return the node where the cycle begins. If
	 * there is no cycle, return null.
	 * 
	 * Note: Do not modify the linked list.
	 * 
	 * Follow up: Can you solve it without using extra space?
	 * 
	 * 
	 * 
	 * 使用两个指针，fast的速度是slow速度的两倍 开始点X，环开始点Y，从头开始走fast slow交会点Z，XY=a,YZ=b,ZY=c
	 * 
	 * 则：a+n(b+c)=2(a+b)
	 * 
	 * a=c+(n-1)(b+c)
	 * 
	 * 
	 * 1. 环的长度是多少？ 交回后fast再走一圈
	 * 
	 * 2. 如何找到环中第一个节点（即Linked List Cycle II）？ 交回后，从X和Z同时同速走，再次交回在Y
	 * 
	 * 3. 如何将有环的链表变成单链表（解除环）？找到环中第一个节点即可
	 * 
	 * 4. 如何判断两个单链表是否有交点？如何找到第一个相交的节点？
	 * 
	 * 
	 * 另外考虑翻转节点解决
	 * 
	 */

	public ListNode detectCycle(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null) {
			fast = fast.next;
			if (fast == null)
				return null;
			fast = fast.next;
			slow = slow.next;
			if (fast == slow) {// 重新走
				slow = head;
				while (fast != slow) {
					fast = fast.next;
					slow = slow.next;
				}
				return fast;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(1);
		ListNode cycle = head.newNode(2).newNode(3);
		ListNode end = cycle.newNode(4).newNode(5).newNode(6);
		end.next = cycle;

		System.out.println(solution.detectCycle(head));
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