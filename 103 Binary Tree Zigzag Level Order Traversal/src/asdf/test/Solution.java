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
	 * (Z字型层次输出)Given a binary tree, return the zigzag level order traversal of
	 * its nodes' values. (ie, from left to right, then right to left for the
	 * next level and alternate between).
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root != null) {
			List<TreeNode> rootList = new ArrayList<TreeNode>();
			rootList.add(root);
			zigzagLevelOrder(res, rootList, true);
		}
		return res;
	}

	public void zigzagLevelOrder(List<List<Integer>> res, List<TreeNode> rootList, boolean direction) {
		List<Integer> resList = new ArrayList<Integer>();
		List<TreeNode> childList = new ArrayList<TreeNode>();
		TreeNode node;
		for (int i = rootList.size() - 1; i >= 0; i--) {
			node = rootList.get(i);
			resList.add(node.val);
			if (direction) {
				if (node.left != null)
					childList.add(node.left);
				if (node.right != null)
					childList.add(node.right);
			} else {
				if (node.right != null)
					childList.add(node.right);
				if (node.left != null)
					childList.add(node.left);
			}

		}
		res.add(resList);
		if (childList.size() > 0)
			zigzagLevelOrder(res, childList, !direction);
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
		List<List<Integer>> res = solution.zigzagLevelOrder(root);
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