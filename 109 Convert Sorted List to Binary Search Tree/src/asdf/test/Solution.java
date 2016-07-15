package asdf.test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/**
	 * (将有序数组转为平衡二叉查找树)Given a singly linked list where elements are sorted in
	 * ascending order, convert it to a height balanced BST.
	 */
	//超时
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return new TreeNode(head.val);
		if (head.next.next == null) {// 头结点
			TreeNode root = new TreeNode(head.val);
			root.right = new TreeNode(head.next.val);
			return root;
		}

		ListNode p = head.next.next.next, q = head;//p是尾部，q是中间点的前一个
		while (p != null) {// p走2步，q走一步
			p = p.next;
			if (p != null) {
				p = p.next;
				q = q.next;
			}
		}		

		p = q.next;
		TreeNode root = new TreeNode(p.val);
		q.next = null;
		q = p.next;
		p.next = null;

		root.left = sortedListToBST(head);
		root.right = sortedListToBST(q);

		return root;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode node = new ListNode(1);
		node.setNextNode(2).setNextNode(3).setNextNode(4).setNextNode(5)
		 .setNextNode(6)
		 .setNextNode(7)
		;
		TreeNode root = solution.sortedListToBST(node);
		root.printLevel();
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public ListNode setNextNode(int x) {
		this.next = new ListNode(x);
		return this.next;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public void print() {
		print(this);
		System.out.println();
	}

	public void printLevel() {
		List<List<Integer>> res = levelOrder(this);
		for (List<Integer> list : res) {
			for (Integer integer : list) {
				System.out.print(integer + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void print(TreeNode root) {
		if (root == null)
			return;

		print(root.left);
		System.out.print(root.val + "\t");
		print(root.right);
	}

	private List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root != null) {
			List<TreeNode> rootList = new ArrayList<TreeNode>();
			rootList.add(root);
			levelOrder(res, rootList);
		}
		return res;
	}

	private void levelOrder(List<List<Integer>> res, List<TreeNode> rootList) {
		List<Integer> resList = new ArrayList<Integer>();
		List<TreeNode> childList = new ArrayList<TreeNode>();
		for (TreeNode node : rootList) {
			resList.add(node.val);
			if (node.left != null)
				childList.add(node.left);
			if (node.right != null)
				childList.add(node.right);
		}
		res.add(resList);
		if (childList.size() > 0)
			levelOrder(res, childList);
	}
}