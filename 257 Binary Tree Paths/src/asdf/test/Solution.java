package asdf.test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/**
	 * (所有遍历结果) Given a binary tree, return all root-to-leaf paths.
	 */

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<String>();
		if (root != null)
			binaryTreePaths(res, null, root);
		return res;
	}

	private void binaryTreePaths(List<String> res, String work, TreeNode root) {
		if (root.left == null && root.right == null) {
			if (work == null)
				work = String.valueOf(root.val);
			else
				work = work + "->" + root.val;
			res.add(work);
			return;
		}
		String old = work;
		if (work == null)
			work = String.valueOf(root.val);
		else
			work = work + "->" + root.val;
		if (root.left != null)
			binaryTreePaths(res, work, root.left);
		if (root.right != null)
			binaryTreePaths(res, work, root.right);
		work = old;
	}

	public static void main(String[] args) {
		solution(new Integer[] { 1, 2, 3, null, 5 });

		solution(new Integer[] { 1 });
	}

	private static void solution(Integer[] vals) {
		Solution solution = new Solution();
		List<String> res;
		TreeNode root = TreeNode.createTree(vals);
		res = solution.binaryTreePaths(root);
		for (String integer : res) {
			System.out.print(integer);
			System.out.print(",");
		}
		System.out.println();
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