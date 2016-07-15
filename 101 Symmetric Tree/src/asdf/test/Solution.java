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
	 * (判断二叉树是否对称)Given a binary tree, check whether it is a mirror of itself
	 * (ie, symmetric around its center).
	 * 
	 */
	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root);
	}

	public boolean isSymmetric(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		else if (p != null && q != null)
			return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
		else
			return false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		TreeNode root = new TreeNode(1);
		TreeNode l = new TreeNode(2);
		TreeNode r = new TreeNode(3);
		// root.left = l;
		root.right = r;

		// l.left = new TreeNode(4);
		// l.right = new TreeNode(5);

		r.left = new TreeNode(6);
		// r.right = new TreeNode(7);

		System.out.println(solution.isSymmetric(root));
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

	private static void print(TreeNode root) {
		if (root == null)
			return;

		print(root.left);
		System.out.print(root.val + "\t");
		print(root.right);
	}
}