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
	 * (修复二叉查找树) Two elements of a binary search tree (BST) are swapped by
	 * mistake.
	 * 
	 * Recover the tree without changing its structure. Note: A solution using
	 * O(n) space is pretty straight forward. Could you devise a constant space
	 * solution?
	 * 
	 * 
	 */

	// 只有两个交换了，很好发现
	//注意只有两个元素交换的时候
	//10ms
	public void recoverTree(TreeNode root) {
		Map<String, Object> work = new HashMap<String, Object>();// 存放结果

		recoverTree(root, work);
		TreeNode hold1 = (TreeNode) work.get("hold1");
		TreeNode hold2 = (TreeNode) work.get("hold2");
		if (hold1 != null && hold2 != null) {
			int temp = hold1.val;
			hold1.val = hold2.val;
			hold2.val = temp;
		}

	}

	private void recoverTree(TreeNode root, Map<String, Object> work) {
		if (root == null)
			return;

		recoverTree(root.left, work);
		
		TreeNode pre = (TreeNode) work.get("num");
		if (pre != null && pre.val >= root.val) {// 错误
			if (work.get("hold1") == null)
				work.put("hold1", pre);
			work.put("hold2", root);// 只有两个的情况
		}
		work.put("num", root);
		
		recoverTree(root.right, work);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		TreeNode root = new TreeNode(2);
		TreeNode l = new TreeNode(3);
		TreeNode r = new TreeNode(1);
		root.left = l;
		root.right = r;

		// l.left = new TreeNode(4);
		// l.right = new TreeNode(5);

		// r.left = new TreeNode(6);
		// r.right = new TreeNode(7);

		root.print();
		solution.recoverTree(root);
		root.print();
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
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