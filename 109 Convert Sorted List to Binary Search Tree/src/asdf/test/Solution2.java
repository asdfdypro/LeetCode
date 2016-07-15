package asdf.test;

public class Solution2 {

	/**
	 * (将有序数组转为平衡二叉查找树)Given a singly linked list where elements are sorted in
	 * ascending order, convert it to a height balanced BST.
	 */
	// 深度优先，减少链表扫描

	public TreeNode sortedListToBST(ListNode head) {
		int num = 0;
		ListNode p = head;

		while (p != null) {
			p = p.next;
			num++;
		}
		ListNode[] h = new ListNode[1];
		h[0] = head;
		return sortedListToBST(h, 1, num);
	}

	public TreeNode sortedListToBST(ListNode[] head, int from, int to) {
		if (from > to)
			return null;
		if (from == to) {
			TreeNode root = new TreeNode(head[0].val);
			head[0] = head[0].next;
			return root;
		}

		int m = (from + to) / 2;
		TreeNode left = sortedListToBST(head, from, m - 1);
		TreeNode root = new TreeNode(head[0].val);
		root.left = left;
		head[0] = head[0].next;
		root.right = sortedListToBST(head, m + 1, to);

		return root;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		ListNode node = new ListNode(1);
		node.setNextNode(2).setNextNode(3).setNextNode(4).setNextNode(5).setNextNode(6)
				.setNextNode(7);
		TreeNode root = solution.sortedListToBST(node);
		root.printLevel();
	}
}
