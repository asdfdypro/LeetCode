package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {

	/**
	 * (翻转二叉树)Invert a binary tree.
	 */
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode treeNode = root.left;
		root.left = root.right;
		root.right = treeNode;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		Integer[] vals = { 1, 2, 3, 4, 5, 6 };
		TreeNode root = TreeNode.createTree(vals);
		root.print();
		solution.invertTree(root).print();
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public static TreeNode createTree(Integer[] vals) {
		TreeNode[] nodes = new TreeNode[vals.length];
		for (int i = 0; i < vals.length; i++) {
			if (vals[i] != null)
				nodes[i] = new TreeNode(vals[i]);
		}
		for (int i = 0; i < vals.length; i++) {
			if (2 * i + 1 < vals.length)
				nodes[i].left = nodes[2 * i + 1];
			if (2 * i + 2 < vals.length)
				nodes[i].right = nodes[2 * i + 2];
		}
		return nodes[0];
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