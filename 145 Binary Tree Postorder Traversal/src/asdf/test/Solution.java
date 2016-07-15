package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {

	/**
	 * (迭代后序遍历 ) Given a binary tree, return the postorder traversal of its
	 * nodes' values.
	 * 
	 * Note: Recursive solution is trivial, could you do it iteratively?
	 */
	// 使用标志位
		// 向下标志0，意味着节点没有访问，访问节点并向左
		// 左支向上标志1，表明节点左儿子已经访问，向右访问，
		// 右支向上标志2，表明节点右儿子已经访问，访问根节点，检查根节点与父节点的关系，确定方向值
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		int direc = 0;// 方向 0向下 1从左支向上 2从右支向上
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null)
			stack.push(root);
		TreeNode node;
		while (!stack.isEmpty()) {
			if (direc == 0) {
				node = stack.peek();
				if (node.left != null)
					stack.push(node.left);
				else
					direc = 1;
			} else if (direc == 1) {
				node = stack.peek();
				if (node.right != null) {
					direc = 0;
					stack.push(node.right);
				} else
					direc = 2;
			} else {
				node = stack.pop();
				res.add(node.val);
				if (!stack.isEmpty()&&node == stack.peek().left)
					direc = 1;
				else
					direc = 2;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		Integer[] vals = { };
		TreeNode root = TreeNode.createTree(vals);

		List<Integer> res = solution.postorderTraversal(root);
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