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
	 * (层次输出,从下向上)Given a binary tree, return the bottom-up level order traversal of
	 * its nodes' values. (ie, from left to right, level by level from leaf to
	 * root).
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root != null) {
			List<TreeNode> rootList = new ArrayList<TreeNode>();
			rootList.add(root);
			levelOrderBottom(res, rootList);
		}
		return res;
	}

	public void levelOrderBottom(List<List<Integer>> res, List<TreeNode> rootList) {
		List<Integer> resList = new ArrayList<Integer>();
		List<TreeNode> childList = new ArrayList<TreeNode>();
		for (TreeNode node : rootList) {
			resList.add(node.val);
			if (node.left != null)
				childList.add(node.left);
			if (node.right != null)
				childList.add(node.right);
		}
		res.add(0,resList);//向前添加
		if (childList.size() > 0)
			levelOrderBottom(res, childList);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		TreeNode root = new TreeNode(1);
		TreeNode l = new TreeNode(2);
		TreeNode r = new TreeNode(3);
		root.left = l;
		root.right = r;

		l.left = new TreeNode(4);
		l.right = new TreeNode(5);

		r.left = new TreeNode(6);
		r.right = new TreeNode(7);

		root.print();
		List<List<Integer>> res = solution.levelOrderBottom(root);
		for (List<Integer> list : res) {
			for (Integer integer : list) {
				System.out.print(integer + "\t");
			}
			System.out.println();
		}
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