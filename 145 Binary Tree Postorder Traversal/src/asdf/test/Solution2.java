package asdf.test;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

	/**
	 * (迭代后序遍历 ) Given a binary tree, return the postorder traversal of its
	 * nodes' values.
	 * 
	 * Note: Recursive solution is trivial, could you do it iteratively?
	 */
	// 递归

	// 实测 递归更快
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		postorder(res, root);
		return res;
	}

	private void postorder(List<Integer> res, TreeNode root) {
		if (root == null)
			return;
		postorder(res, root.left);
		postorder(res, root.right);
		res.add(root.val);
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		Integer[] vals = { 1, 2, 3 };
		TreeNode root = TreeNode.createTree(vals);

		List<Integer> res = solution.postorderTraversal(root);
		for (Integer integer : res) {
			System.out.println(integer + ",");
		}
	}
}
