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
	 * (将有序数组转为平衡二叉查找树)Given an array where elements are sorted in ascending
	 * order, convert it to a height balanced BST.
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	// 从nums的form到to创建树
	private TreeNode sortedArrayToBST(int[] nums, int from, int to) {
		if (from > to)
			return null;
		if (from == to)
			return new TreeNode(nums[from]);
		int m = (from + to) / 2;
		TreeNode root = new TreeNode(nums[m]);
		root.left = sortedArrayToBST(nums, from, m - 1);
		root.right = sortedArrayToBST(nums, m + 1, to);
		return root;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 1, 2, 3, 4, 5, 6 ,7,8};
		TreeNode root = solution.sortedArrayToBST(nums);
		root.printLevel();
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