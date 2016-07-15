package asdf.test;


public class Solution {

	/**
	 * (移除元素 ) Remove all elements from a linked list of integers that have
	 * value val.
	 * 
	 * Example Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
	 * 
	 * Return: 1 --> 2 --> 3 --> 4 --> 5
	 */

	// 移除所有元素
	public ListNode removeElements(ListNode head, int val) {
		while (head != null && head.val == val) {
			head = head.next;
		}
		if (head == null) {
			return head;
		}

		ListNode p = head, q = head.next;
		while (q != null) {
			while (q != null&&q.val != val) {
				q = q.next;
				p = p.next;
			}
			if (q != null) {
				p.next = q.next;
				q = q.next;
			}
		}

		return head;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 1, 1 };
		ListNode root = ListNode.createList(nums);
		ListNode.print(root);
		root = solution.removeElements(root, 2);
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
