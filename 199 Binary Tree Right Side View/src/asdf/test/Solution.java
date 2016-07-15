package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {

	/**
	 * (树的右视图)Given a binary tree, imagine yourself standing on the right side
	 * of it, return the values of the nodes you can see ordered from top to
	 * bottom.
	 * 
	 * For example: Given the following binary tree,
	 * 
	 * 1 <---
	 * 
	 * / \
	 * 
	 * 2 3 <---
	 * 
	 * \ \
	 * 
	 * 5 4 <---
	 * 
	 * You should return [1, 3, 4].
	 */

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root != null) {

			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			queue.offer(null);
			TreeNode node;
			while (!queue.isEmpty()) {
				node = queue.poll();
				if (node == null) {
					continue;
				}

				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				if (queue.peek() == null) {
					res.add(node.val);
					queue.offer(null);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		Integer[] vals = { 1, 2, 3, 6, 5 };
		TreeNode root = TreeNode.createTree(vals);
		List<Integer> res = solution.rightSideView(root);
		for (Integer integer : res) {
			System.out.print(integer);
			System.out.print("=");
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