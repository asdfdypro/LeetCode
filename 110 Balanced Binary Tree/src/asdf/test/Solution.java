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
	 * (判断是否是平衡二叉树)Given a binary tree, determine if it is height-balanced.
	 * 
	 * For this problem, a height-balanced binary tree is defined as a binary
	 * tree in which the depth of the two subtrees of every node never differ by
	 * more than 1.
	 */
	public boolean isBalanced(TreeNode root) {
		return level(root)[0] > 0;
	}

	// [0]是否平衡 [1]树高
	private int[] level(TreeNode root) {
		if (root == null) {
			int[] res = { 1, 0 };
			return res;
		}

		int[] left = level(root.left);
		if (left[0] <= 0) {
			return left;
		} else {
			int[] right = level(root.right);
			if (right[0] <= 0)
				return right;
			int[] res = new int[2];
			if (Math.abs(left[1] - right[1]) < 2) {
				res[0] = 1;
				res[1] = (left[1] > right[1] ? left[1] : right[1])+1;
			} else
				res[0] = -1;
			return res;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		TreeNode l = new TreeNode(2);
		TreeNode r = new TreeNode(3);
		root.left = l;
		// root.right = r;

		// l.left = new TreeNode(4);
		l.right = new TreeNode(5);

		r.left = new TreeNode(6);
		r.right = new TreeNode(7);

		root.printLevel();

		boolean a = solution.isBalanced(root);
		// boolean a = solution.isBalanced(null);
		System.out.println(a);
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