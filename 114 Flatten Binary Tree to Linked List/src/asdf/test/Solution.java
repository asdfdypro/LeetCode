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
	 * (扁平化一个树)Given a binary tree, flatten it to a linked list in-place.
	 * 
	 * If you notice carefully in the flattened tree, each node's right child
	 * points to the next node of a pre-order traversal.
	 */

	// 前序遍历
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		TreeNode[] now = new TreeNode[1];
		now[0] = root;
		TreeNode right=root.right;
		flatten(root.left, now);
		flatten(right, now);//有可能有子树已经变化
		root.left = null;
		now[0].right = null;
	}

	public void flatten(TreeNode root, TreeNode[] now) {
		if (root == null)
			return;
		now[0].right = root;
		now[0] = root;
		TreeNode right=root.right;
		flatten(root.left, now);
		flatten(right, now);
		root.left = null;
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

		root.printLevel();
		solution.flatten(root);
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