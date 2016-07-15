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
	//使用数组存储
	//4 ms
	public void recoverTree(TreeNode root) {
		TreeNode[] work = new TreeNode[3];// 存放结果

		recoverTree(root, work);
		TreeNode hold1 =work[1];
		TreeNode hold2 = work[2];
		if (hold1 != null && hold2 != null) {
			int temp = hold1.val;
			hold1.val = hold2.val;
			hold2.val = temp;
		}

	}

	private void recoverTree(TreeNode root, TreeNode[] work) {
		if (root == null)
			return;

		recoverTree(root.left, work);
		
		TreeNode pre = (TreeNode) work[0];
		if (pre != null && pre.val >= root.val) {// 错误
			if (work[1]== null)
				work[1]= pre;
			work[2]=root;// 只有两个的情况
		}
		work[0]=root;
		
		recoverTree(root.right, work);
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		TreeNode root = new TreeNode(2);
		TreeNode l = new TreeNode(3);
		TreeNode r = new TreeNode(1);
//		root.left = l;
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

