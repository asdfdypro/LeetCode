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
	 * (是否存在满足目标值的路线)Given a binary tree and a sum, determine if the tree has a
	 * root-to-leaf path such that adding up all the values along the path
	 * equals the given sum.
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		return hasPathSum(root, sum, 0);
	}

	// 当前根，目标和，当前和
	private boolean hasPathSum(TreeNode root, int sum, int now) {
		if (root.left == null && root.right == null)// 叶子
			if (sum == now + root.val)
				return true;
			else
				return false;
		if (root.right == null)
			return hasPathSum(root.left, sum, now + root.val);
		if (root.left == null)
			return hasPathSum(root.right, sum, now + root.val);
		return hasPathSum(root.left, sum, now + root.val)
				|| hasPathSum(root.right, sum, now + root.val);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		TreeNode l = new TreeNode(2);
		TreeNode r = new TreeNode(3);
		root.left = l;
//		root.right = r;

//		l.left = new TreeNode(4);
//		l.right = new TreeNode(5);
		//
		r.left = new TreeNode(6);
		r.right = new TreeNode(7);

		root.printLevel();

		boolean a = solution.hasPathSum(root, 1);
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