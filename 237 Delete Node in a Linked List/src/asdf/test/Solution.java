package asdf.test;

public class Solution {

	/**
	 * (删除节点) Write a function to delete a node (except the tail) in a singly
	 * linked list, given only access to that node.
	 * 
	 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third
	 * node with value 3, the linked list should become 1 -> 2 -> 4 after
	 * calling your function.
	 */
	// 用下一个替换
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode root = ListNode.createList(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		ListNode.print(root);
		solution.deleteNode(root);
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
