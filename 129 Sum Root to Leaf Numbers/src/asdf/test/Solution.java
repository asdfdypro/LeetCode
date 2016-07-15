package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {

	/**
	 * (路径和) Given a binary tree containing digits from 0-9 only, each
	 * root-to-leaf path could represent a number.
	 * 
	 * An example is the root-to-leaf path 1->2->3 which represents the number
	 * 123.
	 * 
	 * Find the total sum of all root-to-leaf numbers.
	 */
	
	// 搜索
	
	//注意list的remove操作
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;

		List<Integer> work = new ArrayList<>();
		return search(root, work);

	}

	// 返回当前子树的最大路径和
	private int search(TreeNode root, List<Integer> work) {
		int res = 0;
		if (root.left == null && root.right == null) {// 叶节点
			for (Integer num : work) {
				res = res * 10 + num;
			}
			res = res * 10 + root.val;
			System.out.println(res);
		} else {
			work.add(root.val);
			if (root.left != null)
				res += search(root.left, work);
			if (root.right != null)
				res += search(root.right, work);
			work.remove(work.size()-1);
		}

		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		Integer[] vals = {3,1,4,3,9,null,null,1,5};
		TreeNode root = TreeNode.createTree(vals);
		System.out.println(solution.sumNumbers(root));

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
		if (vals.length == 0)
			return null;
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
