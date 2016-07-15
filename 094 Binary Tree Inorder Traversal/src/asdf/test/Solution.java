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
	 * (中序遍历,迭代方式)Given a binary tree, return the inorder traversal of its
	 * nodes' values.
	 * 
	 * Note: Recursive solution is trivial, could you do it iteratively?
	 * 
	 */
	// 使用栈实现
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();

		Stack<TreeNode> work = new Stack<TreeNode>();

		TreeNode p = root;
		while (true) {
			if (p == null) {//搜索到底
				if (work.isEmpty())
					break;
				else {
					p = work.pop();
					res.add(p.val);
					p = p.right;//出栈元素必定向右
				}
			} else {

				if (p.left != null) {// 向左
					work.push(p);
					p = p.left;
				} else {
					res.add(p.val);
					p = p.right;
				}

			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		TreeNode root = new TreeNode(1);
		TreeNode l = new TreeNode(2);
		TreeNode r = new TreeNode(3);
		// root.left = l;
		root.right = r;

		// l.left = new TreeNode(4);
		// l.right = new TreeNode(5);

		r.left = new TreeNode(6);
		// r.right = new TreeNode(7);

		List<Integer> res = solution.inorderTraversal(root);
		for (Integer integer : res) {
			System.out.println(integer);
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
}