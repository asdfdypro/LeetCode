package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {

	/**
	 * (迭代前序遍历 ) Given a binary tree, return the preorder traversal of its
	 * nodes' values.
	 * 
	 * Note: Recursive solution is trivial, could you do it iteratively?
	 */
	// 使用标志位
	// 向下标志，意味着节点没有访问，访问节点并向左
	// 向上标志，表明节点已经访问，如果节点存在，向右访问，同时删除节点；如果节点不存在，继续向上即可
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		boolean direc = true;// 方向
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null)
			stack.push(root);
		TreeNode node;
		while (!stack.isEmpty()) {
			if (direc) {
				node = stack.peek();
				res.add(node.val);
				if (node.left != null)
					stack.push(node.left);
				else
					direc = false;
			} else {
				node = stack.pop();
				if (node.right != null) {
					direc = true;
					stack.push(node.right);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		Integer[] vals = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode root = TreeNode.createTree(vals);

		List<Integer> res = solution.preorderTraversal(root);
		for (Integer integer : res) {
			System.out.println(integer + ",");
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
		if (vals.length < 1) {
			return null;
		}
		TreeNode[] nodes = new TreeNode[vals.length];
		for (int i = 0; i < vals.length; i++) {
			if (vals[i] != null)
				nodes[i] = new TreeNode(vals[i]);
		}
		for (int i = 0; i < vals.length; i++) {
			if (nodes[i] != null) {
				if (2 * i + 1 < vals.length)
					nodes[i].left = nodes[2 * i + 1];
				if (2 * i + 2 < vals.length)
					nodes[i].right = nodes[2 * i + 2];
			}
		}
		return nodes[0];
	}
}