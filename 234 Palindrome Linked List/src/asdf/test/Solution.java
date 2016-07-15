package asdf.test;

public class Solution {

	/**
	 * (判断链表是否是回文串) Given a singly linked list, determine if it is a palindrome.
	 * 
	 * Follow up: Could you do it in O(n) time and O(1) space?
	 */

	// 两个指针找到中点，翻转后半截，判断，再翻转
	public boolean isPalindrome(ListNode head) {
		
		if (head == null || head.next == null)
			return true;
		ListNode slow = head, fast = head;
		ListNode last, hold = null;// 用于恢复时链接
		while (fast.next != null) {
			fast = fast.next;
			if (fast.next != null) {
				fast = fast.next;
			} else {// 偶数结束,为了复原
				hold = slow;
				slow = slow.next;
				hold.next = null;
				break;
			}
			slow = slow.next;
		}

		last = reverse(slow);// 翻转
		fast=last;

		boolean res = true;
		while (head != null) {
			if (head.val != last.val) {
				res = false;
				break;
			}
			head = head.next;
			last = last.next;
		}
		
		slow = reverse(fast);
		if (hold != null)
			hold.next = slow;

		return res;
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = head.next, q = p.next;
		head.next = null;
		while (p != null) {
			p.next = head;
			head = p;
			p = q;
			if (p != null)
				q = p.next;
		}
		return head;

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isPalindrome(ListNode.createList(new int[] {})));
		System.out.println(solution.isPalindrome(ListNode.createList(new int[] { 0 })));
		System.out.println(solution.isPalindrome(ListNode.createList(new int[] { 1, 1 })));
		System.out.println(solution.isPalindrome(ListNode.createList(new int[] { 1, 2 })));
		System.out.println(solution.isPalindrome(ListNode.createList(new int[] { 1, 2, 1 })));
		System.out.println(solution.isPalindrome(ListNode.createList(new int[] { 1, 2, 2 })));
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
