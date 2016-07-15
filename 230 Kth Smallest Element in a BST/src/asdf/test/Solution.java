package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {

	/**
	 * (二叉搜索树中第k个元素)Given a binary search tree, write a function kthSmallest to
	 * find the kth smallest element in it.
	 * 
	 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
	 * 
	 * Follow up: What if the BST is modified (insert/delete operations) often
	 * and you need to find the kth smallest frequently? How would you optimize
	 * the kthSmallest routine?
	 * 
	 * Hint:
	 * 
	 * Try to utilize the property of a BST. What if you could modify the BST
	 * node's structure? The optimal runtime complexity is O(height of BST).
	 */
	public int kthSmallest(TreeNode root, int k) {
		int countLeft = countNode(root.left);
		if (k <= countLeft) {
			return kthSmallest(root.left, k);
		} else if (k > countLeft + 1) {
			return kthSmallest(root.right, k - 1 - countLeft); 
		}
		return root.val;
	}

	public int countNode(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + countNode(root.left) + countNode(root.right);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		Integer[] vals = { 4, 2, 6, 1, 3, 5 };
		TreeNode root = TreeNode.createTree(vals);
		System.out.println(solution.kthSmallest(root, 2));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public static TreeNode createTree(Integer[] vals) {
		TreeNode[] nodes = new TreeNode[vals.length];
		for (int i = 0; i < vals.length; i++) {
			if (vals[i] != null)
				nodes[i] = new TreeNode(vals[i]);
		}
		for (int i = 0; i < vals.length; i++) {
			if (2 * i + 1 < vals.length)
				nodes[i].left = nodes[2 * i + 1];
			if (2 * i + 2 < vals.length)
				nodes[i].right = nodes[2 * i + 2];
		}
		return nodes[0];
	}

	public void print() {
		print(this);
		System.out.println();
	}

	private static void print(TreeNode root) {
		if (root == null)
			return;

		print(root.left);
		System.out.print(root.val + "\t");
		print(root.right);
	}

}