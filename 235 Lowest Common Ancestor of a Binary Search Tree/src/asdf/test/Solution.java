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
	 * (二叉搜索树中的最近公共祖先) Given a binary search tree (BST), find the lowest common
	 * ancestor (LCA) of two given nodes in the BST.
	 * 
	 * According to the definition of LCA on Wikipedia: “The lowest common
	 * ancestor is defined between two nodes v and w as the lowest node in T
	 * that has both v and w as descendants (where we allow a node to be a
	 * descendant of itself).”
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (p == q)
			return p;
		TreeNode min = p.val < q.val ? p : q;
		TreeNode max = p.val > q.val ? p : q;
		if (root.val < min.val)
			return lowestCommonAncestor(root.right, p, q);
		else if (root.val > max.val)
			return lowestCommonAncestor(root.left, p, q);
		else
			return root;

	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		Integer[] vals = { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 };
		TreeNode root = TreeNode.createTree(vals);
		System.out.println(solution.lowestCommonAncestor(root, root.nodes[1], root.nodes[2]).val);

		System.out.println(solution.lowestCommonAncestor(root, root.nodes[1], root.nodes[4]).val);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public static TreeNode[] nodes;

	TreeNode(int x) {
		val = x;
	}

	public static TreeNode createTree(Integer[] vals) {
		nodes = new TreeNode[vals.length];
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