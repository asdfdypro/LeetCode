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
	 * (树的最长路径和) Given a binary tree, find the maximum path sum.
	 * 
	 * For this problem, a path is defined as any sequence of nodes from some
	 * starting node to any node in the tree along the parent-child connections.
	 * The path does not need to go through the root.
	 */

	public int maxPathSum(TreeNode root) {
		int[] max = { Integer.MIN_VALUE };
		maxPathSum(root, max);
		return max[0];
	}

	/**
	 * 返回到达子树根的最大路径长，同时记录过子树根的最大路径和
	 * 
	 * @param root
	 *            树根
	 * @param max
	 *            过子树根的最大路径和
	 */
	private int maxPathSum(TreeNode root, int[] max) {
		if (root == null)
			return 0;

		int l = maxPathSum(root.left, max);
		int r = maxPathSum(root.right, max);

		// 过子树根的最大路径和，一定过根
		int m = root.val;
		if (l > 0)
			m += l;
		if (r > 0)
			m += r;

		if (m > max[0])
			max[0] = m;

		// 到达子树根的最大路径长，一定到根
		m = l > r ? l : r;
		if (m > 0)
			return m + root.val;
		else
			return root.val;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		Integer[] vals = { -1, 2, -3,-4,-5 };
		TreeNode root = TreeNode.createTree(vals);
		System.out.println(solution.maxPathSum(root));

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
}