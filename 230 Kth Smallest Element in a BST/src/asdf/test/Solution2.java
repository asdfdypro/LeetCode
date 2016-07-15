package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution2 {

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
	// 非递归
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> st = new Stack<>();

		// 中序遍历
		while (root != null) {
			st.push(root);
			root = root.left;
		}

		while (k != 0) {
			TreeNode n = st.pop();
			k--;
			if (k == 0)
				return n.val;
			TreeNode right = n.right;
			while (right != null) {
				st.push(right);
				right = right.left;
			}
		}

		return -1; // never hit if k is valid
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		Integer[] vals = { 4, 2, 6, 1, 3, 5 };
		TreeNode root = TreeNode.createTree(vals);
		System.out.println(solution.kthSmallest(root, 2));
	}
}
