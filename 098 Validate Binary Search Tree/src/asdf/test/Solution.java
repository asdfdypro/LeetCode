package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Solution {

	/**
	 * (验证二叉搜索树) Given a binary tree, determine if it is a valid binary search
	 * tree (BST).
	 * 
	 * Assume a BST is defined as follows:
	 * 
	 * The left subtree of a node contains only nodes with keys less than the
	 * node's key. The right subtree of a node contains only nodes with keys
	 * greater than the node's key. Both the left and right subtrees must also
	 * be binary search trees.
	 * 
	 * 
	 */

	// 搜索树的中序遍历是递增的
	// 不能相等
	// 初始最小数会有问题
	public boolean isValidBST(TreeNode root) {
		List<Integer> n = new ArrayList<Integer>(1);
		return validBST(root, n);
	}

	private boolean validBST(TreeNode root, List<Integer> n) {
		if (root == null)
			return true;

		if (validBST(root.left, n)) {
			if (n.size() == 0)
				n.add(root.val);
			else {
				if (n.get(0) >= root.val)// 不能相等
					return false;
				n.set(0, root.val);
			}
			if (validBST(root.right, n))
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		TreeNode root = new TreeNode(1);
		TreeNode l = new TreeNode(1);
		// TreeNode r = new TreeNode(3);
		root.left = l;
		// root.right = r;

		// l.left = new TreeNode(4);
		// l.right = new TreeNode(5);

		// r.left = new TreeNode(6);
		// r.right = new TreeNode(7);

		System.out.println(solution.isValidBST(root));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}