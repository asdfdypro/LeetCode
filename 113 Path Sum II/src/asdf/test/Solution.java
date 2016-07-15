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
	 * (是否存在满足目标值的路线,给出所有结果)Given a binary tree and a sum, find all root-to-leaf
	 * paths where each path's sum equals the given sum
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;

		List<Integer> work = new ArrayList<Integer>();
		pathSum(res, work, root, sum, 0);
		return res;
	}

	// 结果集， 工作空间，当前根，目标和，当前和
	private void pathSum(List<List<Integer>> res, List<Integer> work, TreeNode root, int sum,
			int now) {
		if (root.left == null && root.right == null)// 叶子
			if (sum == now + root.val) {
				work.add(root.val);
				res.add(new ArrayList<Integer>(work));
				work.remove(work.size() - 1);
				return;
			}

		if (root.left != null) {
			work.add(root.val);
			pathSum(res, work, root.left, sum, now + root.val);
			work.remove(work.size() - 1);
		}

		if (root.right != null) {
			work.add(root.val);
			pathSum(res, work, root.right, sum, now + root.val);
			work.remove(work.size() - 1);
		}
		return;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		TreeNode l = new TreeNode(2);
		TreeNode r = new TreeNode(2);
		root.left = l;
		 root.right = r;

		// l.left = new TreeNode(4);
		// l.right = new TreeNode(5);
		//
//		r.left = new TreeNode(6);
//		r.right = new TreeNode(7);

		root.printLevel();

		List<List<Integer>> a = solution.pathSum(root, 3);
		System.out.println(a.size());
		for (List<Integer> list : a) {
			for (Integer integer : list) {
				System.out.print(integer);
				System.out.print("\t");
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