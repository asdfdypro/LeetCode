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

public class Solution2 {

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
	
	//优化work实现
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;

		return search(root, 0);

	}

	// 返回当前子树的最大路径和
	private int search(TreeNode root, int work) {
		int res = 0;
		if (root.left == null && root.right == null) {// 叶节点
			res = work * 10 + root.val;
		} else {
			work=work * 10+ root.val;
			if (root.left != null)
				res += search(root.left, work);
			if (root.right != null)
				res += search(root.right, work);
		}

		return res;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		Integer[] vals = {3,1,4,3,9,null,null,1,5};
		TreeNode root = TreeNode.createTree(vals);
		System.out.println(solution.sumNumbers(root));

	}

}
